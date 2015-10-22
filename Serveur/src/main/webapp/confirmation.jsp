<html>
<head>
<meta charset='utf-8'>

<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="style.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<br>
<br>
<br>
<title>Rendez-vous pris</title>
</head>

<% String barber = request.getParameter("barbier"); 
String mail = request.getParameter("mail");
String horaire = request.getParameter("horaire");
%>

<!--  Debut du corps de la page -->
<body>
	<div class='container'>
		<img id="header"
			src="http://img15.hostingpics.net/pics/270845pinkmoustache.png" /> <br>
		<h1 class='text-center'>Voulez vous confirmer le rendez-vous</h1>
		<br>
		<h2 class='text-center'>Chez <%out.println(barber);%>, à <%out.println(horaire);%> ?</h2>
		<br>
		<form id="fr">
			<input type="hidden" id="object" value="La Barbe à Papa Réservation">
			<input type="hidden" id="corps" value="Bonjour,
				Vous avez reçu une demande de rendez-vous à <%out.println(horaire);%>" size="50">
			<button id="boutonConf" class="btn btn-default" value="click">Confirmer</button>
		</form>
	</div>
</body>
</html>
<script type="text/javascript">
$(document).ready(function() {
    $('#boutonConf').click(function() {
        $('#fr').attr('action',
                       'mailto:angetheo@gmail.com?subject=Poulet&body=<pablo>yésouisdérétour';
        $('#fr').submit();
    });
});
</script>