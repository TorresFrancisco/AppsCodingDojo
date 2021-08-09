package com.francisco.familiarizarnosenrutamiento;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@RequestMapping("/{ruta}")
	public String dojo(@PathVariable("ruta") String ruta) {
		if (ruta.equals("dojo")) {
        return "¡El Dojo es increíble!";
		}
		if(ruta.equals("burbank-dojo")) {
			return "El Dojo Burbank está localizado al sur de California";
		}
		if (ruta.equals("san-jose")) {
			return "¡Java/Spring es mejor!";
		}
		return ruta;
	}

}

