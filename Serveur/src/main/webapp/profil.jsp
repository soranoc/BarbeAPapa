
<%@ page import="java.util.List"%>
<%@ page import="org.Serveur.BDD"%>
<%@ page import="org.Serveur.Item"%>
<%@ page import="org.Serveur.Barber"%>
<%@ page import="org.Serveur.Client"%>

<!DOCTYPE html>
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

<!-- En-tÃªte de la page -->
<meta charset="utf-8" />
<title>Profil</title>

</head>

<%
	BDD bdd = new BDD();
	List<Barber> barbers = bdd.getBarbers();
	List<Client> clients = bdd.getClients();
	Barber barber = null;
	Client client = null;
	String login = "angetheo@gmail.com";
	for (int i = 0; i < barbers.size(); ++i) {
		if (barbers.get(i).getMail().equals(login)) {
			barber = barbers.get(i);
		}
	}
	if (barber == null) {
		for (int i = 0; i < clients.size(); ++i) {
			if (clients.get(i).getMail().equals(login)) {
				client = clients.get(i);
			}
		}
	}
%>

<body>
	<div class="container">
		<div class="page-header">
			<h1>
				<%
					if (barber != null) {
						out.print(barber.getEntreprise());
					} else {
						out.print(client.getPrenom() + " " + client.getNom());
					}
				%><small> Profil</small> <img id="moustache"
					src="http://img4.hostingpics.net/pics/366706moustache.png">
			</h1>
		</div>
	</div>

	<%
		if (barber != null) {
	%>
	<div class="container">
		<div class="row">
			<div class="container">
				<div class="col-xs-6 col-md-3">
					<a id=profilepic href="#" class="thumbnail"> <img
						src="<%out.print(barber.getPhoto());%>" alt="">
					</a>
				</div>
			</div>
			<div class="container">
				<div class="col-xs-6 col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3>Coordonnées</h3>
						</div>
						<div class="panel-body">
							<h4>Téléphone</h4>
							<%
								out.print(barber.getTel());
							%><br>
							<h4>E-Mail</h4>
							<%
								out.print(barber.getMail());
							%><br>
							<h4>Ville</h4>
							<%
								out.print(barber.getVille());
							%><br>
							<h4>Adresse</h4>
							<%
								out.print(barber.getAdresse());
							%><br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		} else {
	%>
	<div class="container">
		<div class="row">
			<div class="container">
				<div class="col-xs-6 col-md-3">
					<a id=profilepic href="#" class="thumbnail"> <img
						src="<%out.print(client.getPhoto());%>" alt="">
					</a>
				</div>
			</div>
			<div class="container">
				<div class="col-xs-6 col-md-6">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3>Coordonnées</h3>
						</div>
						<div class="panel-body">
							<h4>Téléphone</h4>
							<%
								out.print(client.getTel());
							%><br>
							<h4>E-Mail</h4>
							<%
								out.print(client.getMail());
							%><br>
							<h4>Ville</h4>
							<%
								out.print(client.getVille());
							%><br>
							<h4>Adresse</h4>
							<%
								out.print(client.getAdresse());
							%><br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		}
	%>
</body>
</html>
