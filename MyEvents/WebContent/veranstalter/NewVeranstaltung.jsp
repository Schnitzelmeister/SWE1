<html xmlns="http://www.w3.org/1999/xhtml">
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
    
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>

	$( function() {
	$( "#startdatum" ).datepicker({ dateFormat: "dd.mm.yy" });
	$( "#enddatum" ).datepicker({ dateFormat: "dd.mm.yy" });
	}
	);

	</script>
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
            <li><a href="/MyEvents/veranstalter/vermain.jsp">Startseite</a></li>
            <li class="active"><a href="#">Neue Veranstaltung</a></li>
            <li><a href="/MyEvents/veranstalter/veranstalterkalender.jsp">Kalender</a></li>
            <li><a href="/MyEvents/veranstalter/ChangeProfileVeranstalter.jsp">Profil bearbeiten</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Action</a></li>
                  <li><a href="#">Another action</a></li>
                  <li><a href="#">Something else here</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Nav header</li>
                  <li><a href="#">Separated link</a></li>
                  <li><a href="#">One more separated link</a></li>
                </ul>
              </li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <div class="container theme-showcase" role="main">
    
    <h1>Neue Veranstaltung</h1></br>
    <p>Bitte gib folgende Daten an, um eine Veranstaltung zu erstellen:</p></br>
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
   <form action="CreateNewVeranstaltungServlet" method="post">
    <label>Titel: <input type="text" name="name" id="name" /></label></br>
    <label>Datum (von): <input type="text" name="startdatum" id="startdatum" /></label></br>
    <label>Startzeit: <input type="text" name="starttime" id="starttime" value="08:00"/></label></br>
    <label>Datum (bis): <input type="text" name="enddatum" id="enddatum" /></label></br>
    <label>Endzeit: <input type="text" name="endtime" id="endtime" value="09:00"/></label></br>
    <label>Ort: <input type="text" name="location" id="location" /></label></br>
    <label>Platzbeschränkung: <input type="text" name="availablePlaces" id="availablePlaces" /></label></br>
    <label>Beschreibung: <input type="text" name="info" id="info" /></label></br>
    <label>Kategorie: 
    	<select name="kat" id="kat">
      		<option value="Fortbildungskurs" selected="selected">Fortbildungskurs&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
      		<option value="Sport">Sport</option>
      		<option value="Kochkurs">Kochkurs</option>
      		<option value="Andere Kategorie">Andere Kategorie</option>
    	</select>
  	</label></br>
  	</br>
	<label><input type="submit" value="Erstellen"></label>
   </form>
   </div>
   <div class="col-md-1"></div>
   <div class="col-md-6 bild-veranstaltung">
   <img src="../bilder/neue-veranstaltung.png" width="292" height="320" />
   </div>
   </div>
    
    </div>
    
 </body>
</html>