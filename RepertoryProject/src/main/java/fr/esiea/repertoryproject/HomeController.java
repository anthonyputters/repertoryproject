package fr.esiea.repertoryproject;

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
	// Nous définissons le mapping de la page d'acceuil
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {	
		// Si la base des contacts est vide, nous ajoutons des données de test
		if(DataBase.getContacts().isEmpty()) {
			Adresse adresse;
			Contact contact;
			
			contact = ServiceContact.createContact("HANKS", "Tom", "tom.hanks@gmail.com", 1996, 6, 9, true);
			adresse = ServiceAdresse.createAdresse("Maison", "5", "avenue", "Curial", "75016", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
			adresse = ServiceAdresse.createAdresse("Bureau", "207", "rue", "de Crimée", "75017", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
			
			contact = ServiceContact.createContact("OLDMAN", "Gary", "gary.oldman@gmail.com", 1958, 2, 21, true);
			adresse = ServiceAdresse.createAdresse("Maison", "32", "rue", "d'Aubervilliers", "75007", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);

			contact = ServiceContact.createContact("FORD", "Harrison", "harrison.ford@gmail.com", 1942, 6, 13, false);
			contact = ServiceContact.createContact("BLOOM", "Orlando", "orlando.bloom@gmail.com", 1977, 10, 13, true);
			adresse = ServiceAdresse.createAdresse("Bureau", "58", "rue", "de l'Aqueduc", "75010", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
			adresse = ServiceAdresse.createAdresse("Maison", "98", "impasse", "de Cléry", "75002", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);

			contact = ServiceContact.createContact("FREEMAN", "Morgan", "morgan.freeman@gmail.com", 1937, 5, 1, false);
			adresse = ServiceAdresse.createAdresse("Bureau", "72", "boulevard", "du Faubourg Saint-Martin", "75010", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
			adresse = ServiceAdresse.createAdresse("Maison", "67", "rue", "de Lancry", "75010", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
			adresse = ServiceAdresse.createAdresse("Livraison", "4 bis", "rue", "Salomon de Caus", "75002", "Paris");
			ServiceContact.associateContactAdresse(contact, adresse);
		}
		
		// Nous retournons le nom de la page à afficher
		return "home";
	}
}
