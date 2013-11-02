package fr.esiea.repertoryproject.controllers;

import java.awt.print.Book;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiea.repertoryproject.data.DataBase;
import fr.esiea.repertoryproject.metier.model.Adresse;
import fr.esiea.repertoryproject.metier.model.Contact;
import fr.esiea.repertoryproject.metier.service.ServiceAdresse;
import fr.esiea.repertoryproject.metier.service.ServiceContact;

/**
 * Handles requests for the application home page.
 */
@Controller
public class NewController {
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
         binder.registerCustomEditor(Date.class, editor);
    }

	@RequestMapping(value = "/newcontact", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "new";
	}
	
	@RequestMapping(value = "/addcontact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")	Contact contact, HttpServletRequest request, ModelMap model) {
		// Nous récupérons les adresses ajoutées par l'utilisateur
		String intitule = request.getParameter("intituleHide");
		String numero = request.getParameter("numeroHide");
		String voie = request.getParameter("voieHide");
		String rue = request.getParameter("rueHide");
		String codePostal = request.getParameter("codePostalHide");
		String ville = request.getParameter("villeHide");

		DataBase.addContact(contact);
		
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
		
		return "redirect:";
	}
	
	@RequestMapping(value = "/modifycontact", method = RequestMethod.POST)
	public String modifyContact(@ModelAttribute("contact")	Contact contact, Locale locale, HttpServletRequest request, Model model) {		
		Contact contactOld = ServiceContact.findByHashCode(Integer.parseInt(request.getParameter("contactHashCode")));
		contact.setAdresses(contactOld.getAdresses());
		DataBase.deleteContact(contactOld);
		DataBase.addContact(contact);

		return "redirect:";
	}
}
