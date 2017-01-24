<html>
 <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 2 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<title>Privatkalender</title>
 	<!-- Bootstrap core CSS -->
    <link href="../style/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="../style/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../style/css/bootstrap-general-theme.css" rel="stylesheet">
  <jsp:include page="/MyEvents/privatnutzer/GetDetailsForPublicEvent/" />
  <title>Details zur Veranstaltung: ${name}</title>
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
            <li class="active"><a href="/MyEvents/privatnutzer/main.jsp">Startseite</a></li>
            <li><a href="/MyEvents/privatnutzer/privatkalendar.jsp">Privatkalender</a></li>
            <li><a href="/MyEvents/privatnutzer/newtermin.jsp">Privaten Termin erstellen</a></li>
            <li><a href="/MyEvents/privatnutzer/manage_profile.jsp">Profil bearbeiten</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
	<div class="container theme-showcase" role="main"></br>
   <h1> Veranstaltung: ${name}  </h1></br>
<b>Von:</b>  ${startTime} -  ${startDate} <br>
<b>Bis:</b>  ${endTime} - ${endDate} <br>
<b>Kategorie:</b> ${kategorie} <br>
<b>Verf�gbare Pl�tze:</b> ${plaetze} <br>
<b>Bewertungsdurchschnitt:</b> ${average} <br>
<b>Beschreibung:</b> ${info} <br>
<b>Ort:</b>   ${location} <br>
</br>
<a style="color: #333333;" href="/MyEvents/privatnutzer/AddVeranstaltungToPrivateCal?id=${id}"><label><input type="button" value="An Veranstaltung teilnehmen" /></label></a>
<br><br>
    <%
    if(!(request.getAttribute("errorMessage")==null)) {
    %>
    <div class="alert alert-danger" role="alert">
    <strong>${errorMessage}</strong>
    </div></br>
    <%        	
    }
    %>
    <%
    if(!(request.getAttribute("infoMessage")==null)) {
    %>
    <div class="alert alert-success" role="alert">
    <strong>${infoMessage}</strong>
    </div></br>
    <%        	
    }
    %>
    </div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="../js/bootstrap.min.js"></script>
  </body>
</html>