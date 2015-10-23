<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="bdd.BDD"%>
<%@ page import="bdd.Barber"%>
<%@ page import="bdd.Init"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="javax.ws.rs.core.GenericType"%>
<%@ page import="javax.ws.rs.WebApplicationException"%>
<%@ page import="javax.ws.rs.client.Entity"%>
<%@ page import="javax.ws.rs.core.Application"%>
<%@ page import="javax.ws.rs.core.MediaType"%>

<html>
<head>
<meta charset=UTF-8>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="style.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<title>Barbe a Papa</title>
</head>

<%
	String recherche = request.getParameter("search");
	BDD bdd = new BDD();
	List<Barber> barbers = bdd.getBarbers();
	//Méthode Java remplaçant la méthode JSON qui ne marche pas
	if(recherche!=null){
		barbers = Init.getInstance().getBarberDao().search("%"+recherche+"%");
	}
	String login = request.getParameter("login");
%>

<body>

	<br>
	<div class="container">
		<div class='page-header'>
			<img id="header"
				src="http://img15.hostingpics.net/pics/270845pinkmoustache.png" />
			<div class="row">

				<form class="navbar-form navbar" role="search" action="choixrdv.jsp" method="get">
					<h1>
						Planifiez votre rendez-vous
						<div class="form-group">
							<input type="text" name="search" class="col-sm-2 push-col-md-1 form-control"
								placeholder="Recherche">
						</div>
						<button type="submit" class="btn btn-default">Rechercher</button>
						<a class="btn btn-default"
							href="profil.jsp?login=<%out.print(login);%>" role="button">Profil</a>
					</h1>
				</form>
			</div>
		</div>
	</div>
	<div class='container'>
		<div class="row">
			<%
				for (int i = 0; i < barbers.size(); ++i) {
					if (i % 3 == 0) {
			%>
		</div>
	</div>
	<div class='container'>
		<div class="row">
			<%
				}
			%>
			<div class="col-sm-6 col-md-4">
				<div id="thumbnailBarbier" class="thumbnail">
					<form action='ServletRDV' method='post'>
						<img id="thumbBarber"
							src="<%out.println(barbers.get(i).getPhoto());%>"
							class="img-responsive"> <input type="hidden" name="barbier"
							value="<%out.print(barbers.get(i).getEntreprise());%>"> <input
							type="hidden" name="mail"
							value="<%out.print(barbers.get(i).getMail());%>">
						<div class="caption">
							<h3>
								<%
									out.println(barbers.get(i).getEntreprise());
								%>
							</h3>
							<h4>Horaires</h4>
							<div class="btn-group" role="group" aria-label="Horaires">
								<button type="submit" name="horaire" value="14h30"
									class="btn btn-default">14h30</button>
								<button type="submit" name="horaire" value="15h30"
									class="btn btn-default">15h30</button>
								<button type="submit" name="horaire" value="16h30"
									class="btn btn-default">16h30</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
</body>