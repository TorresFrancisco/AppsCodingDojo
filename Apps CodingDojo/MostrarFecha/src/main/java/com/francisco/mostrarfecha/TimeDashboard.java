package com.francisco.mostrarfecha;

import java.util.Date;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimeDashboard {

	@RequestMapping("/")
	public String home() {
	    return "dateDashboard.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat formato = new SimpleDateFormat("EEEE, dd MMMM yyyy")  ;
		Date dateToday = new Date();
		String today = formato.format(dateToday);
		model.addAttribute("date",today);
			return "date.jsp";
	}	
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat formato = new SimpleDateFormat("hh:mm a");
		Date time = new Date();
		String timeToday = formato.format(time);
		model.addAttribute("time", timeToday);
			return "time.jsp";
	}	
}
