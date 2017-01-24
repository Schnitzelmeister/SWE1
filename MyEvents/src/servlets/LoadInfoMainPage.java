package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import user.Veranstalter;

/**
 * Servlet implementation class LoadInfoMainPage
 */
//@WebServlet("/LoadInfoMainPage")
public class LoadInfoMainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoadInfoMainPage() {  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kategorie = request.getParameter("kategorie");
		request.setAttribute("kategorie", kategorie);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
