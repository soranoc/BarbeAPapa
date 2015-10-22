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
<link rel="stylesheet" href="style.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<title>Barbe a Papa</title>
</head>

<%
	BDD bdd = new BDD();
	List<Barber> barbers = bdd.getBarbers();
%>

<body>

	<br>
	<div class="container">
	<div class='page-header'>
	<img id="header" src="http://img15.hostingpics.net/pics/270845pinkmoustache.png" />
        <div class = "row">

        <form class="navbar-form navbar" role="search">
            <h1>Planifiez votre rendez-vous 
            <div class="form-group">
            <input type="text" class="col-sm-2 push-col-md-1 form-control" placeholder="Ville">
        </div>
                <button type="submit" class="btn btn-default">Rechercher</button>   
            </h1>     

        </form>
        </div>
    </div>
    </div>
    <div class='container'>
	<div class="row">
	<%for(int i=0; i<3 && i<barbers.size(); ++i){%>
				<div class="col-sm-6 col-md-4">
					<div id="thumbnailBarbier" class="thumbnail">
					<form action='ServletRDV' method='post'>
						<img id="thumbBarber" src="<%out.println(barbers.get(i).getPhoto());%>" class="img-responsive">
						<input type="hidden" name="barbier" value="<%out.print(barbers.get(i).getEntreprise());%>">
						<input type="hidden" name="mail" value="<%out.print(barbers.get(i).getMail());%>">
						<div class="caption">
							<h3><%out.println(barbers.get(i).getEntreprise()); %></h3>
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
    </div>
</body>