<html xmlns="http://www.w3.org/1999/xhtml">
<head> 
	<title> Neue Veranstaltung erstellen </title>
	<link rel="stylesheet" type="text/css" href="/MyEvents/style/newevent.css">
</head>
  <body>
   <form action="NewVeranstaltung" method="post">
	<label>Titel :</label> <input type="text" name="name"></br>
	<label>Datum (Von):</label> <input type="text" name="startdatum"></br>
	<label>Startzeit :</label> <input type="text" name="starttime"></br>
	<label>Datum (Bis):</label> <input type="text" name="enddatum"></br>
	<label>Endzeit :</label> <input type="text" name="endtime"></br>
	<label>Ort :</label> <input type="text" name="location"></br>
	<label>Platzbeschränkung :</label> <input type = "text" name="availablePlaces"></br>
	<label>Beschreibung :</label> <input type="text" name="info"></br>
	 <p>
	 <label>
	  <label for="kat"> Kategorie: </label>
	   <select name="kat">
			<option> Fortbildungskurs </option>
			<option> Sport </option>
			<option> Kochkurs </option>
			<option> Andere Kategorie </option>
	   </select>
	   </label>>
	 </p>
	<label><input type="submit" value="Erstellen"></label>
	
	<br> <br> <br> <br> <br> <br> 

	<div class="error"><b>${errorMessage}</b></div>
	<div class="info"><b>${infoMessage}</b></div>
	
  </form>
 </body>
</html>