<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Hauptseite</title>
</head>


    <body>
    <b>Willkommen auf der Hauptseite des Veranstalters</b>
     <!--<a href "NewVeranstaltung.jsp"> <input type ="button" value="Termin erstellen"/></a>-->
    </body>
    
    <form method="post" action="/MyEvents/veranstalter/NewVeranstaltung.jsp">
    <input type="submit" value="Neue Veranstaltung"/>
    </form>
 	<form method="post" action="/MyEvents/logout">
    <input type="submit" value="Abmelden" />
    </form>
</html>