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


<input type="hidden" name="id" value="${id}">

<a href="/MyEvents/privatnutzer/AddVeranstaltungToPrivateCal?id=${id}">An Veranstaltung teilnehmen</a>
<a href="/MyEvents/veranstalter/veranstalter_profil.jsp?veranstaltername=${veranstalterusername}">Profil von Veranstalter</a>

${errorMessage}
${infoMessage}
  </body>
</html>