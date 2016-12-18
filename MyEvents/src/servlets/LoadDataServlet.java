package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.PoolDAO;
import user.Privatnutzer;


//@WebServlet("/loaddata")
public class LoadDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoadDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer currentUserId = (Integer) request.getSession().getAttribute("userid");
		Privatnutzer user = (Privatnutzer) PoolDAO.poolDAO.getUserDAO().getItemById(currentUserId);
		
		String username=user.getUsername();
		String realname=user.getRealName();
		String password=user.getPasswort();
		String phone=user.getPhone();
		String email=user.getEmail();
		
		request.setAttribute("benutzername", username);
		request.setAttribute("password", password);
		request.setAttribute("name", realname);
		request.setAttribute("email", email);
		request.setAttribute("phonenr", phone);    	 
	}
}
