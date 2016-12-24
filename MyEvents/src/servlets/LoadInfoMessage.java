


package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoadInfoMessage
 */
@WebServlet("/privatnutzer/LoadInfoMessage/")
public class LoadInfoMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoadInfoMessage() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String infoMessage= request.getParameter("info");
		String errorMessage=request.getParameter("error");
		
		if(infoMessage != null)
			request.setAttribute("infoMessage", infoMessage);
		
		if(errorMessage != null)
			request.setAttribute("errorMessage", errorMessage);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
