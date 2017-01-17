<html>
<head>
 <jsp:include page="/MyEvents/privatnutzer/LoadInfoMessage/" />
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
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay,listWeek'
			},
			eventClick: function(calEvent, jsEvent, view) {
				if(calEvent.type="public"){
				location.href = "MyEvents/veranstalter/DetailsVeranstaltung.jsp?id"+calEvent.id;
			}
			else{}
		        $(this).css('border-color', 'red');

		    },
		    
			navLinks: true, // can click day/week names to navigate views
			editable: false,
			eventLimit: true, // allow "more" link when too many events
			events: "/MyEvents/FetchEventsVeranstaltung"
			
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

.topleft{
  font: bold 15px Verdana;
  text-decoration: none;
  color: #333333;
  position:absolute;
  text-decoration: none;
  top: 7px;
  left: 5px;
}
		
.info{
	text-color: #D8000C;
    background-color: #7CFC00;
    font-family: Verdana;
    text-align: center;
    position: relative;
}	

.error{
	text-color: #D8000C;
    background-color: #FFBABA;
    font-family: Verdana;
    text-align: center;
    position: relative;
}														
</style>
</head>
<body>

	<div class="topleft">
     <a href="/MyEvents/veranstalter/vermain.jsp">&lt;&lt; Zurück</a>
     <a href="/MyEvents/veranstalter/ChangeProfileVeranstalter.jsp">&lt; &lt; Profil bearbeiten</a>
    </div>

	<div id='calendar'></div>
	<div class="info">${infoMessage}</div>
	<div class="error">${errorMessage}</div>
	
	
</body>
</html>

