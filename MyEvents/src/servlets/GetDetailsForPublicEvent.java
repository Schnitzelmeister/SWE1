package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Veranstaltung;

@WebServlet("/GetDetailsForPublicEvent/")
public class GetDetailsForPublicEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GetDetailsForPublicEvent() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		Integer eventId = Integer.parseInt(request.getParameter("id"));
		
		Veranstaltung veranstaltung = PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(eventId);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
		
		String name=veranstaltung.getName();
		String kategorie=veranstaltung.getCategory();
		String vonTime= sdf1.format(veranstaltung.getStartTime().getTime());
		String bisTime= sdf1.format(veranstaltung.getEndTime().getTime());
		String vonDatum= sdf2.format(veranstaltung.getStartTime().getTime());
		String bisDatum= sdf2.format(veranstaltung.getEndTime().getTime());
		Integer freiePlaetze= veranstaltung.getAvailablePlaces();
		String info= veranstaltung.getDescription();
		String location= veranstaltung.getLocation();

		
		double average=veranstaltung.calculateRatingAverage();

		
		request.setAttribute("id", eventId);
		request.setAttribute("name", name);
		request.setAttribute("startTime", vonTime);
		request.setAttribute("endTime", bisTime);
		request.setAttribute("startDate", vonDatum);
		request.setAttribute("endDate", bisDatum);
		request.setAttribute("kategorie", kategorie);
		request.setAttribute("plaetze", freiePlaetze);
		request.setAttribute("average", average);
		request.setAttribute("info", info);
		request.setAttribute("location", location);
		
		if(request.getParameter("error") != null){
			String errorMessage = request.getParameter("error");
			request.setAttribute("errorMessage", errorMessage);
		}
		
		if(request.getParameter("info") != null){
			String infoMessage = request.getParameter("info");
			request.setAttribute("infoMessage", infoMessage);
		}
		}catch(IllegalArgumentException e){
			System.out.println("Fehlermeldung: "+e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
