package com.francisco.repasocinturon.controllers;

import com.francisco.repasocinturon.models.Event;
import com.francisco.repasocinturon.models.Message;
import com.francisco.repasocinturon.models.User;
import com.francisco.repasocinturon.services.EventService;
import com.francisco.repasocinturon.services.MessageService;
import com.francisco.repasocinturon.services.UserService;
import com.francisco.repasocinturon.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;
    private final EventService eventService;
    private final MessageService messageService;

    public UserController(UserService userService, UserValidator userValidator, EventService eventService, MessageService messageService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.eventService = eventService;
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String registerForm(
            @ModelAttribute("user") User user) {
        return "registrationAndLogin.jsp";
    }

    @PostMapping("/")
    public String createUser(
            @Valid
            @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return "registrationAndLogin.jsp";
        }
        if(userService.emailExist(user.getEmail())){
            FieldError error = new FieldError("email","email", "El email " + user.getEmail() + " ya se encuentra en la base de datos");
            result.addError(error);
            return "registrationAndLogin.jsp";
        }
        User users = userService.registerUser(user);
        session.setAttribute("userId", users.getId());
        return "redirect:/events";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password, HttpSession session) {
        boolean isAuthenticated = userService.authenticateUser(email, password);//autentica el usuario y la contraseña
        if(isAuthenticated){
            User users = userService.findByEmail(email);
            session.setAttribute("userId", users.getId());
            return "redirect:/events";
        }
        else{
            session.setAttribute("error", "Invalid Credentials. Please thy again.");
            return "redirect:/";
        }
    }

    @GetMapping("/events")
    public String events(HttpSession session, Model model,
            @ModelAttribute("evento") Event eventNew) {
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        } else {
            Long hostId = (Long) session.getAttribute("userId");
            User host = userService.findById(hostId);
            List<Event> stateNotContaining = eventService.findByStateNot(host.getState());//obtiene todos los eventos de diferentes estados del host
            List<Event> stateContaining = eventService.findByState(host.getState());//obtiene todos los eventos del mismo estado del host
            model.addAttribute("user", host);
            model.addAttribute("stateNotContaining", stateNotContaining);
            model.addAttribute("stateContaining", stateContaining);
            return "events.jsp";
        }
    }

    @PostMapping("/events")
    public String createEvents(
            @Valid
            @ModelAttribute("evento")Event evento, BindingResult result,//pegaitos como perro
            Model model, HttpSession session){
            User user = userService.findById((Long) session.getAttribute("userId"));
            Long hostId = (Long) session.getAttribute("userId");
            User host = userService.findById(hostId);
        if(result.hasErrors()){
            List<Event> stateNotContaining = eventService.findByStateNot(host.getState());
            List<Event> stateContaining = eventService.findByState(host.getState());
            model.addAttribute("user", host);
            model.addAttribute("stateNotContaining", stateNotContaining);
            model.addAttribute("stateContaining", stateContaining);
            return "events.jsp";
        }else{
            Event event = eventService.createOrUpdate(evento);
            event.setHost(host);
            event.joinUser(host);
            eventService.createOrUpdate(event);
            return "redirect:/events";
        }
    }

    @GetMapping("/events/{id}")
    public String detailsEvent(
            @PathVariable("id") Long eventId, Model model,
            @ModelAttribute("messagedescription")Message message, HttpSession session) {
        Event event = eventService.findById(eventId);//obtener listas
        List<Message> messages = event.getMessages();//obtener listas
        String datosString = "";
        for(Message message1 : messages){
            datosString += message1.getUser().getFirstname() + ": "+ message1.getDescription() + "\n"+"--------------------------------------" + "\n";
        }
        if (session.getAttribute("userId") == null){
            return "redirect:/";
        }else{
            User user = userService.findById((Long) session.getAttribute("userId"));
            model.addAttribute("datosString", datosString);
            model.addAttribute("event", event);
            return "showEvent.jsp";
        }
    }

    @PostMapping("/events/{idEvent}")
    public String message(
            @PathVariable("idEvent")Long eventId,
            @Valid
            @ModelAttribute("messagedescription")Message message, BindingResult result, Model model,
            HttpSession session){
        User user = userService.findById((Long) session.getAttribute("userId"));
        Event event = eventService.findById(eventId);
    if(result.hasErrors()) {
        model.addAttribute("event", event);
            return "showEvent.jsp";
    }
    else{
        message.setEvent(event);
        message.setUser(user);
        messageService.createOrUpdate(message);
        return "redirect:/events/"+eventId;
        }
    }

    @GetMapping("/events/{idE}/edit")
    public String editEvent(
            @PathVariable("idE")Long idE, Model model,HttpSession session){
        if (session.getAttribute("userId") == null) {
            return "redirect:/";
        }else {
            Event event = eventService.findById(idE);
            model.addAttribute("evento", event);
            User user = userService.findById((Long) session.getAttribute("userId"));
            return "editEvents.jsp";
        }
    }


    @PutMapping("/events/{idE}/edit")
    public String detailsEvent(
            @PathVariable("idE")Long idE,
            @Valid
            @ModelAttribute("evento")Event evento, BindingResult result,//pegaitos como perro
            Model model){
        if(result.hasErrors()){
            return "editEvents.jsp";
        }else{
            Event event = eventService.findById(idE);
            event.setName(evento.getName());
            event.setDate(evento.getDate());
            event.setLocation(evento.getLocation());
            event.setState(evento.getState());
            eventService.createOrUpdate(event);
            model.addAttribute("evento", event);
            return "redirect:/events/"+idE;
        }
    }

    @DeleteMapping("/events/delete/{deleteIdEvent}")
    public String deleteEvent(
            @PathVariable("deleteIdEvent")Long deleteIdEvent){
        Event event = eventService.findById(deleteIdEvent);
        List<User> usuariosAsisten = event.getUsuariosAsisten();
        List<Message> messages = event.getMessages();
        for (User user: usuariosAsisten) {
            user.getEventosAsiste().remove(event);
            userService.createOrUpdate(user);
        }
        for (Message message: messages) {
            message.setEvent(null);
            messageService.delete(message.getId());
        }
        eventService.delete(event.getId());
        return "redirect:/events";
    }
    @GetMapping("/events/join/{joinIdEvent}")
    public String userJoin(
            @PathVariable("joinIdEvent")Long joinIdEvent, HttpSession session){
        User user = userService.findById((Long)session.getAttribute("userId"));
        Event event = eventService.findById(joinIdEvent);
        event.joinUser(user);
        eventService.createOrUpdate(event);
        return "redirect:/events";
    }

    @GetMapping("/events/cancel/{joinIdEvent}")
    public String userCancel(
            @PathVariable("joinIdEvent")Long joinIdEvent, HttpSession session){
        User user = userService.findById((Long)session.getAttribute("userId"));
        Event event = eventService.findById(joinIdEvent);
        List<User> asistenAlEvento = event.getUsuariosAsisten();
        asistenAlEvento.remove(user);
        event.setUsuariosAsisten(asistenAlEvento);
        eventService.createOrUpdate(event);
        return "redirect:/events";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // invalidar la sesión
        session.invalidate();
        // redireccionar a la página de inicio de sesión.
        return "redirect:/";
    }

}
