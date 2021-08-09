package com.francisco.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaHumano {
	
    @RequestMapping("/")
    public String index(@RequestParam(value="q", required=false) String searchQuery) {
    	if(searchQuery == null) {
    		return "Hola  Humano !";
    	}
        return "Hola  " + searchQuery;
    }
}
