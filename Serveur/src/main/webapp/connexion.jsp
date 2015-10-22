<html>
<head>
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
<title>BAP</title>
</head>
<body>
	<br>
	<br>
	<br>
	<img id="header" src="http://img15.hostingpics.net/pics/270845pinkmoustache.png">

	<div class="row">
		<div>
			<h2 style="text-align: center" class="navbar-form">Se connecter</h2>
			<form style="text-align: center" name="FormConnexion" class="navbar-form" action="servlet/Authen.java"/>
				<br><input type="text" class="form-control" name="pseudo" placeholder="Login" required>
				<br><br><input type="password" class="form-control" name="mot_de_passe" placeholder="Mot de passe" required>
				<br><br><input type="submit" class="btn btn-default btn-lg" value="Valider">
			</form>
		</div>
	</div>

</body>

</html>
