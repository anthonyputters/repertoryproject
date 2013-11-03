package fr.esiea.repertoryproject.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiea.repertoryproject.data.DataBase;
import fr.esiea.repertoryproject.metier.model.Adresse;
import fr.esiea.repertoryproject.metier.model.Contact;
import fr.esiea.repertoryproject.metier.service.ServiceAdresse;
import fr.esiea.repertoryproject.metier.service.ServiceContact;

@Controller
public class NewController {
	// Cette méthode permet de définir de quelle manière les dates doivent 
	// être interprété a partir du formulaire en HTML
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
         binder.registerCustomEditor(Date.class, editor);
    }

	// Cette URI est appeler lorsque l'utilisateur clique sur "ajouter" 
	@RequestMapping(value = "/newcontact", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// Nous affichons le formulaire d'ajout de nouveau contact
		return "new";
	}
	
	// Cette URI est appelée à la validation du formulaire d'ajouts
	@RequestMapping(value = "/addcontact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")	Contact contact, HttpServletRequest request, ModelMap model) {
		// Nous récupérons les adresses ajoutées par l'utilisateur
		String intitule = request.getParameter("intituleHide");
		String numero = request.getParameter("numeroHide");
		String voie = request.getParameter("voieHide");
		String rue = request.getParameter("rueHide");
		String codePostal = request.getParameter("codePostalHide");
		String ville = request.getParameter("villeHide");

		// Nous ajoutons le contact à la base des contacts
		DataBase.addContact(contact);
		
		// Nous séparons les champs succéssifs des différentes adresses entrées
		String[] intituleData = intitule.split(";");
		String[] numeroData = numero.split(";");
		String[] voieData = voie.split(";");
		String[] rueData = rue.split(";");
		String[] codePostalData = codePostal.split(";");
		String[] villeData = ville.split(";");
		
		// Nous ajoutons les adresses au contact
		for(int i = 0 ; i < intituleData.length ; i++) {
			if(!numeroData[i].equals("")) {
				Adresse adresse = ServiceAdresse.createAdresse(intituleData[i], numeroData[i], voieData[i], rueData[i], codePostalData[i], villeData[i]);
				ServiceContact.associateContactAdresse(contact, adresse);
			}
		}
		
		// Nous rechargons la page d'acceuil
		return "redirect:";
	}
}
