<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
<HEAD>
<title>Datumsauswahl</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 2 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <!-- Bootstrap core CSS -->
  <link href="style/css/bootstrap.min.css" rel="stylesheet">
  <!-- Bootstrap theme -->
  <link href="style/css/bootstrap-theme.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="style/css/bootstrap-general-theme.css" rel="stylesheet">
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {

  $( "#DateFrom" ).datepicker({ dateFormat: "dd.mm.yy" });

  $( "#DateTo" ).datepicker({ dateFormat: "dd.mm.yy" });

  } );
  </script>
</HEAD>
<BODY>
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
            <li class="active"><a href="#">Startseite</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <div class="container theme-showcase" role="main">
      <form method="post">
        <input type="hidden" name="step" value="2" />
        <input type="hidden" name="report" value="reporting.VeranstaltungenStat" />
        <label>DateFrom: <input id="DateFrom" name="DateFrom" type="text"/></label></br>
        <label>DateTo: <input id="DateTo" name="DateTo" type="text"/></label></br>
        <label>IsDiagramm: 
	    	<select name="IsDiagramm">
	      		<option value="1" selected="selected">True</option>
	      		<option value="0">False</option>
	    	</select>
	  	</label></br>
        <input type="submit" value="Done"/>
      </form>
    </div>
    
  
  
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</BODY>
</HTML>
