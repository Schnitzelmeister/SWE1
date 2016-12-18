package management;

import DAO.PoolDAO;
import user.*;

public class AdminManagement {
	/**
	 * In dieser Klasse befindet sich die Funtkionalität die es ermöglicht neue Benutzer zu erstellen und zu speichern, 
	 * sobald ein Benutzer erstellt wird wird er auch automatisch gespeichert. Das RegisterServlet benutzt die Methode createNewPrivateUser() um Privatbenutzer zu erstellen.
	 */
	
	public void createNewPrivateUser(
	String username,
	String passwort,
	String realName,
	String email,
	String phone){
		
	    Privatnutzer account = new Privatnutzer(username, passwort, realName, email, phone);
	    PoolDAO.poolDAO.getUserDAO().speichereItem(account);
	    System.out.println("Benutzer "+username+" erstellt");
	}
	
	public void createNewAnalyst(
	String username,
	String passwort,
    String realName,
	String email,
    String phone){
		
		Analytiker account = new Analytiker(username, passwort, realName, email, phone);

		PoolDAO.poolDAO.getUserDAO().speichereItem(account);
	}
	
	public void createNewAdmin(
	String username,
	String passwort,
	String realName,
	String email,
	String phone){
		
		Admin account = new Admin(username, passwort, realName, email, phone);

		PoolDAO.poolDAO.getUserDAO().speichereItem(account);
	}

	public void createNewOrganiser(
	String username,
	String passwort,
	String realName,
	String email,
	String phone){
		
		Veranstalter account = new Veranstalter(username, passwort, realName, email, phone);

		PoolDAO.poolDAO.getUserDAO().speichereItem(account);
	}
}



















