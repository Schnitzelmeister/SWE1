<html>
	<head>
	<title> Profildaten verwalten </title>
	 <link rel="stylesheet" type="text/css" href="/MyEvents/style/register.css">
	<jsp:include page="/MyEvents/veranstalter/LoadVeranstalterData/" />	
	</head>
	
	<body>
	<h1> Daten f�r Veranstalter ${veranstaltername} �ndern </h1>
	<form method="post" action="/MyEvents/veranstalter/SaveVeranstalterData">
     
         <label>Name         :</label><input type="text" name="name" value="${name}" /><br/><br/>
         <label>Password     :</label><input type="password" name="password" value="${password}" /><br/><br/>
        <label>E-Mail       :</label><input type="text" name="email" value="${email}" /><br/><br/>
        <label>Telefonnummer:</label><input type="text" name="Phonenumber" value="${telnr}" /><br/><br/>
        <input type="submit" value="�nderungen speichern" />
   		<div class="error">${errorMessage}</div>     
   		<div class="info">${infoMessage}</div>     		
   		
   </form>
   
   <a href="/MyEvents/veranstalter/vermain.jsp"> Zur�ck</a>
	</body>

</html>