<html>
 <head>
  <title>Profileinstellungen verwalten</title>
  <link rel="stylesheet" type="text/css" href="/MyEvents/style/register.css">
  <jsp:include page="/MyEvents/privatnutzer/LoadDataServlet/" />
 </head>
  
  <body>
   <h1>Benutzerdaten für Benutzer: ${benutzername} ändern </h1>
   <div class="registerform">
    <form method="post" action="/MyEvents/privatnutzer/ManageUserDataServlet">
     
        <label>Password     :</label><input type="password" name="password" value="${password}" /><br/><br/>
        <label>Name         :</label><input type="text" name="name" value="${name}" /><br/><br/>
        <label>E-Mail       :</label><input type="text" name="email" value="${email}" /><br/><br/>
        <label>Telefonnummer:</label><input type="text" name="phonenr" value="${phonenr}" /><br/><br/>
        <input type="submit" value="Änderungen speichern" />
   		<div class="error">${errorMessage}</div>     
   		<div class="info">${infoMessage}</div>     		
   		
   </form>
  </div>
  
  <div class="topleft">
     <a href="/MyEvents/privatnutzer/main.jsp">&lt;&lt; Zurück</a>
    </div>
  
 </body>

</html>