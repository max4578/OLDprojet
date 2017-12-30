package be.garageEnLigne.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.garageEnLigne.DAO.AbstractDAOFactory;
import be.garageEnLigne.DAO.DAO;
import be.garageEnLigne.classeMetier.Client;
import be.garageEnLigne.classeMetier.Panier;
import be.garageEnLigne.classeMetier.listVoiture;

/**
 * Servlet implementation class SupprimerVoiture
 */
@WebServlet("/SupprimerVoiture")
public class SupprimerVoiture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	doPost(request,response);
	   
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			//Récupération des valeurs du formulaire
			int idV = Integer.parseInt(request.getParameter("id"));
			int nbr = Integer.parseInt(request.getParameter("nbr"));//nbr est comme un boolean; 0:supprimer une voiture  1: supprimer toute les voitures
			// Récupération de la session en cours
			HttpSession session = request.getSession();
			// Récupération du client par la session
			Client client = (Client) session.getAttribute("clientActuel");
			//Récupération du panier par la session
			Panier p=(Panier) session.getAttribute("panierActuel");
			//Initialisation du DAO Panier
			AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
			DAO<Panier> panierDAO = adf.getPanierDAO();
			//Suppression
			panierDAO.delete(p.getIdPanier(),nbr,idV);
			//Redirection vers le panier
	        getServletContext().getRequestDispatcher("/affichePanier").forward(request, response);
			
		}

}
