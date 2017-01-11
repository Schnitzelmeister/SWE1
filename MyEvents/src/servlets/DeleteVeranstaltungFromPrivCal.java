package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Veranstaltung;
import user.Privatnutzer;


@WebServlet("/privatnutzer/DeleteVeranstaltungFromPrivCal")
public class DeleteVeranstaltungFromPrivCal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteVeranstaltungFromPrivCal() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer veranstaltungId = Integer.parseInt(request.getParameter("id"));
		Integer userId = (Integer) request.getSession().getAttribute("userid");
		Privatnutzer user = (Privatnutzer) PoolDAO.poolDAO.getUserDAO().getItemById(userId);
		Veranstaltung veranstaltung = (Veranstaltung) PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltungId);
		
		if(user.getKalender().getPublic_events().contains(veranstaltungId)){
			user.getKalender().getPublic_events().remove(veranstaltungId);
			PoolDAO.poolDAO.getUserDAO().speichereItem(user);
			Integer places = veranstaltung.getAvailablePlaces();
			veranstaltung.setAvailablePlaces(++places);
			PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem(veranstaltung);
			response.sendRedirect("/MyEvents/privatnutzer/veranstaltung_details.jsp?info=Die Veranstaltung wurde aus dem Privatkalender entfernt&id="+veranstaltungId);
		}else{
			response.sendRedirect("/MyEvents/privatnutzer/privatkalendar.jsp?error=Die Veranstaltung mit der angegebenen Id konnte nicht gefeunden werden.");
			return;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
