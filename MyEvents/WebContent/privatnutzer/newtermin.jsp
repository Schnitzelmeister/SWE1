<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head> <title> Neuen Termin erstellen </title>
</head>

<body>

<form action="NewTermin" method="post">
<!--Titel-->
Titel: <br> <input type="text" name="name">
<!--Datum-->
<input type="date" name="datum">
<!--Startzeit-->
Startzeit: <input type="time" name="starttime">
<!--Endzeit-->
Endzeit: <input type="time" name="endtime">
<!--Ort-->
Ort: <br> <input type="text" name="location">
<!--Beschreibung-->
Beschreibung <br> <input type="text" name="info">

<input type="submit" value="Erstellen">
</form>
</body>

</html>