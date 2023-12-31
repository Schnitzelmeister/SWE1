<html>
<head>
  <jsp:include page="/MyEvents/privatnutzer/LoadInfoMainPage/" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 2 meta tags *must* come first in the head; any other head content must come *after* these tags -->
 	<!-- Bootstrap core CSS -->
    <link href="../style/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="../style/css/bootstrap-theme.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="../style/css/bootstrap-general-theme.css" rel="stylesheet">

 <title>Hauptseite des Privatbenutzers</title>
 	<meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
 	<link href='../fullcalendar/fullcalendar.min.css' rel='stylesheet' />
	<link href='../fullcalendar/fullcalendar.print.min.css' rel='stylesheet' media='print' />
	<script src='../fullcalendar/lib/moment.min.js'></script>
	<script src='../fullcalendar/lib/jquery.min.js'></script>
	<script src='../fullcalendar/fullcalendar.min.js'></script>
<script>

	$(document).ready(function() {
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today myCustomButton',
				center: 'title',
				right: 'month,agendaWeek,agendaDay,listWeek'
			},
			eventClick: function(calEvent, jsEvent, view) {

		         location.href = "/MyEvents/privatnutzer/veranstaltung_details.jsp?id="+calEvent.id;
				
		        $(this).css('border-color', 'red');

		    },
		    
			navLinks: true, // can click day/week names to navigate views
			editable: false,
			eventLimit: true, // allow "more" link when too many events
			events: "/MyEvents/LoadPublicEvents?kategorie=${kategorie}"	
		 });
	});

</script>

<style>
	#calendar {
		top: 5%;
		max-width: 1000px;
		margin: 0 auto;
		position: relative;
	}
</style>

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
            <li class="active"><a href="#">Startseite</a></li>
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
    
    <div class="container theme-showcase" role="main">
    <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>Willkommen!</h1>
      </div>
      <h1>�ffentlicher Kalender</h1></br>

    <div id='calendar'></div>
     
     Veranstaltungen nach bestimmter Kategorie anzeigen:
     <form action="/MyEvents/privatnutzer/main.jsp" method="get">
      <label for="kategorie"> Kategorie:
	   <select name="kategorie">
	    	<option>Alle Kategorien</option>
			<option>Fortbildungskurs</option>
			<option>Sport</option>
			<option>Kochkurs</option>
			<option>Andere Kategorie</option>
	   </select>
	   <input type="submit" value="Filtern">
	   </label>
	   </form>
	 </div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <script src="../js/bootstrap.min.js"></script>
 </body>
</html>