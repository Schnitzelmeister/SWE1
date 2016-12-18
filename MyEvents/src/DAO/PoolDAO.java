package DAO;


import user.*;

import javax.servlet.ServletException;

import main.*;

/*
 * Dieser Klasse enthaelt alle DAO Objekte unserer App
 */
public class PoolDAO {
	
	public static PoolDAO poolDAO = null;
	private static final Object lockObj = new Object();
	
    /*
     * Init Application Data in PoolDAO.poolDAO
     */
	public static void init(String path) {
    	if (PoolDAO.poolDAO == null) {
    		synchronized(lockObj) {
	    		System.out.println("Path to DATA Folder = "+ path);
	    		System.out.println("Die Daten werden in diesem Folder gespeichert");
	    		
				PoolDAO.poolDAO = new PoolDAO( path );
				
				//Bitte kreiert euere Default Users und vielleciht andere Objekte (Veranstaltungen, Termine, etc)
				//Damit koennen wir alles testen
				
		    	//default users
				
				//Admin
				try {
			    	Admin admin = new Admin("admin", "admin", "admin", "admin@myevents.at", "123");
					PoolDAO.poolDAO.getUserDAO().speichereItem(admin);
				}
				catch (Exception e) {
				}
				
				//Analytiker
				try {
					Analytiker analytiker = new Analytiker("analytiker", "123456789", "analytiker", "analytiker@myevents.at", "123");
					PoolDAO.poolDAO.getUserDAO().speichereItem(analytiker);
				}
				catch (Exception e) {
				}
				
				//Privatnutzer
				
				
				//Veranstalter
				
				
				//Veranstaltungen
				
				
				//Termine
				
    		}
    	}
    }
	
	private UserDAO userDAO;
	public UserDAO getUserDAO() {
		return userDAO;
	}

	private UniversalDAO<Veranstaltung> veranstaltungDAO;
	public UniversalDAO<Veranstaltung> getVeranstaltungDAO() {
		return veranstaltungDAO;
	}

	private UniversalDAO<Termin> terminDAO;
	public UniversalDAO<Termin> getTerminDAO() {
		return terminDAO;
	}

	/*
	 * Als Parameter muss man den Pfad vom Verzeichnis mit Daten uebergeben
	 */
	public PoolDAO(String dataDir) throws IllegalArgumentException {

	    if ( !java.nio.file.Files.exists( java.nio.file.Paths.get(dataDir) ) )
	    	throw new IllegalArgumentException("Illegal Data Directory Path " + dataDir);
		
	    userDAO = new UserDAO(dataDir + "/user.dao");
		veranstaltungDAO = new UniversalDAO<Veranstaltung>(dataDir + "/veranstaltung.dao");
		terminDAO = new UniversalDAO<Termin>(dataDir + "/termin.dao");
	}
}
