<html>
    <head>
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
 	    <meta name="viewport" content="width=device-width, initial-scale=1">
  	    <!-- The above 2 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>MyEvents Login</title>
        <!-- Bootstrap core CSS -->
    	<link href="style/css/bootstrap.min.css" rel="stylesheet">
   		<!-- Bootstrap theme -->
   		<link href="style/css/bootstrap-theme.min.css" rel="stylesheet">
   		<!-- Custom styles for this template -->
        <link href="style/css/login.css" rel="stylesheet">
        <link href="style/css/bootstrap-general-theme.css" rel="stylesheet">
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
            <li class="active"><a href="#">Startseite</a></li>
            <li><a href="#">Über uns</a></li>
            <li><a href="#">Impressum</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <div class="container">
    	<p>&nbsp;</p>
    	<h1 class="text-center">Willkommen bei MyEvents!</h1>
        <form method="post" action="/MyEvents/LoginServlet" class="form-signin">
        <label for="username" class="sr-only">Benutzername</label>
        <input type="text" id="username" name="username" class="form-control" placeholder="Benutzername" required autofocus>
        <label for="password" class="sr-only">Passwort</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="Passwort" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Anmelden</button>
        </form>
        <%
        if(!(request.getAttribute("errorMessage")==null)) {
        %>
        <div class="alert alert-danger" role="alert">
        <strong>${errorMessage}</strong>
        </div>
        <%        	
        }
        %>
        <%
        if(!(request.getAttribute("infoMessage")==null)) {
        %>
        <div class="alert alert-success" role="alert">
        <strong>${infoMessage}</strong>
        </div>
        <%        	
        }
        %>
        <p class="register"><a href="/MyEvents/register.jsp">Neues Benutzerkonto erstellen</a></p>
     </div>
     
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    
    </body>
</html>