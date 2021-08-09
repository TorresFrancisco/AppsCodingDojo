package com.francisco.authentication.users;

import com.francisco.authentication.models.User;
import com.francisco.authentication.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class Users {
    private final UserService userService;

    public Users(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }

    @RequestMapping(value="/registration", method= RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        //si el resultado tiene errores, retornar a la página de registro (no se preocupe por las validaciones por ahora)
        if(result.hasErrors()){
            return "registrationPage.jsp";
        }
        //si no, guarde el usuario en la base de datos, guarde el id del usuario en el objeto Session y redirija a /home
        User users = userService.registerUser(user);
        session.setAttribute("userId", users.getId());
        return "redirect:/home";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        //Si el usuario está autenticado, guarde su id de usuario en el objeto Session
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if(isAuthenticated){
            User users = userService.findByEmail(email);
            session.setAttribute("userId", users.getId());
            return "redirect:/home";
        }
        //sino agregue un mensaje de error y retorne a la página de inicio de sesión.
        else{
            model.addAttribute("error", "Invalid Credentials. Please thy again.");
            return "loginPage.jsp";
        }
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
        Long userId = (Long) session.getAttribute("userId");
        User users = userService.findUserById(userId);
        model.addAttribute("user", users);
        return "homePage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidar la sesión
        session.invalidate();
        // redireccionar a la página de inicio de sesión.
        return "redirect:/login";
    }
}
