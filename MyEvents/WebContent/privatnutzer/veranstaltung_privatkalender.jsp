<html>
 <head>
  <jsp:include page="/MyEvents/privatnutzer/GetDetailsForPublicEvent/" />
  <title>Details zur Veranstaltung: ${name}</title>
  </head>
   <body>
   <h1> Veranstaltung: ${name}  </h1>
<b>Von:</b>  ${startTime} -  ${startDate} <br>
<b>Bis:</b>  ${endTime} - ${endDate} <br>
<b>Kategorie:</b> ${kategorie} <br>
<b>Verfügbare Plätze:</b> ${plaetze} <br>
<b>Bewertungsdurchschnitt:</b> ${average} <br>
<b>Beschreibung:</b> ${info} <br>
<b>Ort:</b>   ${location} <br>
<br><br><br><br>
<form action ="/MyEvents/privatnutzer/AddRatingToEvent?id=${id}" method="post">
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
</form>
<input type="hidden" name="id" value="${id}">

<a href="/MyEvents/privatnutzer/DeleteVeranstaltungFromPrivCal?id=${id}">Ich möchte nicht mehr an der Veranstaltung teilnehmen</a>
<a href="/MyEvents/veranstalter/veranstalter_profil.jsp?veranstaltername=${veranstalterusername}">Profil von Veranstalter</a>

${errorMessage}
${infoMessage}
 
  </body>
</html>