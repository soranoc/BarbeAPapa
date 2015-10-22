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
			<h1>
				Formulaire Inscription <small>Je suis un barbier</small>      
				<img id="moustache" src="http://img4.hostingpics.net/pics/366706moustache.png"></h1>
			</h1>
		</div>
		<form method='post' action='ServletRegisterBarber'
			enctype='multipart/form-data' action='fup.cgi'>

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
						<label for='nom'>Photo (*) : </label><input type='url'
							value='' name='photo' placeholder='http://ma-photo.jpg' required
							class='form-control'>
					</div>
				</div>
			</div>

			<div class='row'>
				<div class='col-md-4 col-sm-offset-1'>
					<div class='form-group'>
						<label for='entreprise'>Entreprise (*) : </label> <input
							type='text' class='form-control'
							value="<%out.println(ServletHelper.getValue("entreprise", params));%>"
							name='entreprise' required>
					</div>
				</div>


				<div class='col-md-4'>
					<div class='form-group'>
						<label for='site'>Site Internet de l'Entreprise : </label> <input
							type='url' class='form-control'
							value="<%out.println(ServletHelper.getValue("site", params));%>"
							name='site' placeholder='http://www.mon-site.fr'>
					</div>
				</div>
			</div>

			<div class='row'>
				<div class='col-md-8 col-sm-offset-1'>
					<div class='form-group'>
						<label for='adresse'>Adresse de l'Entreprise(*) : </label> <input
							type='text' class='form-control'
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
							value="<%out.println(ServletHelper.getValue("codep", params));%>"
							name='codep' required>
					</div>
				</div>

				<div class='col-md-4'>
					<div class='form-group'>
						<label for='ville'>Ville (*) : </label> <select
							class='form-control' id='ville' name='ville' required>
							<option
								value="<%out.println(ServletHelper.getValue("ville", params));%>">
								<%out.println(ServletHelper.getValue("ville", params));%>
							</option>
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
						<label for='mail2'>Confirmer E-Mail (*) : </label><input
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

				<div class='col-md-4'>
					<div class='form-group'>
						<label for='fax'>Fax : </label> <input type='text'
							class='form-control'
							value="<%out.println(ServletHelper.getValue("fax", params));%>"
							name='fax'>
					</div>
				</div>
			</div>

			<div class='row'>
				<div class='col-md-8 col-sm-offset-1'>
					<div class='form-group'>
						<label for='profession'>Type de prestation (*) : </label>
						<div class="radio">
							<label> <input type="radio" name="prestation"
								id="optionsRadios1" value="Barbier" checked> Barbier
							</label>
						</div>
						<div class="radio">
							<label> <input type="radio" name="prestation"
								id="optionsRadios2" value="Coiffeur"> Coiffeur
							</label>
						</div>
						<div class="radio disabled">
							<label> <input type="radio" name="prestation"
								id="optionsRadios3" value="Barbier-Coiffeur"> Barbier-Coiffeur
							</label>
						</div>
					</div>
				</div>
			</div>

			<div class='row'>

				<div class='col-md-8 col-sm-offset-1'>
					<div class='form-group'>
						<label for='description'>Description : </label>
						<textarea name='description' id='description' rows=5
							class='form-control' placeholder='Décrivez votre activité en quelques mots'>
							<%out.print(params.get("description") != null ? params.get("description")[0] +"" : "");%>
						</textarea>
					</div>
				</div>
			</div>


			<div class='row'>
				<div class='col-md-4 col-sm-offset-1'>
					<div class='form-group'>
						<label for='facebook'>Facebook : </label> <input type='text'
							class='form-control' placeholder='http://monfacebook.fr/'
							value="<%out.println(ServletHelper.getValue("facebook", params));%>"
							name='facebook'>
					</div>
				</div>

				<div class='col-md-4'>
					<div class='form-group'>
						<label for='twitter'>Twitter : </label> <input type='text'
							class='form-control' placeholder='http://montwitter.fr/'
							value="<%out.println(ServletHelper.getValue("twitter", params));%>"
							name='twitter'>
					</div>
				</div>
			</div>

			<div class='row'>
				<div class='col-md-4 col-sm-offset-1'>
					<div class='form-group'>
						<label for='linkedin'>LinkedIn : </label> <input type='text'
							class='form-control' placeholder='http://monlinkedin.fr/'
							value="<%out.println(ServletHelper.getValue("linkedin", params));%>"
							name='linkedin'>
					</div>
				</div>

				<div class='col-md-4'>
					<div class='form-group'>
						<label for='google'>Google+ : </label> <input type='text'
							class='form-control' placeholder='http://mongoogleplus.fr/'
							value="<%out.println(ServletHelper.getValue("google", params));%>"
							name='google'>
					</div>
				</div>
			</div>

			<div class='row'>
				<div class='col-md-4 col-sm-offset-1'>
					<div class='form-group'>
						<label for='password'>Mot de passe (*) : </label> <input
							type='password' class='form-control'
							value="<%out.println(ServletHelper.getValue("password", params));%>"
							name='password' required>
					</div>
				</div>

				<div class='col-md-4'>
					<div
						class='form-group <%out.println(request.getAttribute("passwdconf"));%>'>
						<label for='password2'>Confirmer Mot de passe (*) : </label> <input
							type='password' class='form-control'
							value="<%out.println(ServletHelper.getValue("password2", params));%>"
							name='password2' required>
					</div>
				</div>
			</div>

			<div class='form-group col-sm-offset-1'>
				<label>(*) : Champs requis</label>
			</div>
			<div class='form-group col-sm-offset-8'>
				<button type='submit' id='validation' class='btn btn-success btn-lg'>Valider</button>
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
					html = html + "<option value='"+data[index].ville+"'>"
							+ data[index].ville + "</option>";
				}
				$("#ville").html(html);
			})
		}
	</script>
</body>