package be.garageEnLigne.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.garageEnLigne.classeMetier.Client;

@WebServlet("/ConnexionClient")
public class ConnexionClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des informations du formulaire
		String mail = request.getParameter("mailClient");
		String mdp = request.getParameter("mdpClient");
		
		// Création de l'objet qui traitera les informations
		Client client = new Client(mail,mdp);
		// Traitement des informations
		client.connexionClient();
		
		// Préparation de l'objet pour envoi vers la JSP
		request.setAttribute("client", client);
		
		// Appel de la JSP
		if(!client.getErreurs().isEmpty())
			this.getServletContext().getRequestDispatcher( "/ConnexionClient.jsp" ).forward( request, response );
		else{
			// Ouverture d'une session si inexistante
			HttpSession session = request.getSession();
			// Mise en session du client
			session.setAttribute("clientActuel", client);
			this.getServletContext().getRequestDispatcher( "/MenuPrincipal.jsp" ).forward( request, response );
		}
	}

}
