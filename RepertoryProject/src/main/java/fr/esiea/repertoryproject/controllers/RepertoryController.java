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
public class RepertoryController {
	@RequestMapping(value = "/repertory", method = RequestMethod.GET)
	public String repertory(Locale locale, HttpServletRequest request, Model model) {		
		String action = request.getParameter("action");

		if(action != null) {
			int hashCode = Integer.parseInt(request.getParameter("id"));

			if(action.equals("remove")) {
				Contact contact = ServiceContact.findByHashCode(hashCode);
				if(contact != null)
					ServiceContact.deleteContact(contact);
			}
			if(action.equals("modify")) {
				Contact contact = ServiceContact.findByHashCode(hashCode);

				if(contact != null) {
					model.addAttribute("dateformat", new SimpleDateFormat("yyyy-MM-dd"));
					model.addAttribute("contact", contact);
					return "modify";
				}
			}
		}
		model.addAttribute("dateformat", new SimpleDateFormat("dd/MM/yyyy"));
		model.addAttribute("contacts", ServiceContact.getAllContacts());
		return "repertory";
	}

	@RequestMapping(value = "/removeaddress", method = RequestMethod.GET)
	public String removeAdresse(Locale locale, HttpServletRequest request, Model model) {		
		Adresse adresse = ServiceAdresse.findByHashCode(Integer.parseInt(request.getParameter("addressHashCode")));
		Contact contact = ServiceContact.findByHashCode(Integer.parseInt(request.getParameter("contactHashCode")));

		ServiceContact.removeAdresseFromContact(contact, adresse);

		model.addAttribute("dateformat", new SimpleDateFormat("yyyy-MM-dd"));
		model.addAttribute("contact", contact);
		return "modify";
	}
	
	@RequestMapping(value = "/addaddress", method = RequestMethod.GET)
	public String addAdresse(@ModelAttribute("adresse")	Adresse adresse, Locale locale, HttpServletRequest request, Model model) {		
		Contact contact = ServiceContact.findByHashCode(Integer.parseInt(request.getParameter("contactHashCode")));

		ServiceContact.associateContactAdresse(contact, adresse);

		model.addAttribute("dateformat", new SimpleDateFormat("yyyy-MM-dd"));
		model.addAttribute("contact", contact);
		return "modify";
	}
}
