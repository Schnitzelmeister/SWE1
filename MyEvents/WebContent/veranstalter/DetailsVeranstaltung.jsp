<html>
<head>
	<title> Details der Veranstaltung </title>
</head>
<body>
	<b>Von:</b>  ${startTime} -  ${startDate} <br>
	<b>Bis:</b>  ${endTime} - ${endDate} <br>
	<b>Kategorie:</b> ${kategorie} <br>
	<b>Verf�gbare Pl�tze:</b> ${plaetze} <br>
	<b>Bewertungsdurchschnitt:</b> ${average} <br>
	<b>Beschreibung:</b> ${info} <br>
	<b>Ort:</b>   ${location} <br>


<	input type="hidden" name="id" value="${id}">

	<a href="MyEvents/veranstalter/UpdateVeranstaltung.jsp?id=${id}"> Bearbeiten</a>
	<form method="post" action="/MyEvents/DeleteVeranstaltung">
	    <input type="submit" value="Veranstaltung l�schen" />
	    </form>
 
	<a href="MyEvents/veranstalter/vermain.jsp"> Hauptseite</a>
</body>

</html>