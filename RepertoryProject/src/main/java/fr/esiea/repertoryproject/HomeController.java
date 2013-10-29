package fr.esiea.repertoryproject;

import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiea.repertoryproject.data.DataBase;
import fr.esiea.repertoryproject.metier.service.ServiceContact;
@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		if(DataBase.getContacts().isEmpty()) {
			ServiceContact.createContact("HANKS", "Tom", "tom.hanks@gmail.com", new Date(96, 6, 9), true);
			ServiceContact.createContact("OLDMAN", "Gary", "gary.oldman@gmail.com", new Date(58, 2, 21), true);
			ServiceContact.createContact("FORD", "Harrison", "harrison.ford@gmail.com", new Date(42, 6, 13), false);
			ServiceContact.createContact("BLOOM", "Orlando", "orlando.bloom@gmail.com", new Date(77, 10, 13), true);
			ServiceContact.createContact("FREEMAN", "Morgan", "morgan.freeman@gmail.com", new Date(37, 5, 1), false);
		}
		return "home";
	}
}
