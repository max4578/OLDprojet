package be.garageEnLigne.classeMetier;

import java.util.LinkedList;

import be.garageEnLigne.DAO.AbstractDAOFactory;
import be.garageEnLigne.DAO.DAO;
import be.garageEnLigne.DAO.VoitureDAO;

public class listVoiture {
	
	private LinkedList<Voiture> lv;
	
	public LinkedList<Voiture> getList(){
		return lv;
	}
	
	//Constructeur
	public listVoiture(){
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Voiture> voitureDAO = adf.getVoitureDAO();
		lv=voitureDAO.findAll();	
	}
}
