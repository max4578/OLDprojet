package be.garageEnLigne.servlet;

import java.io.IOException;
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
 * Servlet implementation class GetPanier
 */
@WebServlet("/GetPanier")
public class GetPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request,response);
   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		// Récupération de la session en cours
		HttpSession session = request.getSession();
		// Récupération du client par la session
		Client client = (Client) session.getAttribute("clientActuel");
		//Initialisation du DAO
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Panier> panierDAO = adf.getPanierDAO();
		//Retrouve le panier du client par son ID
		Panier p=panierDAO.findPanByIdCli(client.getIdCli());	
		p.calculTotal();
		//Ajout du panier a la session
		session.setAttribute("panierActuel", p);
		request.setAttribute("Panier",p);
		//redirection vers le panier
        getServletContext().getRequestDispatcher("/AffichePanier.jsp").forward(request, response);
	}

}
