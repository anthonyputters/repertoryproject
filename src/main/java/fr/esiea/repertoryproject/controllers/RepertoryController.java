package fr.esiea.repertoryproject.controllers;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiea.repertoryproject.data.DataBase;
import fr.esiea.repertoryproject.metier.model.Contact;
import fr.esiea.repertoryproject.metier.service.ServiceContact;

@Controller
public class RepertoryController {
	@RequestMapping(value = "/repertory", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		ServiceContact.createContact("PUTTERS", "Anthony", "anthony.putters@gmail.com", new Date(), true);
		model.addAttribute("contacts", ServiceContact.getAllContacts());
		return "repertory";
	}
}
