package be.garageEnLigne.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.garageEnLigne.classeMetier.Client;

public class ClientDAO extends DAO<Client>{
	
	public ClientDAO(Connection conn){
		super(conn);
	}	
	public boolean create(Client obj){
		boolean ok = true;
		try{
			PreparedStatement prepare = connect.prepareStatement("INSERT INTO Client VALUES(NULL,?,?,?,?,?,?,?)");
		    prepare.setString (1, obj.getNomCli());
		    prepare.setString (2, obj.getPrenomCli());
		    prepare.setString(3, obj.getMailCli());
		    prepare.setString(4, obj.getRueCli());
		    prepare.setInt(5, Integer.parseInt(obj.getCodePostal()));
		    prepare.setString(6, obj.getVilleCli());
		    prepare.setString(7, obj.getMotDePasseCli());
		    prepare.executeUpdate();
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donn�es");
			ok = false;
		}
		return ok;
	}
	/*
	public Client find(int n){
		Client client = null;
		try{
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Client WHERE idCli = ?");
			prepare.setInt (1, n);
			ResultSet resultat = prepare.executeQuery();
			if(resultat.next())
				Client = new Client(resultat.getInt("idCli"),resultat.getString("nomCli"),resultat.getString("prenomCli"),resultat.getString("mailCli"),resultat.getString("rueCli"),resultat.getInt("codePostalCli"),resultat.getString("villeCli"),resultat.getString("motDePasseCli"));
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de donn�es");
		}
		return client;
	}
	*/
	public Client findByMailPassword(Client obj){
		Client client = null;
		try{
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Client WHERE mailCli = ? AND motDePasseCli = ?");
			prepare.setString (1, obj.getMailCli());
			prepare.setString (2, obj.getMotDePasseCli());
			ResultSet resultat = prepare.executeQuery();
			if(resultat.next())
				client = new Client(resultat.getInt("idCli"), resultat.getString("nomCli"), resultat.getString("prenomCli"), resultat.getString("mailCli"), resultat.getString("rueCli"), resultat.getString("codePostalCli"), resultat.getString("villeCli"), resultat.getString("motDePasseCli"));
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de données");
		}
		return client;
	}
	
	public Client findByMail(Client obj){
		Client client = null;
		try{
			PreparedStatement prepare = connect.prepareStatement("SELECT * FROM Client WHERE mailCli = ?");
			prepare.setString (1, obj.getMailCli());
			ResultSet resultat = prepare.executeQuery();
			if(resultat.next())
				client = new Client(resultat.getInt("idCli"), resultat.getString("nomCli"), resultat.getString("prenomCli"), resultat.getString("mailCli"), resultat.getString("rueCli"), resultat.getString("codePostalCli"), resultat.getString("villeCli"), resultat.getString("motDePasseCli"));
		}
		catch(SQLException e){
			System.out.println(e);
			System.out.println("Erreur de connection base de données");
		}
		return client;
	}
}

