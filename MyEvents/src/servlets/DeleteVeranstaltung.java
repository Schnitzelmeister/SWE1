package servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Veranstaltung;

@WebServlet("/DeleteVeranstaltung")
public class DeleteVeranstaltung extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DeleteVeranstaltung(){
		super();
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try{
			Veranstaltung veranstaltung=PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(id);
			if(veranstaltung.getTeilnehmer()>=1) throw new IllegalArgumentException("Es sind schon Teilnehmer vorhanden.");
		PoolDAO.poolDAO.getVeranstaltungDAO().loescheItem(veranstaltung);
		response.sendRedirect("/MyEvents/veranstalter/vermain.jsp?=Die Veranstaltung wurde gelöscht.");
		}
		catch(IllegalArgumentException e){
			throw new IllegalArgumentException("Ein Fehler ist aufgetreten"+e.getMessage());
		}
	}

}
