package com.francisco.sessionspringboot;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class plantillas {
	
	@RequestMapping("/")
	public String home(HttpSession session) {
	    if(session.getAttribute("count") == null) {
	    	session.setAttribute("count", 0);
	    }
	    Integer count = (Integer) session.getAttribute("count");
	    count += 1;
	    session.setAttribute("count", count);
	    return "home.jsp";
	}
	@RequestMapping("/counter")
	public String date() {
			return "counter.jsp";
	}
}
