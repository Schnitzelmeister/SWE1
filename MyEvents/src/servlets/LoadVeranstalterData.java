package servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import user.Veranstalter;

//@WebServlet("/LoadVeranstalterData")
public class LoadVeranstalterData extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public LoadVeranstalterData(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer Id = (Integer) request.getSession().getAttribute("userid");
		Veranstalter veranstalter = (Veranstalter) PoolDAO.poolDAO.getUserDAO().getItemById(Id);
		String uname=veranstalter.getUsername();
		String real=veranstalter.getRealName();
		String password=veranstalter.getPasswort();
		String telnr=veranstalter.getPhone();
		String email=veranstalter.getEmail();
		
		request.setAttribute("veranstaltername", uname);
		request.setAttribute("name", real);
		request.setAttribute("password", password);
		request.setAttribute("telnr", telnr);
		request.setAttribute("email", email);
		
	}
	

}
