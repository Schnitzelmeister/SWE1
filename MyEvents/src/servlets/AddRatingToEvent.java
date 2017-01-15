package servlets;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import main.Veranstaltung;
import user.Privatnutzer;

/**
 * Servlet implementation class AddRatingToEvent
 */
@WebServlet("/privatnutzer/AddRatingToEvent")
public class AddRatingToEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddRatingToEvent() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/MyEvents/privatnutzer/main.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer veranstaltungId = -1;
		try {
			veranstaltungId = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Eine ungültige wurde als Parameter übergeben");		
		}

		Veranstaltung veranstaltung = PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltungId);
		Integer userId = (Integer) request.getSession().getAttribute("userid");
		Privatnutzer user = (Privatnutzer) PoolDAO.poolDAO.getUserDAO().getItemById(userId);
		Integer ratingFromUser = Integer.parseInt(request.getParameter("wertung"));
		Calendar now = Calendar.getInstance();

		try {
			if (user.getBewertete_veranstaltungen().contains(veranstaltungId))
				throw new IllegalArgumentException("Sie haben diese Veranstaltung bereits bewertet");

			if (veranstaltung.getEndTime().after(now))
				throw new IllegalArgumentException("Eine Veranstaltung kann erst nach Ablauf beurteilt werden");

			user.getBewertete_veranstaltungen().add(veranstaltungId);
			veranstaltung.addRating(ratingFromUser);
			PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem(veranstaltung);
			PoolDAO.poolDAO.getUserDAO().speichereItem(user);
			response.sendRedirect(
					"/MyEvents/privatnutzer/veranstaltung_privatkalender.jsp?id="+veranstaltungId+"&info=Ihre Bewertung wurde hinzugefügt");
		} catch (IllegalArgumentException e) {
			response.sendRedirect("/MyEvents/privatnutzer/veranstaltung_privatkalender.jsp?id="+veranstaltungId+"&error=" + e.getMessage());
		}

	}
}
