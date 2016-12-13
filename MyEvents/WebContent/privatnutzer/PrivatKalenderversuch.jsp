<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<title> Home Privat</title>
<link href='...' rel='stylesheet' /> /*../fullcalendar.min.css
<link href='../fullcalendar.print.min.css' rel='stylesheet' media='print' />
link href...dorthin geht der link
<script src='../lib/moment.min.js'></script>
<script src='../lib/jquery.min.js'></script>
<script src='../lib/jquery-ui.min.js'></script>
<script src='../fullcalendar.min.js'></script>
<script>


<!--initialize calender -->
$(document).ready(function() {
		
		$('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,basicWeek,basicDay'
			},
			defaultDate: '2016-12-12',
			navLinks: true, // can click day/week names to navigate views
			editable: true,
			});
		
	});
</script>


<style>

body {
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
	}
#calendar {
		float: right;
		width: 900px;
	}

</style>
</head>
<body>
	<div id='calendar'></div>
</body>
</html>
