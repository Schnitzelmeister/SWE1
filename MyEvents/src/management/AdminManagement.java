package management;

import DAO.PoolDAO;
import user.Privatnutzer;

public class AdminManagement {
	/**
	 * In dieser Klasse befindet sich die Funtkionalität die es ermöglicht neue Benutzer zu erstellen und zu speichern, 
	 * sobald ein Benutzer erstellt wird wird er auch automatisch gespeichert. Das RegisterServlet benutzt die Methode createNewPrivateUser() um Privatbenutzer zu erstellen.
	 */
	
	public void createNewPrivateUser
	(String username,
	 String passwort,
	 String realName,
	 String email,
	 String phone)
	{
		Privatnutzer account = new Privatnutzer(username, passwort, realName, email, phone);
		
		PoolDAO.poolDAO.getUserDAO().speichereItem(account);
	}
	
	public void createNewAnalyst(){
		
	}
	
	public void createNewAdmin(){
	
	}

	public void createNewOrganiser(){
	
	}
}
