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
   <title>Termin verwalten</title>
   <jsp:include page="/MyEvents/privatnutzer/GetTerminDataServlet/" />
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
            <li><a href="/MyEvents/privatnutzer/main.jsp">Startseite</a></li>
            <li class="active"><a href="/MyEvents/privatnutzer/privatkalendar.jsp">Privatkalender</a></li>
            <li><a href="/MyEvents/privatnutzer/newtermin.jsp">Privaten Termin erstellen</a></li>
            <li><a href="/MyEvents/privatnutzer/manage_profile.jsp">Profil bearbeiten</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
	<div class="container theme-showcase" role="main">
   <h1>Ausgewählten privaten Termin bearbeiten</h1></br>
   <%
    if(!(request.getAttribute("errorMessage")==null)) {
    %>
    <div class="alert alert-danger" role="alert">
    <strong>${errorMessage}</strong>
    </div></br>
    <%        	
    }
    %>
    
    <div class="row">
    <div class="col-md-5 text-veranstaltung">
	<form action="UpdateTermin" method="post">
	  <input type="hidden" name="id" value="${id}">
	  <label>Titel: <input type="text" name="name" id="name" value="${name}" /></label></br>
      <label>Datum (von): <input type="text" name="startdatum" id="startdatum" value="${startdatum}" /></label></br>
      <label>Startzeit: <input type="text" name="starttime" id="starttime" value="${starttime}" /></label></br>
      <label>Datum (bis): <input type="text" name="enddatum" id="enddatum" value="${enddatum}" /></label></br>
      <label>Endzeit: <input type="text" name="endtime" id="endtime" value="${endtime}" /></label></br>
      <label>Ort: <input type="text" name="location" id="location" value="${location}" /></label></br>
      <label>Beschreibung: <input type="text" name="info" id="info" value="${info}" /></label></br>
   	  </br>
	  <label><input type="submit" value="Änderungen speichern"></label></br>
	  <a style="color: #333333;" href="/MyEvents/privatnutzer/DeleteEventFromPrivate?id=${id}"><label><input type="button" value="Termin aus Kalender entfernen" /></label></a>
   </form>
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