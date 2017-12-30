package be.garageEnLigne.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;

import be.garageEnLigne.classeMetier.LigneDetail;
import be.garageEnLigne.classeMetier.Panier;
import be.garageEnLigne.classeMetier.Voiture;

public abstract class DAO<T> {
protected Connection connect = null;
	
	public DAO(Connection conn){
		this.connect = conn;
	}
	
	public boolean create(T obj){return false;}
	
	public boolean delete(T obj){return false;}
	
	public boolean update(T obj){return false;}
	
	public T find(int id){return null;}
	
	public LinkedList<T> findAll(){return null;}
	
	public ArrayList<T> findAllLD(int id){return null;}
	
	public Voiture findVoitureById(int id){return null;}
	
	public T findByMailPassword(T obj){return null;}
	
	public T findByMail(T obj){return null;}
	
	public Panier findPanByIdCli(int idCli){return null;}

	public Boolean update(LigneDetail ligneD, int idPanier) {return false;}

	public Boolean create(int qtt, int idV, int idP) {return false;}

	public int updatePrix(int idPanier) {return 0;}
	
	public Boolean delete(int numP,int nbr,int idV) {return false;}
}