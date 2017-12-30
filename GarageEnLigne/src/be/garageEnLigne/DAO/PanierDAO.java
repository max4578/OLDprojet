package be.garageEnLigne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.garageEnLigne.classeMetier.Client;
import be.garageEnLigne.classeMetier.Panier;

public class PanierDAO extends DAO<Panier>{
	
	public PanierDAO(Connection conn){
		super(conn);
	}	
	
	//Création du Panier
	public boolean create(Panier obj){
		boolean ok = true;
		try{
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Panier VALUES(NULL,?,?)");
		    prepare.setInt (1, obj.getIdCli());
		    prepare.setDouble (2, obj.getPrixTotalPanier());
		    prepare.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donn�es");
			ok = false;
		}
		return ok;
	}
	
	//Retourne le panier l ID
	public Panier findPanByIdCli(int idCli){
		Panier panier = null;
		try{
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Panier WHERE idCli = ?");
			prepare.setInt (1, idCli);
			ResultSet resultat = prepare.executeQuery();
			if(resultat.next())
				panier = new Panier(resultat.getInt("idPanier"), resultat.getInt("idCli"), resultat.getDouble("prixTotal"));
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donn�es");
		}
		return panier;
	}
	
	//Met a jour le prix total du Panier en fonction de son contenu
	public int updatePrix(int idP){
		int somme=0;
		try{
			PreparedStatement prepare = connect.prepareStatement("SELECT sum(ligneDetail.quantité* Voiture.prix) FROM Voiture INNER JOIN (Panier INNER JOIN ligneDetail ON Panier.idPanier = ligneDetail.idPanier) ON Voiture.idVoiture = ligneDetail.idVoiture WHERE LigneDetail.idPanier="+idP+";");
			ResultSet resultat = prepare.executeQuery();
			if(resultat.next())
				somme=resultat.getInt(1);
			prepare = connect.prepareStatement("UPDATE Panier SET prixTotal="+somme+" WHERE idPanier="+idP+"");
		    prepare.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donn�es");
		}
		return somme;
	}
	
	//Supprime une voiture du panier
	public Boolean delete(int idP,int nbr, int idV){
		boolean ok = true;
		try{
			PreparedStatement prepare;
			if(nbr==0){//nbr est comme un boolean; 0:supprimer une voiture  1: supprimer toute les voitures
				prepare = connect.prepareStatement("SELECT ligneDetail.quantité FROM Panier INNER JOIN ligneDetail ON Panier.idPanier = ligneDetail.idPanier WHERE LigneDetail.idPanier="+idP+" AND LigneDetail.idVoiture="+idV+";");
				ResultSet resultat = prepare.executeQuery();
				resultat.next();
				if(resultat.getInt(1)>1)
					prepare=connect.prepareStatement("UPDATE LigneDetail SET quantité=quantité-1 WHERE idPanier="+idP+" AND idVoiture="+idV+"");
				else if(resultat.getInt(1)==1)	
					prepare=connect.prepareStatement("DELETE * FROM LigneDetail WHERE idPanier="+idP+" AND idVoiture="+idV+"");
			    prepare.executeUpdate();
			}
			else if(nbr==1){
				prepare=connect.prepareStatement("DELETE * FROM LigneDetail WHERE idPanier="+idP+" AND idVoiture="+idV+"");
				prepare.executeUpdate();
			}
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donn�es");
			ok = false;
		}
		return ok;
	}
}
