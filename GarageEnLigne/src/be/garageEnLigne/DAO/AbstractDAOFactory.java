package be.garageEnLigne.DAO;

import be.garageEnLigne.classeMetier.Client;
import be.garageEnLigne.classeMetier.LigneDetail;
import be.garageEnLigne.classeMetier.Panier;
import be.garageEnLigne.classeMetier.Voiture;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	public abstract DAO<Client> getClientDAO();
	public abstract DAO<Panier> getPanierDAO();
	public abstract DAO<Voiture> getVoitureDAO();
	public abstract DAO<LigneDetail> getLigneDetail();

	public static AbstractDAOFactory getFactory(int type){
		switch(type){
			case DAO_FACTORY: return new DAOFactory();
			default: return null;
		}
	}

}