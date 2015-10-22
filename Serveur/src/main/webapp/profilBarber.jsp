
<%@ page import="java.util.List"%>
<%@ page import="org.Serveur.BDD"%>
<%@ page import="org.Serveur.Barber"%>

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

<!-- En-tête de la page -->
<meta charset="utf-8" />
<title>Profil</title>

</head>


<%
	BDD bdd = new BDD();
	List<Barber> barbers = bdd.getBarbers();
	Barber barber = null;
	String login = request.getParameter("login");
	for (int i = 0; i < barbers.size(); ++i) {
		if (barbers.get(i).getMail().equals(login)) {
			barber = barbers.get(i);
		}
	}
%>

<body>
<div class="page-header">
  <h1><%out.print(barber.getEntreprise());%><small>Profil</small></h1>
</div>

</body>
</html>
