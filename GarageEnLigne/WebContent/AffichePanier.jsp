<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="be.garageEnLigne.classeMetier.Panier" %>
<%@ page import="be.garageEnLigne.classeMetier.Voiture" %>
<%@ page import="be.garageEnLigne.classeMetier.LigneDetail" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <link type="text/css" rel="stylesheet" href="css/style3.css" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<%
	Panier p=(Panier)request.getAttribute("Panier");
	ArrayList<LigneDetail> listLD=p.getLD();

	for(LigneDetail ld :listLD){
		out.println("<tbody><tr><th rowspan=\"4\">"+ld.getV().getModele()+"</th><td>"+ld.getV().getCouleur()+"</td><td>"+ld.getV().getPrix()+"</td></tr><tr><td colspan=\"1\">"+ld.getV().getMarque()+"</td><td>Quantité :"+ld.getQuantite()+"</td></tr></tbody>");
		out.println("<form method=\"post\" action=\"supprimer\"><tbody><tr><td><input type=\"hidden\" name=\"id\" value="+ld.getV().getId()+" /><input type=\"hidden\" name=\"nbr\" value=\"0\" /></td><td><input type=\"submit\" value=\"Supression d' un élément\" /></td></form><form action=\"supprimer\" method=\"post\"><td><input type=\"hidden\" name=\"nbr\" value=\"1\" /><input type=\"submit\" value=\"Supression de tout les élément\" /><input type=\"hidden\" name=\"id\" value="+ld.getV().getId()+" /></td></form></tr></tbody>");
	}


%>
<tr><th>Total du panier</th><td colspan="2"><%=p.getPrixTotalPanier() %> €</td></tr>
</table>
 	<a href="MenuPrincipal.jsp">Retour</a>
</body>
</html>