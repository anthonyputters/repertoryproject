package fr.esiea.repertoryproject.metier.service;

import fr.esiea.repertoryproject.data.DataBase;
import fr.esiea.repertoryproject.metier.model.Adresse;

public class ServiceAdresse {
	public static Adresse createAdresse(String numero, String rue, String codePostal, String ville) {
		Adresse adresse = new Adresse(numero, rue, codePostal, ville);
		DataBase.addAdresse(adresse);
		return adresse;
	}
	
	public static void changeAdresse(Adresse adresse, String numero, String rue, String codePostal, String ville) {
		adresse.setNumero(numero);
		adresse.setRue(rue);
		adresse.setCodePostal(codePostal);
		adresse.setVille(ville);
	}
	
	public static void deleteAdresse(Adresse adresse) {
		DataBase.deleteAdresse(adresse);
	}
}
