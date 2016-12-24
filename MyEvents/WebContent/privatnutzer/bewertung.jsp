<html>
	<head>
	<title>Veranstaltung bewerten</title>
	 <link rel="stylesheet" type="text/css" href="/MyEvents/style/newevent.css">
	</head>
	
	<body>
	<div class ="form">
	<@page import = "Veranstaltung.class" %>
	
	<%String name=Veranstaltung.getName();
	String start =Veranstaltung.getStartTime();
	String end=Veranstaltung.getEndTime();
	String ort =Veranstaltung.getLocation();
	double rate= Veranstaltung.getAverageRating();
	String category=Veranstaltung.getCategory();
	%>
	
	<%=name%>
	<%=start%>
	<%=end%>
	<%=ort%>
	<%=rate%>
	<%=category%>
	
	<form action ="Bewertung" method="post">
	<label class="radio-inline">
	<input type = "radio" name="wertung" value="1"> 1
	</label>
	<label class="radio-inline">
	<input type = "radio" name="wertung" value="2"> 2
	</label>
	<label class="radio-inline">
	<input type = "radio" name="wertung" value="3"> 3
	</label>
	<label class="radio-inline">
	<input type = "radio" name="wertung" value="4"> 4
	</label>
	<label class="radio-inline">
	<input type = "radio" name="wertung" value="5"> 5
	</label>
	<input type = "submit" value="Bewerten">

	
	<div class="error"><b>${errorMessage}</b></div>
	</form>
	
	</div>
	</body>


</html>