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

import user.Privatnutzer;


@WebServlet("/register")
public class CreateNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/MyEvents/register.html");
	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	 PrintWriter out = response.getWriter();
    	 String username = request.getParameter("username");
    	 String password = request.getParameter("password");
    	 String realName = request.getParameter("name");
    	 String email = request.getParameter("email");
    	 String phone = request.getParameter("phonenr");
    	 String usertype = request.getParameter("usertype");
    	 
    	 boolean created=false;
    try{ 
    	 validValues(username, password, realName, email, phone);
    	 RequestDispatcher rs = request.getRequestDispatcher("register.html");
    	 
    	 if(usertype == "privateuser"){
    		 Privatnutzer newAccount = new Privatnutzer();
         }
    	 
    	 if(usertype == "analytiker"){
    		 
    	 }
    	 
    	 if(usertype == "admin"){
    		 
    	 }
    	 
    	 if(usertype == "veranstalter"){
    		 
    	 }
    	 
    	 
    	 
    }catch(IllegalArgumentException e){
    
    	out.println("<b>"+e.getMessage()+"</b>"); 
        rs.include(request, response);
    }
}
  
     
   public void validValues(String username, String password, String realName, String email, String phone) throws IllegalArgumentException{
    	boolean isValid=false;
    	
    	if(username=="" || password=="" || realName=="" || email=="" || phone=="")
    		throw new IllegalArgumentException("Kein Feld darf leer bleiben");

    	if(username.length() > 30){
    		throw new IllegalArgumentException("Der Benutzername darf nicht länger als 30 Zeichen sein");
    	}
    	
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
