package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import management.AdminManagement;
import user.Privatnutzer;
import user.User;


@WebServlet("/register")
public class CreateNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void init() throws ServletException {
    	PoolDAO.poolDAO = new PoolDAO( getServletContext().getRealPath("/WEB-INF/data") );
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/MyEvents/register.jsp");
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	 AdminManagement management = new AdminManagement();
    	 PrintWriter out = response.getWriter();
    	 String username = request.getParameter("username");
    	 String password = request.getParameter("password");
    	 String realName = request.getParameter("name");
    	 String email = request.getParameter("email");
    	 String phone = request.getParameter("phonenr");
    	 String usertype = request.getParameter("usertype");    	     	  
    	 
    	 try{ 
    		 validValues(username, password, realName, email, phone);
    	 
    		 if(usertype.equals("private")){
    			 management.createNewPrivateUser(username, password, realName, email, phone);
    		 }
    	 
    		 if(usertype.equals("analytiker")){
    			 management.createNewAnalyst(username, password, realName, email, phone);
    		 }
    		 
    		 if(usertype.equals("admin")){
    			 management.createNewAdmin(username, password, realName, email, phone);
    		 }
    	 
    		 if(usertype.equals("veranstalter")){
    			 management.createNewOrganiser(username, password, realName, email, phone);
    		 }
    	
    	     request.setAttribute("infoMessage", "Das Konto mit dem Namen <b>"+username+"</b> wurde erfolgreich erstellt");
	    	 request.getRequestDispatcher("/login.jsp").forward(request, response);
    	 
    	 }catch(IllegalArgumentException e){
    		 request.setAttribute("errorMessage", e.getMessage());
 	    	 request.getRequestDispatcher("/register.jsp").forward(request, response);
    		 
    	 }catch(Exception e){
    		 request.setAttribute("errorMessage", "Ein Fehler ist aufgetreten");
 	    	 request.getRequestDispatcher("/register.jsp").forward(request, response);
    	 }
}
     
    public void validValues(String username, String password, String realName, String email, String phone) throws IllegalArgumentException{
    	
	    boolean usernameBesetzt = PoolDAO.poolDAO.getUserDAO().usernameAlreadyUsed(username);
	   
	    if(usernameBesetzt){
	    	throw new IllegalArgumentException("Der Benutzername ist schon vergeben");
	    }
	    
    	if(username.equals("") || password.equals("") || realName.equals("") || email.equals("") || phone.equals(""))
    		throw new IllegalArgumentException("Kein Feld darf leer bleiben");

    	if(username.length() > 30){
    		throw new IllegalArgumentException("Der Benutzername darf nicht l�nger als 30 Zeichen sein");
    	}
    	
    	if(password.length() < 8){
    		throw new IllegalArgumentException("Das Passwort muss mindestens 8 Stellen haben");
    	}
    	
    	if(!validEmail(email)){
    		throw new IllegalArgumentException("Die angegebene Email Adresse ist keine g�ltige Email");
    	}
    }
    
    public boolean validEmail(String email){
    	Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(email);
		
		return mat.matches();
    }
    
   

}
