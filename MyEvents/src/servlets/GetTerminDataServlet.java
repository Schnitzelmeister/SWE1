package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Termin;
import main.Veranstaltung;

/**
 * Servlet implementation class GetTerminDataServlet
 */
@WebServlet("/privatnutzer/GetTerminDataServlet")
public class GetTerminDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetTerminDataServlet() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  try{
		Integer id = Integer.parseInt(request.getParameter("id"));
		Termin termin = PoolDAO.poolDAO.getTerminDAO().getItemById(id);
		
		request.setAttribute("id", id);	
	
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
		
		String startdatum=sdf1.format(termin.getStartTime().getTime());
		String enddatum=sdf1.format(termin.getEndTime().getTime());
		
		String startzeit=sdf2.format(termin.getStartTime().getTime());
		String endzeit=sdf2.format(termin.getEndTime().getTime());

		request.setAttribute("name", termin.getName());
		request.setAttribute("startdatum", startdatum);
		request.setAttribute("starttime", startzeit);
		request.setAttribute("enddatum", enddatum);
		request.setAttribute("endtime", endzeit);
		request.setAttribute("info", termin.getBeschreibung());
		request.setAttribute("location", termin.getLocation());

		if(request.getParameter("error") != null){	
			String error = request.getParameter("error");
			request.setAttribute("errorMessage", error);
		}	
	  }catch(IllegalArgumentException e){
			System.out.println("catch clause executed");

			response.sendRedirect("/MyEvents/privatnutzer/privatkalendar.jsp");
	  }
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
