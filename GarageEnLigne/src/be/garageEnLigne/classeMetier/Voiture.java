package be.garageEnLigne.classeMetier;

public class Voiture{
	// Attribut(s)
	
	private int idVoiture;
	private double prix;
	private String marque;
	private String modele;
	private int anneeProduction;
	private String couleur;
	
	// Constructeur(s)
	
	public Voiture(int id,double prix, String marque, String modele, int anneeProduction, String couleur) {
		this.idVoiture=id;
		this.prix = prix;
		this.marque = marque;
		this.modele = modele;
		this.anneeProduction = anneeProduction;
		this.couleur = couleur;
	}

	// Getter et setter
	
	public int getId() {
		return idVoiture;
	}
	public String getModele() {
		return modele;
	}
	public Double getPrix() {
		return prix;
	}
	public String getMarque() {
		return marque;
	}
	public int getAnneeProduction() {
		return anneeProduction;
	}
	public void setAnneeProduction(int anneeProduction) {
		this.anneeProduction = anneeProduction;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
}
