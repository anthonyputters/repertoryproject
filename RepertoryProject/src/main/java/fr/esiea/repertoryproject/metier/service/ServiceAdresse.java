package fr.esiea.repertoryproject.metier.service;

import fr.esiea.repertoryproject.data.DataBase;
import fr.esiea.repertoryproject.metier.model.Adresse;

public class ServiceAdresse {
	public static Adresse createAdresse(String intitule, String numero, String rue, String codePostal, String ville) {
		Adresse adresse = new Adresse(intitule, numero, rue, codePostal, ville);
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

	public static Adresse findByHashCode(int hashCode) {
		for(Adresse adresse : DataBase.getAdresses()) {
			if(adresse.hashCode() == hashCode)
				return adresse;
		}
		return null;
	}
}
