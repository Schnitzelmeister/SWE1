<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="/MyEvents/style/register.css">
<title>Neues Benutzerkonto erstellen</title>
</head>

    
    <body>
    <h1>Neuen Benutzeraccount erstellen</h1>
    <br/><br/><br/><br/>
    <div class="registerform">
    <form method="post" action="register">
    	<br/><br/><br/><br/>
        <label>Benutzername :</label><input type="text" name="username" /><br/><br/>
        <label>Password     :</label><input type="password" name="password" /><br/><br/>
        <label>Name         :</label><input type="text" name="name" /><br/><br/>
        <label>E-Mail       :</label><input type="text" name="email" /><br/><br/>
        <label>Telefonnummer:</label><input type="text" name="phonenr" /><br/><br/>
        <input type="hidden" name="usertype" value="private" />
        <input type="hidden" name="formtype" value="publicform" />
        <br/>
        <div class="confirm">
        <input type="submit" value="Konto erstellen" />
		</div>
        <br/><br/>
        </form>
         <div class="error">${errorMessage}</div>
       </div> 
        
       <div class="button">
        <a href="/MyEvents/login.jsp">Abbrechen</a>
        </div>
       
      
       
    </body>

</html>


