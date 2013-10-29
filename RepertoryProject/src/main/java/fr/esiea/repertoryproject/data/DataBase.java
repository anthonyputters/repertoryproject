package fr.esiea.repertoryproject.data;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import fr.esiea.repertoryproject.metier.model.Adresse;
import fr.esiea.repertoryproject.metier.model.Contact;
import fr.esiea.repertoryproject.metier.service.DateSearch;

public class DataBase {
	static Set<Contact> contacts = new HashSet<Contact>();
	static Set<Adresse> adresses = new HashSet<Adresse>();
	
	public static Set<Contact> getContacts() {
		return contacts;
	}
	
	public static Set<Adresse> getAdresses() {
		return adresses;
	}
	
	public static void addContact(Contact contact) {
		contacts.add(contact);
	}
	
	public static void addAdresse(Adresse adresse) {
		adresses.add(adresse);
	}

	public static void deleteContact(Contact contact) {
		contacts.remove(contact);
	}
	
	public static void deleteAdresse(Adresse adresse) {
		adresses.remove(adresse);
	}

	public static Set<Contact> search(String nom, String prenom, String email, Date dateNaissance, DateSearch dateSearch) {
		Set<Contact> result = new HashSet<Contact>();
		
		for (Contact contact : contacts) {
			if(!nom.equals("")) {
				if(!nom.equalsIgnoreCase(contact.getNom()))
					continue;
			}
			
			if(!prenom.equals("")) {
				if(!prenom.equalsIgnoreCase(contact.getPrenom()))
					continue;
			}
			
			if(!email.equals("")) {
				if(!email.equalsIgnoreCase(contact.getEmail()))
					continue;
			}
			
			if(dateNaissance != null) {
				if(dateSearch == DateSearch.EARLIER_THAN) {
					if(!dateNaissance.after(contact.getDateNaissance()))
						continue;
				}
				if(dateSearch == DateSearch.LATER_THAN) {
					if(!dateNaissance.before(contact.getDateNaissance()))
						continue;
				}
				if(dateSearch == DateSearch.SAME_DATE) {
					if(!dateNaissance.equals(contact.getDateNaissance()))
						continue;
				}
			}
			
			result.add(contact);
		}
		return result;
	}
}
