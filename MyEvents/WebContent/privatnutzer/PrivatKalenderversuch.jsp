<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
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
			defaultDate: '2016-12-14',
			navLinks: true, // can click day/week names to navigate views
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			events: [
				{
					title: 'Präsentation Mathe',
					start: '2016-12-01'
				},
				{
					title: '2. Adventsonntag',
					start: '2016-12-04'
				},
				{
					title: 'Projektwochenende',
					start: '2016-12-09',
					end: '2016-12-11'
				},
				{
					id: 999,
					title: 'Wiederkehrend',
					start: '2016-12-09T16:00:00'
				},
				{
					title: '3. Adventsonntag',
					start: '2016-12-11'
				},
				{
					id: 999,
					title: 'Wiederkehrend',
					start: '2016-12-16T16:00:00'
				},
				{
					title: 'Konferenz',
					start: '2016-12-21',
					end: '2016-12-22'
				},
				{
					title: 'Meeting',
					start: '2016-12-12T10:30:00',
					end: '2016-12-12T12:30:00'
				},
				{
					title: 'Mittagessen',
					start: '2016-12-12T12:00:00'
				},
				{
					title: 'Meeting',
					start: '2016-12-12T14:30:00'
				},
				{
					title: 'Abgabe Informatik',
					start: '2016-12-12T17:30:00'
				},
				{
					title: 'Besprechung',
					start: '2016-12-12T20:00:00'
				},
				{
					title: 'Weihnachtsfeier',
					start: '2016-12-13T18:00:00'
				},
				{
					title: 'Star Wars',
					start: '2016-12-15'
				},
				{
					title: '4. Adventsonntag',
					start: '2016-12-18'
				},
				{
					title: 'Ferienbeginn',
					start: '2016-12-19'
				},
				{
					title: 'Hl. Abend',
					start: '2016-12-24'
				},
				{
					title: 'Weihnachten',
					start: '2016-12-25'
				},
				{
					title: 'Silvester',
					start: '2016-12-31'
				},
				{
					title: 'Neujahr',
					start: '2017-01-01'
				},
				{
					title: 'Hl. 3 Könige',
					start: '2017-01-06'
				}
			]
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
		max-width: 900px;
		margin: 0 auto;
	}

</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>
