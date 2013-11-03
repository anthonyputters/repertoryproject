package fr.esiea.repertoryproject.controllers;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {
	// Il s'agit de la page des crédits
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "about";
	}
}
