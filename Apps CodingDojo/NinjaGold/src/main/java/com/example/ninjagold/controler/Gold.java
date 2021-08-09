package com.example.ninjagold.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;


@Controller
public class Gold {
    @RequestMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
            session.setAttribute("actions", new ArrayList<>());
        }
        return "gold.jsp";
    }

    @RequestMapping(value = "gold", method = RequestMethod.POST)
    public String place (
            @RequestParam(value = "place", required = false) String place, HttpSession session) {
        String time = new SimpleDateFormat("MMMM dd HH:mm a").format(new Date());
        Random random = new Random();
        int orito = (int) session.getAttribute("gold");
        int nRandom;
        ArrayList<String> actions = (ArrayList<String>) session.getAttribute("actions");

        if (place.equals("farm")) {
            nRandom = random.nextInt(11) + 10;
            orito += nRandom;
            session.setAttribute("gold", orito);
            actions.add(" You entered a " + place + " and earned " + nRandom + " gold. (" + time + ")");
        }

        if (place.equals("cave")) {
            nRandom = random.nextInt(6) + 5;
            orito += nRandom;
            session.setAttribute("gold", orito);
            actions.add(" You entered a " + place + " and earned " + nRandom + " gold. (" + time + ")");
        }

        if (place.equals("house")) {
            nRandom = random.nextInt(6-2) + 2;
            orito += nRandom;
            session.setAttribute("gold", orito);
            actions.add(" You entered a " + place + " and earned " + nRandom + " gold. (" + time + ")");
        }

        if (place.equals("casino")) {
            nRandom = random.nextInt(51 + 51 ) - 51;
            orito += nRandom;
            session.setAttribute("gold", orito);
            if(nRandom > 0 ) {
                actions.add(" You entered a " + place + " and earned " + nRandom + " gold. (" + time + ")");
            }
            else if(nRandom < 0){
                actions.add(" You entered a " + place + " and lost " + nRandom + " gold. Ouch (" + time + ")");
            }
        }
        if (place.equals("spa")) {
            nRandom = random.nextInt(21-5) + 5;
            orito -= nRandom;
            session.setAttribute("gold", orito);
            actions.add(" You entered a " + place + " and lost " + nRandom + " gold. Ouch (" + time + ")");
        }
        return "redirect:/";
    }
        @RequestMapping("reset")
        public String reset(HttpSession session) {
            session.removeAttribute("gold");
            session.removeAttribute("activities");
            return "redirect:/";
        }
}