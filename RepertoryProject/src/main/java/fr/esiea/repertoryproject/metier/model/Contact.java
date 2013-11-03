package fr.esiea.repertoryproject.metier.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Contact {
	private String nom;
	private String prenom;
	private String email;
	// Nous spécifions le format de la date
	@DateTimeFormat(iso = ISO.DATE, pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	private Boolean actif;
	private Set<Adresse> adresses;

	public Contact() {
		actif = false;
		adresses = new HashSet<Adresse>();
	}

	public Contact(String nom, String prenom, String email, Date dateNaissance, Boolean actif) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.actif = actif;
		adresses = new HashSet<Adresse>();
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

	public void addAdresse(Adresse adresse) {
		this.adresses.add(adresse);
	}

	public void deleteAdresse(Adresse adresse) {
		this.adresses.remove(adresse);
	}

	public Set<Adresse> getAdresses() {
		return this.adresses;
	}
	
	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
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
	
    @Override
    public int hashCode() {
    	// Nous générons le hashCode propre à chaque contact
        int hash = 1;
        hash = hash * 17 + nom.hashCode();
        hash = hash * 31 + prenom.hashCode();
        hash = hash * 13 + email.hashCode();
        return hash;
    }
}
