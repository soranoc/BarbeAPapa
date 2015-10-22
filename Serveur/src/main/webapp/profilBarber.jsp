
<%@ page import="java.util.List"%>
<%@ page import="org.Serveur.BDD"%>
<%@ page import="org.Serveur.Barber"%>

<!DOCTYPE html>
<html>
	<head>
        <!-- En-tête de la page -->
        <meta charset="utf-8" />
        <title>Profil</title>
	<script type="text/javascript">
		function open_infos(){
			width = 540;
			height = 600;
 			if(window.innerWidth){
				var left = (window.innerWidth-width)/2;
				var top = (window.innerHeight-height)/2;
			}
			else{
				var left = (document.body.clientWidth-width)/2;
				var top = (document.body.clientHeight-height)/2;
			}
			window.open('galery.html','Gallery de nom','menubar=no, scrollbars=no, top='+top+', left='+left+', width='+width+', height='+height+'');
		}
	</script>
	<script>(function(d, s, id) {
 		 var js, fjs = d.getElementsByTagName(s)[0];
		  if (d.getElementById(id)) return;
		  js = d.createElement(s); js.id = id;
 		 js.src = "//connect.facebook.net/fr_FR/sdk.js#xfbml=1&version=v2.3";
		  fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	</head>

	<body>
	<div id="fb-root"></div>
	<script>(function(d, s, id) {
 		 var js, fjs = d.getElementsByTagName(s)[0];
		  if (d.getElementById(id)) return;
		  js = d.createElement(s); js.id = id;
 		 js.src = "//connect.facebook.net/fr_FR/sdk.js#xfbml=1&version=v2.3";
		  fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<% 	
	BDD bdd = new BDD();
	List<Barber> barbers = bdd.getBarbers();	
	Barber barbe= null;
	String login = request.getParameter("login");
	for(int i=0; i<barbers.size(); ++i){
		if (barbers.get(i).getMail().equals(login)){
			barbe = barbers.get(i);
		}
	}
	%>

	<a href="javascript:open_infos()" target="blank"><img src=<%out.println(barbe.getPhoto());%> alt="image profil" style="width:300px;heigth:300px"></a>
	<div class="fb-like" data-href="profil.html" data-width="50" data-layout="standard" data-action="like" data-show-faces="false" data-share="true"></div>
	<br> 
        <p> Nom: <%out.println(barbe.getNom()); %></p>
        <p> Prenom: <%out.println(barbe.getPrenom()); %></p>
		<p> Profession: <%out.println(barbe.getTypeDePrestation()); %></p>
  		<p> Entreprise: <%out.println(barbe.getEntreprise()); %></p>
        <p> Adresse de l'entreprise: <%out.println(barbe.getAdresse()); %></p>
        <p> Telephone: <%out.println(barbe.getTel()); %></p>
        <p> Fax: <%out.println(barbe.getFax()); %></p>
        <p> Mail: <%out.println(barbe.getMail()); %></p>
	</b>
	<img src="http://www.clementpellerin.fr/wp-content/uploads/2011/05/facebook-icon.png" alt="lien Facebook" style="width:50px;heigth:50px">
	<img src="http://www.sidassport.com/docs/2280-1-logo-twitter-gif.gif" alt="lien Facebook" style="width:50px;heigth:50px">
	<img src="http://www.uha.fr/images/google_icon" style="width:50px;heigth:50px">
    </body>
</html>
