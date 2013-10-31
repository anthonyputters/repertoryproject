package fr.esiea.repertoryproject.controllers;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiea.repertoryproject.data.DataBase;
import fr.esiea.repertoryproject.metier.model.Adresse;
import fr.esiea.repertoryproject.metier.model.Contact;
import fr.esiea.repertoryproject.metier.service.ServiceAdresse;
import fr.esiea.repertoryproject.metier.service.ServiceContact;

@Controller
public class ContactController {
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Locale locale, HttpServletRequest request, Model model) {		
		int hashCode = Integer.parseInt(request.getParameter("contactHashCode"));
		Contact contact = ServiceContact.findByHashCode(hashCode);
	
		model.addAttribute("dateformat", new SimpleDateFormat("dd/MM/yyyy"));
		model.addAttribute("contact", contact);
		return "contact";
	}
}
