package be.garageEnLigne.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.garageEnLigne.classeMetier.Client;


@WebServlet("/AfficheClient")
public class AfficheClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récupération de la session en cours
		HttpSession session = request.getSession();
		// Récupération du client par la session
		Client client = (Client) session.getAttribute("clientActuel");
		// Préparation de l'objet pour envoi vers la JSP
		request.setAttribute("client", client);			
		// Appel de la JSP
		this.getServletContext().getRequestDispatcher( "/AfficheClient.jsp" ).forward( request, response );
	}

}
