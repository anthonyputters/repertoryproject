package fr.esiea.repertoryproject.metier.service;

import java.util.Date;
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
	
	public static void associateContactAdresse(Contact contact, String adresseName, Adresse adresse) {
		contact.addAdresse(adresseName, adresse);
	}
	
	public static void changeContact(Contact contact, String nom, String prenom, String email, Date dateNaissance, Boolean actif) {
		contact.setNom(nom);
		contact.setPrenom(prenom);
		contact.setEmail(email);
		contact.setDateNaissance(dateNaissance);
		contact.setActif(actif);
	}
	
	public static Set<Contact> getAllContacts() {
		return DataBase.getContacts();
	}
	
	public static void deleteContact(Contact contact) {
		DataBase.deleteContact(contact);
	}
	
	public static Set<Contact> search(String nom, String prenom, String email, Date dateNaissance, DateSearch dateSearch) {
		return DataBase.search(nom, prenom, email, dateNaissance, dateSearch);
	}
}
