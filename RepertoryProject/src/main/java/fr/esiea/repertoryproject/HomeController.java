package fr.esiea.repertoryproject;

import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiea.repertoryproject.data.DataBase;
import fr.esiea.repertoryproject.metier.model.Adresse;
import fr.esiea.repertoryproject.metier.model.Contact;
import fr.esiea.repertoryproject.metier.service.ServiceAdresse;
import fr.esiea.repertoryproject.metier.service.ServiceContact;
@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		if(DataBase.getContacts().isEmpty()) {
			Adresse adresse;
			Contact contact;
			
			contact = ServiceContact.createContact("HANKS", "Tom", "tom.hanks@gmail.com", 1996, 6, 9, true);
			adresse = ServiceAdresse.createAdresse("Maison", "5", "Curial", "75016", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
			adresse = ServiceAdresse.createAdresse("Bureau", "207", "de Crimée", "75017", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
			
			contact = ServiceContact.createContact("OLDMAN", "Gary", "gary.oldman@gmail.com", 1958, 2, 21, true);
			adresse = ServiceAdresse.createAdresse("Maison", "32", "d'Aubervilliers", "75007", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);

			contact = ServiceContact.createContact("FORD", "Harrison", "harrison.ford@gmail.com", 1942, 6, 13, false);
			contact = ServiceContact.createContact("BLOOM", "Orlando", "orlando.bloom@gmail.com", 1977, 10, 13, true);
			adresse = ServiceAdresse.createAdresse("Bureau", "58", "de l'Aqueduc", "75010", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
			adresse = ServiceAdresse.createAdresse("Maison", "98", "de Cléry", "75002", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);

			contact = ServiceContact.createContact("FREEMAN", "Morgan", "morgan.freeman@gmail.com", 1937, 5, 1, false);
			adresse = ServiceAdresse.createAdresse("Bureau", "72", "du Faubourg Saint-Martin", "75010", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
			adresse = ServiceAdresse.createAdresse("Maison", "67", "de Lancry", "75010", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
			adresse = ServiceAdresse.createAdresse("Livraison", "4 bis", "Salomon de Caus", "75002", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
		}
		return "home";
	}
}
