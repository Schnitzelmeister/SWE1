<html>
<head> 
	<title> Neuen Termin erstellen </title>
	<link rel="stylesheet" type="text/css" href="/MyEvents/style/newevent.css">
</head>

 <body>
  <div class="form">
  <br> <br> <br> 
  <form action="NewTermin" method="post">
  
	<label>Titel :</label> <input type="text" name="name" /> </br>
	<label>Datum (Von) :</label> <input type="text" name="startdatum" /> </br>
	<label>Startzeit :</label> <input type="text" name="starttime" /> </br>
	<label>Datum (Bis) :</label> <input type="text" name="enddatum" /> </br>
	<label>Endzeit :</label> <input type="text" name="endtime" /> </br>
	<label>Ort :</label> <input type="text" name="location" /> </br>
	<label>Beschreibung :</label> <input type="text" name="info" /> </br>
    <input type="submit" value="Erstellen" />

    <br> <br> <br> <br> <br> <br> 

	<div class="error"><b>${errorMessage}</b></div>
	<div class="info"><b>${infoMessage}</b></div>
	
     
  </form>
  </div>
 </body>
</html>