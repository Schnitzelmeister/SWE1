<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 2 meta tags *must* come first in the head; any other head content must come *after* these tags -->
 	<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
 	<!-- Bootstrap core CSS -->
    <link href="../style/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="../style/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../style/css/bootstrap-general-theme.css" rel="stylesheet">
	<title> Details der Veranstaltung </title>
	<jsp:include page="/MyEvents/privatnutzer/GetDetailsForPublicEvent/" />
</head>
<body>
    <!--  Formular f�rs ausloggen -->
    <form method="post" action="/MyEvents/logout" id="my_form">
    </form>
 	<!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">MyEvents</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="/MyEvents/veranstalter/vermain.jsp">Startseite</a></li>
            <li><a href="/MyEvents/veranstalter/NewVeranstaltung.jsp">Neue Veranstaltung</a></li>
            <li><a href="/MyEvents/veranstalter/veranstalterkalender.jsp">Eigener Kalender</a></li>
            <li><a href="/MyEvents/veranstalter/ChangeProfileVeranstalter.jsp">Profil bearbeiten</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <div class="container theme-showcase" role="main">
	<h1>Details zur Veranstaltung ${name}</h1></br>
	<b>Von:</b>  ${startTime} -  ${startDate} <br>
	<b>Bis:</b>  ${endTime} - ${endDate} <br>
	<b>Kategorie:</b> ${kategorie} <br>
	<b>Verf�gbare Pl�tze:</b> ${plaetze} <br>
	<b>Bewertungsdurchschnitt:</b> ${average} <br>
	<b>Beschreibung:</b> ${info} <br>
	<b>Ort:</b> ${location} <br><br>

	<a style="color: #333333;" href="/MyEvents/veranstalter/UpdateVeranstaltung.jsp?id=${id}"><label><input type="button" value="Bearbeiten" /></label></a>
	<form method="post" action="/MyEvents/DeleteVeranstaltung">
		<input type="hidden" name="id" value="${id}">
	    <label><input type="submit" value="Veranstaltung l�schen" /></label>
	</form>
 
</body>

</html>