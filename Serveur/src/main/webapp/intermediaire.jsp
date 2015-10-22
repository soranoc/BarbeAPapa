<html>
<head>
<meta charset=UTF-8>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="style.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script src="verification.js"></script>
<title>Barbu</title>
</head>
<body>
	<br>
	<br>
	<br>
	<img id="header" src="http://img15.hostingpics.net/pics/270845pinkmoustache.png" />

	<div class="row">
		<div>
			<form style="text-align: center" name="FormBConnexion"
				class="navbar-form" action="connexion.jsp" />
			<br><br>
			<input type="submit" id="buttonBB"
				class="btn btn-default btn-lg" value="Connexion"> <br>
			</form>
			<%if (request.getParameter("type").equals("Je suis un barbier")){%>
			<form style="text-align: center" name="FormBInscription"
				class="navbar-form" action="formulaireBarber.jsp" />
			<br>
			<input type="submit" id="buttonBB"
				class="btn btn-default btn-lg" value="Inscription"> <br>
			</form>
			<%}else if(request.getParameter("type").equals("Je suis un barbu")){%>
			<form style="text-align: center" name="FormBInscription"
				class="navbar-form" action="formulaireClient.jsp" />
			<br>
			<input type="submit" id="buttonBB"
				class="btn btn-default btn-lg" value="Inscription"> <br>
			</form>
			<%}%>
		</div>
	</div>
</body>
</html>
