package fr.esiea.repertoryproject.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class ModifyController {	
	// Cette méthode permet de définir de quelle manière les dates doivent 
	// être interprété a partir du formulaire en HTML
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
         binder.registerCustomEditor(Date.class, editor);
    }

	// Cette URI permet d'accéder à la page de modification
	@RequestMapping(value = "/modifycontact", method = RequestMethod.POST)
	public String modifyContact(@ModelAttribute("contact")	Contact contact, Locale locale, HttpServletRequest request, Model model) {		
		// Nous prenons en compte les modification
		Contact contactOld = ServiceContact.findByHashCode(Integer.parseInt(request.getParameter("contactHashCode")));
		contact.setAdresses(contactOld.getAdresses());
		DataBase.deleteContact(contactOld);
		DataBase.addContact(contact);

		// Nous rechargeons la page d'acceuil
		return "redirect:";
	}
	
	// Cette URI permet de supprimer une des adresses sur la page de modification
	@RequestMapping(value = "/removeaddress", method = RequestMethod.GET)
	public String removeAdresse(Locale locale, HttpServletRequest request, Model model) {		
		// Nous récupérons l'adresse et le contact concerné à l'aide de leur hashCode fourni en paramètre de la requête
		Adresse adresse = ServiceAdresse.findByHashCode(Integer.parseInt(request.getParameter("addressHashCode")));
		Contact contact = ServiceContact.findByHashCode(Integer.parseInt(request.getParameter("contactHashCode")));

		// Puis nous retirons cette adresse du contact
		ServiceContact.removeAdresseFromContact(contact, adresse);

		model.addAttribute("dateformat", new SimpleDateFormat("yyyy-MM-dd"));
		model.addAttribute("contact", contact);
		return "modify";
	}

	// Cette URI est appelée à la validation de l'ajout d'une adresse sur la page de modification
	@RequestMapping(value = "/addaddress", method = RequestMethod.GET)
	public String addAdresse(@ModelAttribute("adresse")	Adresse adresse, Locale locale, HttpServletRequest request, Model model) {
		// Nous récupérons le contact concerné à l'aide de son hashCode fourni en paramètre de la requête
		Contact contact = ServiceContact.findByHashCode(Integer.parseInt(request.getParameter("contactHashCode")));

		// Nous associons l'adresse entrée au contact
		ServiceContact.associateContactAdresse(contact, adresse);

		model.addAttribute("dateformat", new SimpleDateFormat("yyyy-MM-dd"));
		model.addAttribute("contact", contact);
		return "modify";
	}
}
