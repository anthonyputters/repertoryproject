package fr.esiea.repertoryproject.metier.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

import fr.esiea.repertoryproject.data.DataBase;
import fr.esiea.repertoryproject.metier.model.Adresse;
import fr.esiea.repertoryproject.metier.model.Contact;

public class ServiceContact {
	public static Contact createContact(String nom, String prenom, String email, Date dateNaissance, Boolean actif) {
		Contact contact = new Contact(nom, prenom, email, dateNaissance, actif);
		DataBase.addContact(contact);
		return contact;
	}
	
	public static Contact createContact(String nom, String prenom, String email, int annee, int mois, int jour, Boolean actif) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, annee);
		calendar.set(Calendar.MONTH, mois);
		calendar.set(Calendar.DAY_OF_MONTH, jour);
		Contact contact = new Contact(nom, prenom, email, calendar.getTime(), actif);
		DataBase.addContact(contact);
		return contact;
	}

	public static void associateContactAdresse(Contact contact, Adresse adresse) {
		DataBase.addAdresse(adresse);
		contact.addAdresse(adresse);
	}
	
	public static void changeContact(Contact contact, String nom, String prenom, String email, Date dateNaissance, Boolean actif) {
		contact.setNom(nom);
		contact.setPrenom(prenom);
		contact.setEmail(email);
		contact.setDateNaissance(dateNaissance);
		contact.setActif(actif);
	}
	
	public static Collection<Contact> getAllContacts() {
		List<Contact> sortedContact = new ArrayList<Contact>(DataBase.getContacts());
		Collections.sort(sortedContact, new Comparator<Contact>() {
		    public int compare(Contact contact1, Contact contact2) {
		        return contact1.getNom().toLowerCase().compareTo(contact2.getNom().toLowerCase());
		    }
		});
		
		return sortedContact;
	}
	
	public static void deleteContact(Contact contact) {
		DataBase.deleteContact(contact);
	}

	public static void removeAdresseFromContact(Contact contact, Adresse adresse) {
		contact.deleteAdresse(adresse);
		DataBase.deleteAdresse(adresse);
	}

	public static Set<Contact> search(String nom, String prenom, String email) {
		return DataBase.search(nom, prenom, email);
	}
	
	public static Contact findByHashCode(int hashCode) {
		for(Contact contact : DataBase.getContacts()) {
			if(contact.hashCode() == hashCode)
				return contact;
		}
		return null;
	}
}
