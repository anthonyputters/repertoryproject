package fr.esiea.repertoryproject.metier.model;

public class Adresse {
	private String intitule;
	private String numero;
	private String rue;
	private String codePostal;
	private String ville;

	public Adresse() {
		
	}
	
	public Adresse(String intitule, String numero, String rue, String codePostal, String ville) {
		this.intitule = intitule;
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(numero);
		builder.append(" rue ");
		builder.append(rue);
		builder.append(", ");
		builder.append(codePostal);
		builder.append(" ");
		builder.append(ville);
		return builder.toString();
	}
	
    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 7 + numero.hashCode();
        hash = hash * 12 + rue.hashCode();
        hash = hash * 19 + codePostal.hashCode();
        hash = hash * 6 + ville.hashCode();
        return hash;
    }

}