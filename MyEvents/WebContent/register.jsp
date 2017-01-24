<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 2 meta tags *must* come first in the head; any other head content must come *after* these tags -->
 	<!-- Bootstrap core CSS -->
    <link href="style/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="style/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="style/css/bootstrap-general-theme.css" rel="stylesheet">
<title>Neues Benutzerkonto erstellen</title>
</head>

    
    <body>
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
            <li class="active"><a href="/MyEvents/login.jsp">Startseite</a></li>
            <li><a href="#">Über uns</a></li>
            <li><a href="#">Impressum</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <div class="container theme-showcase" role="main"></br>
    <h1>Neuen Benutzeraccount erstellen</h1><br/>
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
    <form method="post" action="register">
        <label>Benutzername: <input type="text" name="username" /></label></br>
        <label>Passwort: <input type="password" name="password" /></label></br>
        <label>Name: <input type="text" name="name" /></label></br>
        <label>E-Mail: <input type="text" name="email" /></label></br>
        <label>Telefonnummer: <input type="text" name="phonenr" /></label></br>
        <input type="hidden" name="usertype" value="private" />
        <input type="hidden" name="formtype" value="publicform" />
        <br/>
        <label><input type="submit" value="Konto erstellen" /></label></br>
        <a style="color: #333333;" href="/MyEvents/login.jsp"><label><input type="button" value="Abbrechen" /></label></a>
        </form>
     </div>
  <div class="col-md-1"></div>
   <div class="col-md-6 bild-veranstaltung">
   <img src="bilder/newuser.png" width="256" height="256" />
   </div>
  </div>
       </div> 
        
       
      
    </div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="../js/bootstrap.min.js"></script>
    </body>

</html>


