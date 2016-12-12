/**
 * 
 */
package servlets;

/**
 * @author 
 *
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import main.*;


@WebServlet("PrivatnutzerHomeServlet")
public class PrivatnutzerHomeServlet extends HttpServlet{
	
	public PrivatnutzerHomeServlet(){
		super();
	}

		protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException{
			
			//addVeranstaltungtoPriv( id);
			
			//addPrivateEvent(event);
			
			//shownextmonth(); showlastmonth(); mittels fullCalendar?
			
			
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			doGet(request, response);
		}
}
