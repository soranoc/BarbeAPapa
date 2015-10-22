<%@ page import="java.util.Map"%>
<%@ page import="org.Serveur.ServletHelper"%>

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

<title>Formulaire</title>
</head>

<%
	Map<String, String[]> params = request.getParameterMap();	
%>

<body>
	<div class="container">
		<div class='page-header col-sm-offset-1'>
			<h1>Formulaire Inscription <small>Je suis un barbu</small></h1>
		</div>
		<form method='post' action='Formulaire2' enctype='multipart/form-data' action='fup.cgi'>

			<div class='row'>
				<div class='col-md-3 col-sm-offset-1'>
					<div class='form-group'>
						<label for='nom'>Nom (*) : </label> <input type='text'
							class='form-control'
							value="<%out.println(ServletHelper.getValue("nom", params));%>"
							name='nom' required>
					</div>
				</div>

				<div class='col-md-3'>
					<div class='form-group'>
						<label for='prenom'>Prénom (*) : </label> <input type='text'
							class='form-control'
							value="<%out.println(ServletHelper.getValue("prenom", params));%>"
							name='prenom' required>
					</div>
				</div>

				<div class='col-md-2'>
					<div
						class='form-group <%out.println(request.getAttribute("warning"));%>'>
						<label for='date'>Date de Naissance (*) : </label> <input
							type='date' class='form-control'
							value="<%out.println(ServletHelper.getValue("date", params));%>"
							name='date' required>
					</div>
				</div>
			</div>

			<div class='row'>

				<div class='col-md-4 col-sm-offset-1'>
					<div
						class='form-group <%out.println(request.getAttribute("warning"));%>'>
						<label for='nom'>Photo (*) : </label><input type='hidden'
							name='MAX_FILE_SIZE' value='1048576' /><input type='file'
							value='' name='photo' required class='form-control'>
					</div>
				</div>

				<div class='col-md-4'>
					<br>Les photos doivent respecter le format X par Y, et peser 1
					Mo maximum.
				</div>
			</div>

			
			<div class='row'>
				<div class='col-md-8 col-sm-offset-1'>
					<div class='form-group'>
						<label for='adresse'>Adresse(*) : </label> <input type='text'
							class='form-control'
							value="<%out.println(ServletHelper.getValue("adresse", params));%>"
							name='adresse' required>
					</div>
				</div>
			</div>

			<div class='row'>
				<div class='col-md-4 col-sm-offset-1'>
					<div class='form-group'>
						<label for='codep'>Code Postal (*) : </label> <input type='text'
							class='form-control' id='cp'
							value="<%out.println(ServletHelper.getValue("codePostal", params));%>"
							name='codePostal' required>
					</div>
				</div>

				<div class='col-md-4'>
					<div class='form-group'>
						<label for='ville'>Ville (*) : </label> <select
							class='form-control' id='ville' name='ville' required>
							<option value="<%out.println(ServletHelper.getValue("ville", params));%>">
							<%out.println(ServletHelper.getValue("ville", params));%></option>
						</select>
					</div>
				</div>
			</div>

			<div class='row'>
				<div class='col-md-4 col-sm-offset-1'>
					<div class='form-group'>
						<label for='mail'>E-Mail (*) : </label> <input type='email'
							class='form-control' placeholder='thierry.dupont@gmail.com'
							value="<%out.println(ServletHelper.getValue("mail", params));%>"
							name='mail' required>
					</div>
				</div>

				<div class='col-md-4'>
					<div
						class='form-group <%out.println(request.getAttribute("emailconf"));%>'>
						<label for='mail2'>Confirmer E-Mail (*) : </label> <input
							type='email' class='form-control'
							placeholder='thierry.dupont@gmail.com'
							value="<%out.println(ServletHelper.getValue("mail2", params));%>"
							name='mail2' required>
					</div>
				</div>
			</div>

			<div class='row'>
				<div class='col-md-4 col-sm-offset-1'>
					<div class='form-group'>
						<label for='tel'>Téléphone (*) : </label> <input type='text'
							class='form-control' placeholder='0670000000'
							value="<%out.println(ServletHelper.getValue("tel", params));%>"
							name='tel' required>
					</div>
				</div>			
			</div>			
			
			<div class='row'>
				<div class='col-md-4 col-sm-offset-1'>
					<div class='form-group'>
						<label for='password'>Mot de passe (*) : </label> <input
							type='password' class='form-control'
							value="<%out.println(ServletHelper.getValue("mdp", params));%>"
							name='mdp' required>
					</div>
				</div>

				<div class='col-md-4'>
					<div
						class='form-group <%out.println(request.getAttribute("passwdconf"));%>'>
						<label for='password2'>Confirmer Mot de passe (*) : </label> <input
							type='password' class='form-control'
							value="<%out.println(ServletHelper.getValue("mdp2", params));%>"
							name='mdp2' required>
					</div>
				</div>
			</div>

			<div class='form-group col-sm-offset-1'>
				<label>(*) : Champs requis</label>
			</div>

			<div class='form-group col-sm-offset-8'>
				<button type='submit' class='btn btn-success btn-lg'>Valider</button>

			</div>
		</form>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#cp").change(function() {
				getVilles($('#cp').val())
			});
		});
		function getVilles(cp) {
			$.getJSON("v2/cpdb/" + cp, function(data) {
				var html = "";
				for ( var index = 0; index < data.length; ++index) {
					html = html + "<option value='"+data[index].ville+"'>" + data[index].ville + "</option>";
				}
				$("#ville").html(html);
			})
		}
	</script>
</body>
