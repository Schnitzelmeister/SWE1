<html>
    <head>
        <title>MyEvents Login</title>
        <link rel="stylesheet" type="text/css" href="/MyEvents/style/login.css">
    </head>
    
    <body>
     <h1>Willkommen bei MyEvents</h1>
    <div class="loginform">
        <form method="post" action="/MyEvents/LoginServlet">
        <p>Benutzername:</p><input type="text" name="username" /><br/>
        <p>Passwort:</p><input type="password" name="password" /><br/>
        <br/>
        <input type="submit" value="Anmelden" />
        </form>
        <div class="error"><b>${errorMessage}</b></div>
        <div class="info">${infoMessage}</div>
     </div>
     
        <div class="button">
          <a href="/MyEvents/register.jsp">Neues Benutzerkonto erstellen</a>
        </div>
       
      
    </body>
</html>