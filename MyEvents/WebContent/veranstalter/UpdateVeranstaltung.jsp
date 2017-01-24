<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 2 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<title> Neue Veranstaltung erstellen </title>
	<!-- Bootstrap core CSS -->
    <link href="../style/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="../style/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../style/css/bootstrap-general-theme.css" rel="stylesheet">
    
<title>Veranstaltung bearbeiten</title>

</head>


<body>
    <!--  Formular fürs ausloggen -->
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
    <h1>Veranstaltung bearbeiten</h1></br>
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
    
    <div class="row">
    <div class="col-md-5 text-veranstaltung">
	<form action="UpdateVeranstaltung" method ="post">
	<input type="hidden" name="id" value="${id}">
	<label>Titel: <input type="text" name="name" id="name" value="${name}" value="${startdatum}" /></label></br>
    <label>Datum (von): <input type="text" name="startdatum" id="startdatum" value="${startdatum}" /></label></br>
    <label>Startzeit: <input type="text" name="starttime" id="starttime" value="${starttime}" /></label></br>
    <label>Datum (bis): <input type="text" name="enddatum" id="enddatum" value="${enddatum}" /></label></br>
    <label>Endzeit: <input type="text" name="endtime" id="endtime" value="${endtime}" /></label></br>
    <label>Ort: <input type="text" name="location" id="location" value="${location}" /></label></br>
    <label>Platzbeschränkung: <input type="text" name="plaetze" id="plaetze" value="${plaetze}" /></label></br>
    <label>Beschreibung: <input type="text" name="info" id="info" value="${info}" /></label></br>
    <label>Kategorie: 
    	<select name="kat" id="kat">
      		<option value="Fortbildungskurs" selected="selected">Fortbildungskurs&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
      		<option value="Sport">Sport</option>
      		<option value="Kochkurs">Kochkurs</option>
      		<option value="Andere Kategorie">Andere Kategorie</option>
    	</select>
  	</label></br>
  	</br>
	<label><input type="submit" value="Änderungen speichern"></label>
	</form>
	
	<a style="color: #333333;" href="/MyEvents/veranstalter/DeleteVeranstaltung?id=${id}"><label><input type="button" value="Löschen" /></label></a>
	</div>
   <div class="col-md-1"></div>
   <div class="col-md-6 bild-veranstaltung">
   <img src="../bilder/neue-veranstaltung.png" width="292" height="320" />
   </div>
   </div>
	</div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="../js/bootstrap.min.js"></script>
</body>

</html>