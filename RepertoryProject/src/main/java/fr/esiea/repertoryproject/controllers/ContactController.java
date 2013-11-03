package fr.esiea.repertoryproject.controllers;

import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.esiea.repertoryproject.metier.model.Contact;
import fr.esiea.repertoryproject.metier.service.ServiceContact;

@Controller
public class ContactController {
	// Page d�taill�e d'un contact
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Locale locale, HttpServletRequest request, Model model) {	
		// Nous r�cup�rons le contact � l'aide de son hashCode fourni en param�tre de la requ�te
		int hashCode = Integer.parseInt(request.getParameter("contactHashCode"));
		Contact contact = ServiceContact.findByHashCode(hashCode);
	
		// Nous fournissons un format de date pour afficher les dates de naissance
		model.addAttribute("dateformat", new SimpleDateFormat("dd/MM/yyyy"));
		model.addAttribute("contact", contact);
		return "contact";
	}
}
