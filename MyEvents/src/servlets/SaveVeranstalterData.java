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
import user.Veranstalter;

@WebServlet("/veranstalter/SaveVeranstalterData")
public class SaveVeranstalterData extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public SaveVeranstalterData(){
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try{
			Integer Id = (Integer) request.getSession().getAttribute("userid");
			Veranstalter veranstalter = (Veranstalter) PoolDAO.poolDAO.getUserDAO().getItemById(Id);
			
			String realname=request.getParameter("name");
			String pw =request.getParameter("password");
			String email= request.getParameter("email");
			String telnr= request.getParameter("telnr");
			String benutzername=veranstalter.getUsername();
			
			validValues(pw, realname, email, telnr);
			
			PoolDAO.poolDAO.getUserDAO().getUserbyUsername(benutzername).setEmail(email);
			PoolDAO.poolDAO.getUserDAO().getUserbyUsername(benutzername).setPhone(telnr);
			PoolDAO.poolDAO.getUserDAO().getUserbyUsername(benutzername).setPasswort(pw);
			PoolDAO.poolDAO.getUserDAO().getUserbyUsername(benutzername).setRealName(realname);
			
			 request.setAttribute("veranstaltername", benutzername);
			  request.setAttribute("name", realname);
			  request.setAttribute("email", email);
			  request.setAttribute("password", pw);
			  request.setAttribute("telnr", telnr);
			  request.setAttribute("infoMessage", "Die Daten wurden erfolgreich geändert");
		      request.getRequestDispatcher("/privatnutzer/manage_profile.jsp").forward(request, response); 
		}
		catch(IllegalArgumentException e){
				  Integer Id = (Integer) request.getSession().getAttribute("userid");
				  Veranstalter veranstalter = (Veranstalter) PoolDAO.poolDAO.getUserDAO().getItemById(Id);
					
				  String uname=veranstalter.getUsername();
				  String real=veranstalter.getRealName();
				  String pw=veranstalter.getPasswort();
				  String telnr=veranstalter.getPhone();
				  String email=veranstalter.getEmail();
					
				  request.setAttribute("veranstaltername", uname);
				  request.setAttribute("password", pw);
				  request.setAttribute("name", real);
				  request.setAttribute("email", email);
				  request.setAttribute("telnr", telnr);    	 
				  request.setAttribute("errorMessage", e.getMessage());
				  request.getRequestDispatcher("/veranstalter/ChangeProfileVeranstalter.jsp").forward(request, response);
			   }
		   
	}
	
	/** Von ManageUserDataServlet übernommen
	 * 
	 */
	public void validValues(String password, String realName, String email, String phone) throws IllegalArgumentException{
	    
    	if( password==null || realName==null || email==null || phone==null )
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
