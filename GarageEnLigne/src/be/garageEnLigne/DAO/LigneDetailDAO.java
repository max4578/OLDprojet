package be.garageEnLigne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import be.garageEnLigne.classeMetier.Client;
import be.garageEnLigne.classeMetier.LigneDetail;
import be.garageEnLigne.classeMetier.Voiture;

public class LigneDetailDAO extends DAO<LigneDetail>{


	
	public LigneDetailDAO(Connection conn){
		super(conn);
	}	
	
	//Création d' une ligne de détail pour un nouvelle voiture
	public Boolean create(int qtt,int idV,int idP){
		boolean ok = true;
		try{
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO ligneDetail (idPanier,idVoiture,quantité) VALUES("+idP+","+idV+","+qtt+");");		
			prepare.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			System.out.println("Erreur de connection base de donn�es");
			ok = false;
		}
		return ok;
		
	}
	
	//Met a jour la quantité de voiture contenue dans le panier
	public Boolean update(LigneDetail ld,int idPanier){
		boolean ok = true;
		try{
			PreparedStatement prepare = connect.prepareStatement("UPDATE ligneDetail SET quantité = quantité+"+ld.getQuantite()+" WHERE idPanier="+idPanier+" AND idVoiture="+ld.getV().getId()+";");
		    prepare.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donn�es");
			ok = false;
		}
		return ok;
	}
	
	//Retourne la liste des ligneDétail(quantité)
	public ArrayList<LigneDetail> findAllLD(int idPanier){
		LigneDetail ld;
		Voiture v;
		ArrayList<LigneDetail> list= new ArrayList<LigneDetail>();
		try{
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM LigneDetail WHERE idPanier="+idPanier+"");
			ResultSet resultat = prepare.executeQuery();
			while(resultat.next()){
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				DAO<Voiture> vDAO = adf.getVoitureDAO();
				
				v= vDAO.findVoitureById(resultat.getInt("idVoiture"));
				ld = new LigneDetail(resultat.getInt("quantité"),v);
				list.add(ld);
			}
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de données");
		}
		return list;
	}
	
}