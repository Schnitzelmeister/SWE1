<html>
<head>
<title>Veranstaltung bearbeiten</title>

</head>


<body>
	<form action="UpdateVeranstaltung" method ="post">
	<input type="hidden" name="id" value="${id}">
	<label>Titel :</label> <input type="text" name="name" value="${name}" /> <br>
      <label>Startdatum :</label> <input type="text" name="startdatum" value="${startdatum}" /> <br>
      <label>Startzeit :</label> <input type="text" name="starttime" value="${starttime}" /> <br>
	  <label>Enddatum :</label> <input type="text" name="enddatum" value="${enddatum}" /> <br>
	  <label>Endzeit :</label> <input type="text" name="endtime" value="${endtime}" /> <br>
	  <label>Ort :</label> <input type="text" name="location" value="${location}" /> <br>
	  <label>Platzanzahl:</label> <input type ="text" name="plaetze" value="${plaetze}"/><br>
      <label>Beschreibung :</label> <input type="text" name="info" value="${info}" /> <br>
	<p>
	<label>Kategorie:
		<select name= "category">
		<option> Fortbildungskurs </option>
		<option> Sport </option>
		<option> Kochkurs </option>
		<option> Andere Kategorie </option>
		</select>
	</label>
	<input type="submit" value="Änderungen speichern" />
	</form>
	
	
	<div> class="button">
	<a href="/MyEvents/veranstalter/DeleteVeranstaltung?id=${id}"> Löschen</a>
	</div>
	
	<div class="button">
	<a href="MyEvents/veranstalter/main.jsp"> Zurück</a>
	</div>
	
	<!--Veranstaltung löschen-->
	
</body>

</html>