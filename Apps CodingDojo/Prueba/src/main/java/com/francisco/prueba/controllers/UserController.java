package com.francisco.prueba.controllers;

import com.francisco.prueba.models.Package;
import com.francisco.prueba.models.User;
import com.francisco.prueba.services.PackageService;
import com.francisco.prueba.services.UserService;
import com.francisco.prueba.validator.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final UserValidator userValidator;
    private final PackageService packageService;

    public UserController(UserService userService, UserValidator userValidator, PackageService packageService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.packageService = packageService;
    }

        //////////////////HOME////////////////////////
        @GetMapping("/")
        public String registerForm(
                @ModelAttribute("user") User user) {
            return "lar.jsp";
        }

        @PostMapping("/")
        public String createUser(
                @Valid
                @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
            userValidator.validate(user, result);
            if (result.hasErrors()) {
                return "lar.jsp";
            }
            if (userService.emailExist(user.getEmail())) {
                FieldError error = new FieldError("email", "email", "El email " + user.getEmail() + " ya se encuentra en la base de datos");
                result.addError(error);
                return "lar.jsp";
            }
            if(userService.numberUser()>0){
                user.setRol(2);
                Package pack = packageService.findPackage("Basic");
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DATE, 31);
                Date date = calendar.getTime();
                user.setPack(pack);
                user.setDueDate(date);
                userService.registerUser(user);
                session.setAttribute("userId", user.getId());
                return "redirect:/users/" + user.getId();
                }
                Package pack = new Package();
                pack.setAvailable(true);
                pack.setCost(10.0);
                pack.setName("Basic");
                user.setRol(1);
                userService.registerUser(user);
                pack.setAdministrador(user);
                packageService.createOrUpdate(pack);
                session.setAttribute("userId", user.getId());
                return "redirect:/packages";
                }

        //////////////////LOGIN/////////////////////////////////////////////
        @PostMapping("/login")
        public String loginUser(
                @RequestParam("email") String email,
                @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes) {
            boolean isAuthenticated = userService.authenticateUser(email, password);
            if (isAuthenticated) {
                User users = userService.findByEmail(email);
                session.setAttribute("userId", users.getId());
                if (users.getRol() == 1){
                    return "redirect:/packages";
                }else{
                    return "redirect:/users/" + users.getId();
                }
                }else{
                redirectAttributes.addFlashAttribute("error", "Invalid Credentials. Please thy again.");
                return "redirect:/";
            }
        }

        /////////////LOGOUT/////////////////////////////////
        @GetMapping("/logout")
        public String logout(HttpSession session) {
            session.invalidate();
            return "redirect:/";
        }
///////////////////////////////DASHBOARD////////////////////////
        @GetMapping("/packages")
        public String dashboard(
                HttpSession session, Model model,
                @ModelAttribute("package")Package packageD) {
            User user = userService.findById((Long) session.getAttribute("userId"));
            if (user.getId() == null  || user.getRol() != 1 ) {
                return "redirect:/";
            } else {
                List<User> userList = userService.allData();
                List<Package> packageList = packageService.allData();
                model.addAttribute("userList", userList);
                model.addAttribute("packageList", packageList);
                return "packages.jsp";
                }

            }
        @GetMapping("/packages/{idA}/available")
        public String available(
                @PathVariable("idA")Long idA, HttpSession session){
                Package pack = packageService.findById(idA);
                User user = userService.findById((Long) session.getAttribute("userId"));
                if (user.getId() == pack.getAdministrador().getId()){
                    if(pack.isAvailable()){
                        pack.setAvailable(false);
                        packageService.createOrUpdate(pack);
                        return "redirect:/packages";
                    }else{
                        pack.setAvailable(true);
                        packageService.createOrUpdate(pack);
                        return "redirect:/packages";
                    }
                }else{
                    return "redirect/";
                }
        }

        @PostMapping("/packages")
        public String createPackage(
                @Valid
                @ModelAttribute("package")Package packageD,BindingResult result,
                Model model, HttpSession session){
            if(result.hasErrors()){
                List<User> userList = userService.allData();
                List<Package> packageList = packageService.allData();
                model.addAttribute("userList", userList);
                model.addAttribute("packageList", packageList);
                return "packages.jsp";
            }else{
                User administrador = userService.findById((Long) session.getAttribute("userId"));
                packageD.setAvailable(true);
                packageD.setAdministrador(administrador);
                packageService.createOrUpdate(packageD);
                return "redirect:/packages";
            }
        }
//////////////////////EDITAR////////////////////////////////////

        @GetMapping("/packages/{editId}/edit")
        public String editPackages(
            @PathVariable("editId") Long editId,
            HttpSession session, Model model) {
        User user = userService.findById((Long) session.getAttribute("userId"));
        if (user.getRol() !=1 || user.getId() == null) {
            return "redirect:/";
        } else {
            Package pack = packageService.findById(editId);
            model.addAttribute("pack", pack);
            return "editPackage.jsp";
        }
    }

        @PutMapping("/packages/{editId}/edit")
        public String editPackages(
                @PathVariable("editId")Long editId, Model model,
                RedirectAttributes redirectAttributes,
                @Valid
                @ModelAttribute("package")Package packagesEdit, BindingResult result){
            Package packChange = packageService.findById(editId);
            if(result.hasErrors()){
                model.addAttribute("packChange", packChange);
                redirectAttributes.addFlashAttribute("error", "The value must be greater than 0 ");
                return "redirect:/packages" + editId + "/edit";
            }else{
                packChange.setCost(packagesEdit.getCost());
                packageService.createOrUpdate(packChange);
                return "redirect:/packages";
            }
        }
///////////////////////////////USERS/////////////////////////////////

    @GetMapping("/users/{id}")
    public String showUser(
            @ModelAttribute("user")User user, Model model, HttpSession session) {
        User users = userService.findById((Long) session.getAttribute("userId"));
        List<Package> packages = packageService.allData();
        //System.out.println(packages);
        if (users.getRol() == 1 || users.getId() == null){
            return "redirect:/";
        }else{
            model.addAttribute("packages", packages);
            model.addAttribute("user", users);
            return "userPackage.jsp";
        }
    }

    @PostMapping("/users/{id}")
    public String showUser(
            @ModelAttribute("package")Package packageU, HttpSession session){
        User user = userService.findById((Long) session.getAttribute("userId"));
        user.setPack(packageU);
        userService.createOrUpdate(user);
            return "redirect:/users/" + user.getId();
        }

//////////////////////////DELETE/////////////////////////////////

    @GetMapping("/packages/{deleteId}/delete")
    public String deletePackage(
            @PathVariable("deleteId")Long deleteId, HttpSession session){
        User user = userService.findById((Long) session.getAttribute("userId"));
        if (user.getRol() != 1 || user.getId() == null){
            return "redirect:/";
        }else{
            Package packs = packageService.findById(deleteId);
            if(packs.getUserSuscribed().size() > 0 || packs.getId() == 1){
                return "redirect:/packages";
            }else{
                packageService.delete(packs.getId());
                return "redirect:/packages";
            }
        }
    }


}
