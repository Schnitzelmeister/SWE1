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
 * Servlet ist zust�ndig f�r das L�schen von Terminobjekten
 */
@WebServlet("/privatnutzer/DeleteEventFromPrivate")
public class DeleteEventFromPrivate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteEventFromPrivate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer eventId = Integer.parseInt(request.getParameter("id"));
		
		boolean eventDeleted=false;
		
		Termin terminObject=PoolDAO.poolDAO.getTerminDAO().getItemById(eventId);
		PoolDAO.poolDAO.getTerminDAO().loescheItem(terminObject);
			
		response.sendRedirect("/MyEvents/privatnutzer/privatkalendar.jsp?info=Der Kalendereintrag wurde erfolgreich entfernt");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
