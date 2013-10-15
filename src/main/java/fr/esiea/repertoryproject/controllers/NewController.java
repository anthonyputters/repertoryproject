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
import fr.esiea.repertoryproject.metier.model.Contact;
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
	
	
	@RequestMapping(value = "/addtorepertory", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")	Contact contact, ModelMap model) {
		DataBase.addContact(contact);
		return "home";
	}
}
