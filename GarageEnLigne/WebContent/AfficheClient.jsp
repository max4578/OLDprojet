<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Information utilisateur</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    	<h1>Information utilisateur</h1>
        <p>Nom : ${ sessionScope.clientActuel.getNomCli() }</p>
        <p>Prénom : ${ sessionScope.clientActuel.getPrenomCli() }</p>
        <p>Email : ${ sessionScope.clientActuel.getMailCli() }</p>
        <p>Adresse : ${ sessionScope.clientActuel.getRueCli() }</p>
        <p>Ville : ${ sessionScope.clientActuel.getVilleCli() }</p>
        <p>Code Postal : ${ sessionScope.clientActuel.getCodePostal() }</p>
        <a href="MenuPrincipal.jsp">Retour</a>
    </body>
</html>