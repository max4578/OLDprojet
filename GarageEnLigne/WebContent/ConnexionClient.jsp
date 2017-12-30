<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion client</title>
        <link type="text/css" rel="stylesheet" href="css/style.css" />
    </head>
    <body>
        <div>
            <form method="post" action="ConnexionClient">
                <fieldset>
                    <legend>Connexion client</legend>
       		
                    <label for="mailClient">E-mail</label>
                    <input type="email" id="mailClient" name="mailClient" value="${ client.getMailCli() }" size="20" maxlength="40" />
                    <br />
                    
                    <label for="prenomClient">Mot de passe</label>
                    <input type="password" id="mdpClient" name="mdpClient" value="" size="20" maxlength="40" />                    
                    <br />
                    
                    <span class="erreur"><br />${ client.getErreurs("erreurDB") }</span>  
                    <span class="erreur">${ client.getErreurs("erreurConnexion") }</span>
                </fieldset>                            
                <input type="submit" value="Connexion"  />
                <a href="CreationClient.jsp">Inscription</a> <br />
            </form>
        </div>
    </body>
</html>