<%@ page pageEncoding="UTF-8" %> 
<%@ page import="be.garageEnLigne.classeMetier.listVoiture" %>
<%@ page import="be.garageEnLigne.classeMetier.Voiture" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link type="text/css" rel="stylesheet" href="css/style3.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liste des article</title>
</head>
<body>
<table>
<caption>
Liste des voitures
</caption>

  <thead>
    <tr>   
     <th>Modèle</th>
     <th>Couleur</th>
     <th>Prix</th>
    </tr>
  </thead>

  <tfoot>
    <tr>
      <th>Modèle</th>
     <th>Couleur</th>
     <th>Prix</th>
    </tr>
  </tfoot>

<%

	listVoiture lv=(listVoiture)request.getAttribute("List");
	
	for(Voiture v :lv.getList()){
		out.println("<tbody><tr><th rowspan=\"3\">"+v.getModele()+"</th><td>"+v.getCouleur()+"</td><td>"+v.getPrix()+"</td></tr><tr><td colspan=\"3\">"+v.getMarque()+"</td></tr></tbody>");
		out.println("<form method=\"post\" action=\"ajoutPanier\"><tbody><tr><th></th><td>Quantité : <input required=\"required\" type=\"number\" name=\"qtt\" min=\"1\" max=\"64\" value=\"1\"/><input required=\"required\" type=\"hidden\" name=\"id\" value="+v.getId()+" /></td><td><input type=\"submit\" value=\"Ajout au panier\" /></td></tr></tbody></form>");
}


%>
</table>
 <a href="MenuPrincipal.jsp">Retour</a>
 
</body>
</html>