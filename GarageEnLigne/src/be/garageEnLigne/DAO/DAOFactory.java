package be.garageEnLigne.DAO;

import java.sql.Connection;
import be.garageEnLigne.classeMetier.Client;
import be.garageEnLigne.classeMetier.LigneDetail;
import be.garageEnLigne.classeMetier.Panier;
import be.garageEnLigne.classeMetier.Voiture;


public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = DriverACCESS.getInstance();
	
	public DAO<Client> getClientDAO(){
		return new ClientDAO(conn);
	}
	
	public DAO<Panier> getPanierDAO(){
		return new PanierDAO(conn);
	}

	
	public DAO<Voiture> getVoitureDAO() {
		return new VoitureDAO(conn);
	}

	
	public LigneDetailDAO getLigneDetail() {
		return new LigneDetailDAO(conn);
	}
	

}
