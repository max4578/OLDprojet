package be.garageEnLigne.classeMetier;

import java.util.ArrayList;

import be.garageEnLigne.DAO.AbstractDAOFactory;
import be.garageEnLigne.DAO.DAO;

public class Panier {
	// Attribut(s)
	
	private int idPanier;
	private int idCli;
	private ArrayList<LigneDetail> ld;
	private double prixTotalPanier;
	
	// Constructeur(s)
	
	public Panier(int idCli){
		this.idCli = idCli;
		this.prixTotalPanier = calculTotal();
		this.ld = new ArrayList<LigneDetail>();
		
	}
	
	public Panier(int idPanier, int idCli, double prixTotal){
		this.idPanier = idPanier;
		this.idCli = idCli;
		this.prixTotalPanier = prixTotal;
		//TODO: recuperer les ligne détail
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<LigneDetail> ldDAO = adf.getLigneDetail();
		
		this.ld = ldDAO.findAllLD(idPanier);
	}
	
	// Getter et setter
	
	public int getIdPanier(){
		return idPanier;
	}
	public ArrayList<LigneDetail> getLD(){
		return ld;
	}
	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}
	public int getIdCli(){
		return idCli;
	}
	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}
	public double getPrixTotalPanier() {
		return prixTotalPanier;
	}
	public void setPrixTotalPanier(double prixTotalPanier) {
		this.prixTotalPanier = prixTotalPanier;
	}

	//Vérifie si le panier contient une voiture de la même ID
	public void contient(int id,int qtt) {
		Boolean trouve=false;
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);		
		DAO<LigneDetail> ldDAO = adf.getLigneDetail();		
		for(LigneDetail l:ld){			
			if(l.getV().getId()==id){//Mise a jour de la quantité
				LigneDetail ligneD= new LigneDetail(qtt,l.getV());
				ldDAO.update(ligneD,idPanier);
				trouve=true;
			}
				
		}
		
		if(trouve==false){//Création de l' enregistrement
			ldDAO.create(qtt,id,idPanier);
		}
		prixTotalPanier=calculTotal();
	}
	
	public double calculTotal(){
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);		
		DAO<Panier> PanierDAO = adf.getPanierDAO();
		prixTotalPanier=PanierDAO.updatePrix(idPanier);
		return prixTotalPanier;
	}
}
