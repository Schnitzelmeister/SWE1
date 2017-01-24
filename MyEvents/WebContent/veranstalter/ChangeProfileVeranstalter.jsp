<html>
	<head>
	<title>Profildaten verwalten</title>
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
    
	<jsp:include page="/MyEvents/veranstalter/LoadVeranstalterData/" />	
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
            <li><a href="/MyEvents/veranstalter/NewVeranstaltung.jsp">Neue Veranstaltung</a></li>
            <li><a href="/MyEvents/veranstalter/veranstalterkalender.jsp">Eigener Kalender</a></li>
            <li class="active"><a href="#">Profil bearbeiten</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <div class="container theme-showcase" role="main">
	<h1>Daten für Veranstalter ${veranstaltername} ändern</h1></br>
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
	<form method="post" action="/MyEvents/veranstalter/SaveVeranstalterData">
	  <label>Name: <input type="text" name="name" value="${name}" /></label></br>
      <label>Passwort: <input type="password" name="password" value="${password}" /></label></br>
      <label>E-Mail: <input type="text" name="email" value="${email}"/></label></br>
      <label>Telefonnummer: <input type="text" name="telnr" value="${telnr}" /></label></br>

  	  </br>
	  <label><input type="submit" value="Änderungen speichern"></label>
   </form>
   
   </div>
   
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="../js/bootstrap.min.js"></script>
</body>

</html>