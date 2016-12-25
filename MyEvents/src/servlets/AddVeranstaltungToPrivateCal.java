package servlets;

import java.io.IOException;
import java.util.ArrayList;

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
		boolean isAlreadyRegistered=false;
		
		Privatnutzer user = (Privatnutzer) PoolDAO.poolDAO.getUserDAO().getItemById(userId);
		Veranstaltung veranstaltung = PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(eventId);
		Integer available = veranstaltung.getAvailablePlaces();
		ArrayList<Integer> myPublicEvents = user.getKalender().getPublic_events();
		
		
		for(int i=0; i<myPublicEvents.size(); i++){
			if(myPublicEvents.get(i).equals(eventId)){
				isAlreadyRegistered = true;
				break;
			}
		}
		if(isAlreadyRegistered == true) throw new IllegalArgumentException("Sie haben sich bereits für diese Veranstaltung registriert");
		if(available <= 0) throw new IllegalArgumentException("Es gibt keine freien Plätze, Sie können nicht an der Veranstaltung teilnehmen");
		
		veranstaltung.setAvailablePlaces(--available);
		user.getKalender().getPublic_events().add(eventId);
		PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem(veranstaltung);
		PoolDAO.poolDAO.getUserDAO().speichereItem(user);
		response.sendRedirect("/MyEvents/privatnutzer/privatkalendar.jsp?info=Die Veranstaltung wurde in den Privatkalender hinzugefügt");
	 }catch(IllegalArgumentException e){
		 Integer eventId = Integer.parseInt(request.getParameter("id"));
		 response.sendRedirect("/MyEvents/privatnutzer/veranstaltung_details.jsp?id="+eventId+"&error="+e.getMessage());
	 }catch(Exception e){
		 response.sendRedirect("/MyEvents/privatnutzer/main.jsp");
	 }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
