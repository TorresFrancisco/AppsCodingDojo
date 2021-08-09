package com.francisco.lookify.controllers;

import com.francisco.lookify.models.Lookify;
import com.francisco.lookify.services.LookifyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class LookifyController {
        private final LookifyService lookifyService;

        public LookifyController(LookifyService lookifyService) {
            this.lookifyService = lookifyService;
        }
        @RequestMapping("/")
        public String home() {
        return "/home.jsp";
        }
        @RequestMapping("/dashboard")
        public String dashboard(
            @ModelAttribute("lookify") Lookify lookify, Model model) {
            List<Lookify> lookifys = lookifyService.allLookifys();
            model.addAttribute("lookifys",lookifys );
            return "/dashboard.jsp";
        }
        @GetMapping("/songs/new")
        public String newSong(
                @ModelAttribute("lookify") Lookify lookify ){
                return "/add.jsp";
        }
        @PostMapping("/songs/new")
        public String addSong(
                @Valid
                @ModelAttribute("lookify") Lookify lookify, BindingResult result) {
            if (result.hasErrors()) {
                return "/add.jsp";
            } else {
                lookifyService.createLookify(lookify);
                return "redirect:/dashboard";
            }
        }
        @RequestMapping("/songs/{id}")
        public String details(
                @PathVariable("id") Long id, Model model){
            Lookify lookify = lookifyService.findLookify(id);
            if (lookify == null) {
                return "redirect:/dashboard";
            } else {
                model.addAttribute("lookify", lookify);
                return "/show.jsp";
            }
        }
        @DeleteMapping("/songs/{id}")
        public String destroy(
                @PathVariable("id") Long id){
            lookifyService.deleteLookify(id);
            return "redirect:/dashboard";

        }
        @GetMapping("/search/topTen")
        public String search(Model model) {
            List<Lookify> topten = lookifyService.topTen();
            model.addAttribute("topten",topten);
            return "/topten.jsp";
        }
        @GetMapping("/search")
        public String searchArtist(Model model, @RequestParam("busqueda") String artista){
            List<Lookify> artist = lookifyService.artist(artista);
            model.addAttribute("artist", artist);
            model.addAttribute("busqueda", artista);
            return "/search.jsp";
        }
}
