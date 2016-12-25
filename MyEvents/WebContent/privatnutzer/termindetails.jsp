<html>
 <head>
   <title>Termin verwalten</title>
   <link rel="stylesheet" type="text/css" href="/MyEvents/style/newevent.css">
   <jsp:include page="/MyEvents/privatnutzer/GetTerminDataServlet/" />
  </head>
   <body>
   <h1>Ausgewählten privaten Termin bearbeiten</h1>
    <div class="topleft"><a href="../privatnutzer/privatkalendar.jsp">&lt;&lt; Zurück</a></div>
	<div class="form">
	 <form action="UpdateTermin" method="post">
	  <input type="hidden" name="id" value="${id}">
	  <label>Titel :</label> <input type="text" name="name" value="${name}" /> <br>
      <label>Datum (Von) :</label> <input type="text" name="startdatum" value="${startdatum}" /> <br>
      <label>Startzeit :</label> <input type="text" name="starttime" value="${starttime}" /> <br>
	  <label>Datum (Bis) :</label> <input type="text" name="enddatum" value="${enddatum}" /> <br>
	  <label>Endzeit :</label> <input type="text" name="endtime" value="${endtime}" /> <br>
	  <label>Ort :</label> <input type="text" name="location" value="${location}" /> <br>
      <label>Beschreibung :</label> <input type="text" name="info" value="${info}" /> <br>
      <input type="submit" value="Änderungen speichern" />

     <br><br><br><br><br><br> 
		
	<div class="error"><b>${errorMessage}</b></div>
   </form>		  
  </div>

    <div class="topleft">
     <a href="/MyEvents/privatnutzer/privatkalendar.jsp">&lt;&lt; Zurück</a>
    </div>

	<div class="button">
   <!--    <a href="/MyEvents/privatnutzer/eventdeletion.jsp?${id}">Termin aus Kalender entfernen</a> -->
      <a href="/MyEvents/privatnutzer/DeleteEventFromPrivate?id=${id}">Termin aus Kalender entfernen</a>
    </div>
    
 </body>
</html>