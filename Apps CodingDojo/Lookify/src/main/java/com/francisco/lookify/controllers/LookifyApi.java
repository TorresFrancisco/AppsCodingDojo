package com.francisco.lookify.controllers;

import com.francisco.lookify.models.Lookify;
import com.francisco.lookify.services.LookifyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LookifyApi {
    private final LookifyService lookifyService;
    public LookifyApi(LookifyService lookifyService){

        this.lookifyService = lookifyService;
    }

    @RequestMapping("/api/lookifys")
    public List<Lookify> dashboard() {
        return lookifyService.allLookifys();
    }

    @RequestMapping(value="/api/lookifys", method= RequestMethod.POST)
    public Lookify addSong(
            @RequestParam(value="title") String title,
            @RequestParam(value="artist") String artist,
            @RequestParam(value="rating") Integer rating)
    {
        Lookify lookify = new Lookify(title, artist, rating);
        return lookifyService.createLookify(lookify);
    }

    @RequestMapping("/api/lookifys/{id}")
    public Lookify details(@PathVariable("id") Long id) {
        Lookify lookify = lookifyService.findLookify(id);
        return lookify;
    }
    @RequestMapping(value="/api/lookify/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        lookifyService.deleteLookify(id);
    }
}
