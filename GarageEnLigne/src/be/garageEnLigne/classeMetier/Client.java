package be.garageEnLigne.classeMetier;

import java.util.HashMap;

import be.garageEnLigne.DAO.AbstractDAOFactory;
import be.garageEnLigne.DAO.DAO;

public class Client {
	
	// Attribut(s)
	
	private int idCli;
	private String nomCli;
	private String prenomCli;
	private String mailCli;
	private String rueCli;
	private String codePostal;
	private String villeCli;
	private String motDePasseCli;
	private HashMap<String,String> erreurs;
	private Panier pan;
	
	// Constructeur(s)
	
	public Client(int idCli, String nomCli, String prenomCli, String mailCli, String rueCli, String codePostal,
			String villeCli, String motDePasseCli, HashMap<String, String> erreurs, Panier pan) {
		
		this.idCli = idCli;
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.mailCli = mailCli;
		this.rueCli = rueCli;
		this.codePostal = codePostal;
		this.villeCli = villeCli;
		this.motDePasseCli = motDePasseCli;
		this.erreurs = erreurs;
		this.pan = pan;
	}
	
	public Client(int idCli, String nomCli,String prenomCli, String mailCli, String rueCli, String codePostal,
			String villeCli, String motDePasseCli){
		
		this.idCli = idCli;
		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.mailCli = mailCli;
		this.rueCli = rueCli;
		this.codePostal = codePostal;
		this.villeCli = villeCli;
		this.motDePasseCli = motDePasseCli;
		this.erreurs = new HashMap<String,String>();
	}
	
	public Client(String nomCli,String prenomCli, String mailCli, String rueCli, String codePostal,
			String villeCli, String motDePasseCli){

		this.nomCli = nomCli;
		this.prenomCli = prenomCli;
		this.mailCli = mailCli;
		this.rueCli = rueCli;
		this.codePostal = codePostal;
		this.villeCli = villeCli;
		this.motDePasseCli = motDePasseCli;
		this.erreurs = new HashMap<String,String>();
	}
	
	public Client(String mailCli, String motDePasseCli){
		this.mailCli = mailCli;
		this.motDePasseCli = motDePasseCli;
		this.erreurs = new HashMap<String,String>();
	}
	
	// Getter et setter
	
	public int getIdCli() {
		return idCli;
	}
	
	public void setIdCli(int idCli) {
		this.idCli = idCli;
	}
	
	public String getNomCli() {
		return nomCli;
	}
	
	public void setNomCli(String nomCli) {
		this.nomCli = nomCli;
	}
	
	public String getPrenomCli() {
		return prenomCli;
	}
	
	public void setPrenomCli(String prenomCli) {
		this.prenomCli = prenomCli;
	}
	
	public String getMailCli() {
		return mailCli;
	}
	
	public void setMailCli(String mailCli) {
		this.mailCli = mailCli;
	}
	
	public String getRueCli() {
		return rueCli;
	}
	
	public void setRueCli(String rueCli) {
		this.rueCli = rueCli;
	}
	
	public String getCodePostal() {
		return codePostal;
	}
	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	
	public String getVilleCli() {
		return villeCli;
	}
	
	public void setVilleCli(String villeCli) {
		this.villeCli = villeCli;
	}
	
	public String getMotDePasseCli() {
		return motDePasseCli;
	}
	
	public void setMotDePasseCli(String motDePasseCli) {
		this.motDePasseCli = motDePasseCli;
	}
	
	public String getErreurs(String nomIndex) {
		return erreurs.get(nomIndex);
	}
	
	public void setErreurs(HashMap<String, String> erreurs) {
		this.erreurs = erreurs;
	}
	
	public HashMap<String, String> getErreurs() {
		return erreurs;
	}
	// Méthode(s)
	
	private void validNom(){
		if(this.nomCli.equals(""))
			this.erreurs.put("erreurNom", "Nom requis");				
	}
	
	private void validPrenom(){
		if(this.prenomCli.equals(""))
			this.erreurs.put("erreurPrenom", "Prénom requis");				
	}
	
	private void validMail(){
		try{
			if(this.mailCli.equals(""))
				this.erreurs.put("erreurMail", "Adresse E-mail requise");
			else{
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				DAO<Client> clientDAO = adf.getClientDAO();	
				if(clientDAO.findByMail(this) != null)
					erreurs.put("erreurMail", "L'adresse mail existe déja");
			}
		}
		catch(Exception e){
			erreurs.put("erreurDB", "Erreur de connection à la base de données");
		}				
	}
	
	private void validRue(){
		if(this.rueCli.equals(""))
			this.erreurs.put("erreurRue", "Adresse requise");				
	}
	
	private void validVille(){
		if(this.villeCli.equals(""))
			this.erreurs.put("erreurVille", "Ville requise");				
	}
	
	private void validCodePostal(){
		if(this.codePostal.equals(""))
			this.erreurs.put("erreurCodePostal", "Code postal requis");		
		else{
			try{
				Integer.parseInt(codePostal);			
			}
			catch(Exception e){
				erreurs.put("erreurCodePostal", "Nombre entier uniquement");
			}
		}
	}
	
	private void validMdp(){
		if(this.motDePasseCli.equals(""))
			this.erreurs.put("erreurMdp", "Mot de passe requis");		
		else{
			if(motDePasseCli.length()<6)
				this.erreurs.put("erreurMdp", "Mot de passe de minimum 6 caractères");				
		}
	}
	
	// Validation globale des donn�es
	public void validSaisie(){
		validNom();
		validPrenom();
		validMail();
		validRue();
		validVille();
		validCodePostal();
		validMdp();
		
		// Si aucunes erreurs => insertion dans la base de données
		if(erreurs.isEmpty()){
			try{
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				DAO<Client> clientDAO = adf.getClientDAO();
				DAO<Panier> panierDAO = adf.getPanierDAO();
				// Création du client dans la DB
				clientDAO.create(this);
				// Récupération de l'id du client dans la DB
				int idClient = clientDAO.findByMail(this).getIdCli();
				this.idCli = idClient;
				// Création d'un panier dans la DB
				Panier panier1 = new Panier(idClient);
				panierDAO.create(panier1);
				// Récupération du panier lié au client avec son id
				Panier panier2 = panierDAO.findPanByIdCli(idClient);
				// Lien entre Panier et Client en POO
				this.pan = panier2;				
			}
			catch(Exception e){
				System.out.println(e);
				erreurs.put("erreurDB", "Erreur de connection à la base de données");
			}
		}
	}
	
	public void connexionClient(){
		 if(erreurs.isEmpty()){
			 try{
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				DAO<Client> clientDAO = adf.getClientDAO();
				DAO<Panier> panierDAO = adf.getPanierDAO();
				if(clientDAO.findByMailPassword(this) == null)
					erreurs.put("erreurConnexion", "Identifiant/Mot de passe incorrect");
				else{
					// Récupération du client depuis la DB
					Client c1 = clientDAO.findByMail(this);
					// Récupération du panier + lien du panier avec la client en POO
					this.pan = panierDAO.findPanByIdCli(c1.idCli);
					// Affectation des données au client actuel
					this.idCli = c1.idCli;
					this.nomCli = c1.nomCli;
					this.prenomCli = c1.prenomCli;
					this.rueCli = c1.rueCli;
					this.codePostal = c1.codePostal;
					this.villeCli = c1.villeCli;
				}
					
			 }		 
			catch(Exception e){
				erreurs.put("erreurDB", "Erreur de connection à la base de données");
			}		 
		 }
	}
}
