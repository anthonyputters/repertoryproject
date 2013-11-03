package fr.esiea.repertoryproject.controllers;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiea.repertoryproject.metier.model.Contact;
import fr.esiea.repertoryproject.metier.service.ServiceContact;

@Controller
public class SearchController {
	// Cette URI est appelée lorsque le contact clique sur l'onglet "Rechercher"
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// Nous affichons simplement la page de recherche
		return "search";
	}
	
	// Cette URI est appelée lorsque le contact lance une recherche
	@RequestMapping(value = "/searchContact", method = RequestMethod.GET)
	public String searchResult(HttpServletRequest request, ModelMap model) {
		// Nous recupérons les paramètres de la recherche
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
	
		// Nous lançons la recherche dans la base des contacts
		Set<Contact> correspondingContacts = ServiceContact.search(nom, prenom, email);

		// Nous renvoyons le résulat et les paramètres de la recherche
		model.addAttribute("dateformat", new SimpleDateFormat("dd/MM/yyyy"));
		model.addAttribute("prenom", prenom);
		model.addAttribute("nom", nom);
		model.addAttribute("email", email);
		model.addAttribute("contacts", correspondingContacts);
		
		return "search";
	}

}
