package fr.esiea.repertoryproject.metier.model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Contact {
	private String nom;
	private String prenom;
	private String email;
	@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	private Boolean actif;
	private Map<String, Adresse> adresses;

	public Contact() {
		adresses = new HashMap<String, Adresse>();
	}

	public Contact(String nom, String prenom, String email, Date dateNaissance, Boolean actif) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.actif = actif;
		adresses = new HashMap<String, Adresse>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNaissance() {
		return dateNaissance;
/*		if(dateNaissance != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dateNaissance);
			return calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.YEAR);
		}
		else 
			return "";*/
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public void addAdresse(String key, Adresse adresse) {
		this.adresses.put(key, adresse);
	}

	public void deleteAdresse(String key) {
		this.adresses.remove(key);
	}

	public Map<String, Adresse> getAdresses() {
		return this.adresses;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", dateNaissance=");
		builder.append(dateNaissance);
		builder.append(", actif=");
		builder.append(actif);
		builder.append(", adresses=");
		builder.append(adresses);
		builder.append("]");
		return builder.toString();
	}
}
