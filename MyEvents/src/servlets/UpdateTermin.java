package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Termin;
import user.Privatnutzer;


@WebServlet("/privatnutzer/UpdateTermin")
public class UpdateTermin extends HttpServlet {
	private static final long serialVersionUID = 1L;  
    
    public UpdateTermin() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try{
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		String info = request.getParameter("info");
		String startTime = request.getParameter("starttime");
		String endTime = request.getParameter("endtime");
		String startDatum = request.getParameter("startdatum");
		String endDatum = request.getParameter("enddatum");
		Calendar dateStart=Calendar.getInstance();
		Calendar dateEnd=Calendar.getInstance();
		
		Integer terminId= Integer.parseInt(request.getParameter("id"));


		Termin termin=PoolDAO.poolDAO.getTerminDAO().getItemById(terminId);

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd.MM.yyyy");
		try {
			dateStart.setTime(sdf.parse(startTime+" "+startDatum));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Ungültiges Datum oder Uhrzeit wurde angegeben");
		}
		
		try {
			dateEnd.setTime(sdf.parse(endTime+" "+endDatum));
		} catch (ParseException e) {
			throw new IllegalArgumentException("Ungültiges Datum oder Uhrzeit wurde angegeben");
		}
		
		checkValidityOfInput(dateStart, dateEnd, name, location, info);
		
		termin.setBeschreibung(info);
		termin.setLocation(location);
		termin.setName(name);
		termin.setStartTime(dateStart);
		termin.setEndTime(dateEnd);
		PoolDAO.poolDAO.getTerminDAO().speichereItem(termin);
		response.sendRedirect("/MyEvents/privatnutzer/privatkalendar.jsp?info=Die Änderungen wurden gespeichert");
	}catch(IllegalArgumentException e){
		Integer terminId= Integer.parseInt(request.getParameter("id"));
		response.sendRedirect("/MyEvents/privatnutzer/termindetails.jsp?id="+terminId+"&error="+e.getMessage());
	}catch(Exception e){
		Integer terminId= Integer.parseInt(request.getParameter("id"));
		response.sendRedirect("/MyEvents/privatnutzer/termindetails.jsp?id="+terminId+"&error=Ein Fehler ist aufgetreten");
		e.printStackTrace();
	}

}
	
	void checkValidityOfInput(Calendar from, Calendar to, String name, String location, String info){
		if(from.after(to)) throw new IllegalArgumentException("Das Anfangsdatum muss vor dem Enddatum stehen.");
		if(name.length()==0 || location.length()==0 || info.length()==0) throw new IllegalArgumentException("Kein Feld darf leer bleiben.");
	}
}









