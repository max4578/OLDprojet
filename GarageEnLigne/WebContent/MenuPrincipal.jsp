<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accueil</title>
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css" />
        <link type="text/css" rel="stylesheet" href="css/style2.css" />
    </head>
    <body>
       <div id="b1">
       		<h1 id="titre1">Accueil</h1>    		
       </div>
    	<div id="cont1" class="row">
		  	<div class="col-xs-6 col-md-3">
			    <a href="AfficheClient.jsp" class="thumbnail">
		      	<img src="img/userIcon.png" alt="">
			    </a>
			    <div id="d1"><p>Profil</p></div>
		  	</div>
  			<div class="col-xs-6 col-md-3">
		    	<a href="listvoiture" class="thumbnail">
		      	<img src="img/buyIcon.png" alt="">
	    		</a>
	    		<div id="d2"><p>Achat</p></div>
	  		</div>
	  		<div class="col-xs-6 col-md-3">
    			<a href="affichePanier" class="thumbnail">
	      		<img src="img/cartIcon.png" alt="">
    			</a>
    			<div id="d3"><p>Panier</p></div>
  			</div>
		</div>
    </body>
</html>