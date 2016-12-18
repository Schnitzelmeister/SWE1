package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import user.Privatnutzer;


@WebServlet("/privatnutzer/manageuserdata")
public class ManageUserDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ManageUserDataServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/MyEvents/privatnutzer/manage_profile.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{	
		  Integer currentUserId = (Integer) request.getSession().getAttribute("userid");
		  Privatnutzer user = (Privatnutzer) PoolDAO.poolDAO.getUserDAO().getItemById(currentUserId);
		
		  String username= user.getUsername();
		  String realname= request.getParameter("name");
		  String password= request.getParameter("password");
		  String phone= request.getParameter("phonenr");
		  String email= request.getParameter("email");
		  
		  validValues(password, realname, email, phone);
		
		  PoolDAO.poolDAO.getUserDAO().getUserbyUsername(username).setEmail(email);
		  PoolDAO.poolDAO.getUserDAO().getUserbyUsername(username).setRealName(realname);
		  PoolDAO.poolDAO.getUserDAO().getUserbyUsername(username).setPhone(phone);
		  PoolDAO.poolDAO.getUserDAO().getUserbyUsername(username).setPasswort(password);
		
		  request.setAttribute("benutzername", username);
		  request.setAttribute("name", realname);
		  request.setAttribute("email", email);
		  request.setAttribute("password", password);
		  request.setAttribute("phonenr", phone);
		  request.setAttribute("infoMessage", "Die Daten wurden erfolgreich geändert");
	      request.getRequestDispatcher("/privatnutzer/manage_profile.jsp").forward(request, response);
	      
	   }catch(IllegalArgumentException e){
		  Integer currentUserId = (Integer) request.getSession().getAttribute("userid");
		  Privatnutzer user = (Privatnutzer) PoolDAO.poolDAO.getUserDAO().getItemById(currentUserId);
			
		  String username=user.getUsername();
		  String realname=user.getRealName();
		  String password=user.getPasswort();
		  String phone=user.getPhone();
		  String email=user.getEmail();
			
		  request.setAttribute("benutzername", username);
		  request.setAttribute("password", password);
		  request.setAttribute("name", realname);
		  request.setAttribute("email", email);
		  request.setAttribute("phonenr", phone);    	 
		  request.setAttribute("errorMessage", e.getMessage());
		  request.getRequestDispatcher("/privatnutzer/manage_profile.jsp").forward(request, response);
	   }
	}

	public void validValues(String password, String realName, String email, String phone) throws IllegalArgumentException{
    		    
    	if( password.equals("") || realName.equals("") || email.equals("") || phone.equals(""))
    		throw new IllegalArgumentException("Kein Feld darf leer bleiben");
    	
    	if(password.length() < 8){
    		throw new IllegalArgumentException("Das Passwort muss mindestens 8 Stellen haben");
    	}
    	
    	if(!validEmail(email)){
    		throw new IllegalArgumentException("Die angegebene Email Adresse ist keine gültige Email");
    	}
    }
	
	public boolean validEmail(String email){
    	Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
		
		return mat.matches();
    }	
}	







