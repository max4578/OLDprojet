package be.garageEnLigne.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.garageEnLigne.DAO.AbstractDAOFactory;
import be.garageEnLigne.DAO.DAO;
import be.garageEnLigne.classeMetier.Client;
import be.garageEnLigne.classeMetier.LigneDetail;
import be.garageEnLigne.classeMetier.Panier;
import be.garageEnLigne.classeMetier.listVoiture;

/**
 * Servlet implementation class AjoutPanier
 */
@WebServlet("/AjoutPanier")
public class AjoutPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doPost(request,response);
	   
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//Récupération des valeurs du formulaires
			int id = Integer.parseInt(request.getParameter("id"));
			int qtt = Integer.parseInt(request.getParameter("qtt"));
			// Récupération de la session en cours
			HttpSession session = request.getSession();
			// Récupération du client par la session
			Client client = (Client) session.getAttribute("clientActuel");
			//Initialisation du DAO
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
			DAO<Panier> panierDAO = adf.getPanierDAO();
			//Recherche du panier par l id du client
			Panier p=panierDAO.findPanByIdCli(client.getIdCli());
			p.contient(id,qtt);
			//Rechargement de la page	
			listVoiture list= new listVoiture();
		    request.setAttribute("List",list);
		    //Redirection a la page d' achat
	        getServletContext().getRequestDispatcher("/listvoiture").forward(request, response);
			
		}


}
