<html>
<head>
  <jsp:include page="/MyEvents/privatnutzer/LoadInfoMainPage/" />
<!-- Versuch bzw Probe, den allgemeinen öffentlichen Kalender funktionsfähig zu machen. -->
 <title>Hauptseite des Veranstalters</title>
 	 <link rel="stylesheet" type="text/css" href="/MyEvents/style/privateuser_main.css">
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

		         location.href = "/MyEvents/veranstalter/DetailsVeranstaltung.jsp?id="+calEvent.id;
				
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

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		top: 5%;
		max-width: 1000px;
		margin: 0 auto;
		position: relative;
	}
</style>

</head>
<body>
     
    
    
       	<div id='calendar'></div>
     
     Veranstaltungen nach bestimmter Kategorie anzeigen:
     <form action="/MyEvents/veranstalter/vermain.jsp" method="get">
      <label for="kategorie"> Kategorie: </label>
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
 </body>
</html>