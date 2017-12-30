package be.garageEnLigne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import be.garageEnLigne.classeMetier.Client;
import be.garageEnLigne.classeMetier.Voiture;

public class VoitureDAO extends DAO<Voiture>{


	
	public VoitureDAO(Connection conn){
		super(conn);
	}	

	
	//Retourne une liste de voiture
	public LinkedList<Voiture> findAll(){
		Voiture voiture = null;
		LinkedList<Voiture> lv= new LinkedList<Voiture>();
		try{
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Voiture");
			ResultSet resultat = prepare.executeQuery();
			while(resultat.next()){
				voiture = new Voiture(resultat.getInt("idVoiture"),resultat.getDouble("prix"),resultat.getString("marque"),resultat.getString("modele"),resultat.getInt("anneeProd"),resultat.getString("couleur"));
				lv.add(voiture);
			}
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de données");
		}
		return lv;
	}
	
	//Retourne la voiture grace a son ID
	public Voiture findVoitureById(int idVoiture){
		Voiture voiture = null;
		
		try{
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Voiture WHERE idVoiture="+idVoiture+"");
			ResultSet resultat = prepare.executeQuery();
			while(resultat.next()){
				voiture = new Voiture(resultat.getInt("idVoiture"),resultat.getDouble("prix"),resultat.getString("marque"),resultat.getString("modele"),resultat.getInt("anneeProd"),resultat.getString("couleur"));
				
			}
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de données");
		}
		return voiture;
	}
	
}
