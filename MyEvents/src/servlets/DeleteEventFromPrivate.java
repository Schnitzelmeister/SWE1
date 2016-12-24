package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Termin;

/**
 * Servlet ist zuständig für das Löschen von Terminobjekten
 */
@WebServlet("/privatnutzer/DeleteEventFromPrivate")
public class DeleteEventFromPrivate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteEventFromPrivate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet wurde gestartet");
		Integer eventId = Integer.parseInt(request.getParameter("id"));
		
		boolean eventDeleted=false;
		
		Termin terminObject=PoolDAO.poolDAO.getTerminDAO().getItemById(eventId);
		if(terminObject != null){
			PoolDAO.poolDAO.getTerminDAO().loescheItem(terminObject);
			eventDeleted=true;
		}else{
			eventDeleted=false;
		}
		
		if(eventDeleted)
			response.sendRedirect("/MyEvents/privatnutzer/privatkalendar.jsp?info=Der Kalendereintrag wurde erfolgreich entfernt");
		else	
			response.sendRedirect("/MyEvents/privatnutzer/privatkalendar.jsp?error=Der Kalendereintrag konnte nicht gelöscht werden");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
