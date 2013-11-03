package fr.esiea.repertoryproject.data;

import java.util.HashSet;
import java.util.Set;

import fr.esiea.repertoryproject.metier.model.Adresse;
import fr.esiea.repertoryproject.metier.model.Contact;

// Class responsable de la persistence des données
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
}
