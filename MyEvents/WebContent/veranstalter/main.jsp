<html>
<head>
<title>Hauptseite</title>
<!--<link rel="stylesheet" type="text/css" href="/MyEvents/style/privateuser_main.css">-->
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

		         location.href = "/MyEvents/veranstalter/detailsVeranstaltung.jsp?id="+calEvent.id;
				
		        $(this).css('border-color', 'red');

		    },
		    
			navLinks: true, // can click day/week names to navigate views
			editable: false,
			eventLimit: true, // allow "more" link when too many events
			events: "/MyEvents/LoadPublicEvents?kategorie=${kategorie}"	
		 });
	});

</script>
</head>
 <body>
    <h1>Willkommen auf der Hauptseite des Veranstalters</h1>
     
    <a href="/MyEvents/veranstalter/NewVeranstaltung.jsp"> Neue Veranstaltung </a>
    <a href="/MyEvents/veranstalter/veranstalterkalender.jsp"> Kalender </a>
   <!--<a href="/MyEvents/logout"> Abmelden </a>-->
 	
 	<form method="post" action="/MyEvents/logout">
    <input type="submit" value="Abmelden" />
    </form>
    
    
 </body>
</html>