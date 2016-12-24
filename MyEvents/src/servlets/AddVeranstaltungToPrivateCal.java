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


@WebServlet("/privatnutzer/AddVeranstaltungToPrivateCal")
public class AddVeranstaltungToPrivateCal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddVeranstaltungToPrivateCal() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 try{	
		Integer eventId = Integer.parseInt(request.getParameter("id"));
		Integer userId = (Integer) request.getSession().getAttribute("userid");
		
		
		Privatnutzer user = (Privatnutzer) PoolDAO.poolDAO.getUserDAO().getItemById(userId);
		Veranstaltung veranstaltung = PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(eventId);
		System.out.println("User: "+user.getUsername());
		Integer available = veranstaltung.getAvailablePlaces();
		
		if(available <= 0) throw new IllegalArgumentException("Es gibt keine freien Plätze, Sie können nicht an der Veranstaltung teilnehmen");
		
		veranstaltung.setAvailablePlaces(--available);
		user.getKalender().getPublic_events().add(eventId);
		PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem(veranstaltung);
		response.sendRedirect("/MyEvents/privatnutzer/privatkalendar.jsp?info=Die Veranstaltung wurde in den Privatkalender hinzugefügt");
	 }catch(IllegalArgumentException e){
		 response.sendRedirect("/MyEvents/privatnutzer/veranstaltung_details.jsp?error="+e.getMessage());
	 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
