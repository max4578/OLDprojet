package be.garageEnLigne.classeMetier;

public class LigneDetail {
	// Attribut(s)
	
	private int idLD;
	private int quantite;
	private Voiture v;
	
	// Constructeur(s)
	
	public LigneDetail(int quantite, Voiture v) {
		this.quantite = quantite;
		this.v = v;
	}
	
	// Getter et setter
	
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Voiture getV() {
		return v;
	}
	public void setV(Voiture v) {
		this.v = v;
	}
	public int getIdLD() {
		return idLD;
	}
	public void setIdLD(int idLD) {
		this.idLD = idLD;
	}
}
