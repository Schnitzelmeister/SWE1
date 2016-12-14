<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head> <title> Neuen Termin erstellen </title>
</head>

<body>

<form action="NewTermin" method="post">
<!--Titel-->
Titel: <input type="text" name="name"></br>
<!--Datum-->
Datum: <input type="text" name="datum"></br>
<!--Startzeit-->
Startzeit: <input type="text" name="starttime"></br>
<!--Endzeit-->
Endzeit: <input type="text" name="endtime"></br>
<!--Ort-->
Ort: <br> <input type="text" name="location"></br>
<!--Beschreibung-->
Beschreibung <br> <input type="text" name="info"></br>

<input type="submit" value="Erstellen">
</form>
</body>

</html>