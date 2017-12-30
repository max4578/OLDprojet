<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Enregistrement client</title>
        <link type="text/css" rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <div>
            <form method="post" action="CreationClient">
                <fieldset>
                    <legend>Enregistrement client</legend>
    
                    <label for="nomClient">Nom </label>
                    <input type="text" id="nomClient" name="nomClient" value="${ client.getNomCli() }" size="20" maxlength="20" />
                    <span class="erreur">${ client.getErreurs("erreurNom") }</span>
                    <br />
                    
                    <label for="prenomClient">Prénom </label>
                    <input type="text" id="prenomClient" name="prenomClient" value="${ client.getPrenomCli() }" size="20" maxlength="40" />
                    <span class="erreur">${ client.getErreurs("erreurPrenom") }</span>
                    <br />
                    
                    <label for="emailClient">Adresse email</label>
                    <input type="email" id="emailClient" name="emailClient" value="${ client.getMailCli() }" size="20" maxlength="60" />
                    <span class="erreur">${ client.getErreurs("erreurMail") }</span>
                    <br />
    
                    <label for="adresseClient">Adresse</label>
                    <input type="text" id="adresseClient" name="adresseClient" value="${ client.getRueCli() }" size="20" maxlength="40" />
                    <span class="erreur">${ client.getErreurs("erreurRue") }</span>
                    <br />
                    
                    <label for="villeClient">Ville</label>
                    <input type="text" id="villeClient" name="villeClient" value="${ client.getVilleCli() }" size="20" maxlength="40" />
                    <span class="erreur">${ client.getErreurs("erreurVille") }</span>
                    <br />
                    
                    <label for="cpClient">Code Postale</label>
                    <input type="text" id="cpClient" name="cpClient" value="${ client.getCodePostal() }" size="20" maxlength="40" />
                    <span class="erreur">${ client.getErreurs("erreurCodePostal") }</span>
                    <br />
                    
    				<label for="mdpClient">Mot de passe</label>
                    <input type="password" id="mdpClient" name="mdpClient" value="" size="20" maxlength="40" />
                    <span class="erreur">${ client.getErreurs("erreurMdp") }</span>
                    <br />
                    <span class="erreur">${ client.getErreurs("erreurDB") }</span>  
                </fieldset>             
                <input type="submit" value="Valider"/>
                <a href="ConnexionClient.jsp">Retour à la connexion</a> <br />
            </form>
        </div>
    </body>
</html>