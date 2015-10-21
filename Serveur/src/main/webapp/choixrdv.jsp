<%@ page import="java.util.List"%>
<%@ page import="org.Serveur.BDD"%>
<%@ page import="org.Serveur.Barber"%>


<html>

<head>

<meta charset=UTF-8>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<title>Barbe a Papa</title>
</head>

<%
	BDD bdd = new BDD();
	List<Barber> barbers = bdd.getBarbers();
	int i=0;
	/*int likes = Init.getInstance().getLikeDao().nbLikes(item.getIdt(), item.getType());
	int views = Init.getInstance().getLikeDao().nbVues(item.getIdt(), item.getType());*/
%>

<body>

	<!-- Pas utile
	<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<a class="navbar-brand" href="ListeProfil">Barbe à Papa</a>
				<p class="navbar-text navbar-left"><a href="login.html" class="navbar-link">Connexion et Insciption</a></p>
				<p class="navbar-text navbar-left"><a href="ListeProfil" class="navbar-link">Liste des profils</a></p>
				<p class="navbar-text navbar-left"><a href="matching.jsp" class="navbar-link">Matching</a></p>
			</div>
	</nav>
	<br>-->

	<div class="container">
	<div class='page-header'>
	<h1>Rendez-Vous <small>Barbe a Papa</small></h1></div>
	<%
		for(i=0; i<3 && i<barbers.size(); ++i){
			%>
			<div class="row">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
					<form action='ServletRDV' method='post'>
						<img src="<%out.println(barbers.get(i).getPhoto()); %>" alt="image" class="img-responsive">
						<input type="hidden" name="barbier"  value="<%out.println(barbers.get(i).getEntreprise());%>">
						<div class="caption">
							<h3>
							</h3>
								<h4>Horaires</h4>
								<div class="btn-group" role="group" aria-label="Horaires">
  									<button type="submit" name="horaire" value="14h30" class="btn btn-default">14h30</button>
  									<button type="submit" name="horaire" value="15h30" class="btn btn-default">15h30</button>
  									<button type="submit" name="horaire" value="16h30" class="btn btn-default">16h30</button>
								</div>
							</div>
						</form>
					</div>
				</div>
 <%} %>	
 					
			</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#yes").click(function() {postLike(true);	});
			$("#no").click(function() {postLike(false);	});
		});
		function postLike(aime) {
			$.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : "v2/like/",
				dataType : "json",
				async : false,
				data : JSON.stringify({
					"userid" : 1,
					"itemid" : $("#iditem").val().trim(),
					"itemType" : $("#itemtype").val().trim(),
					"aime": aime
				}),
				success : function(data, textStatus, jqXHR) {
					console.log(data);
					$(location).attr('href',"/matching.jsp");
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('postUser error: ' + textStatus);
				}
			});
			
		}
	</script>
</body>