package DAO;


import main.*;
import user.*;

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
				
				//wenn admin exists, dann heist es, dass Default Daten schon hinzugefuegt wurden
				if (PoolDAO.poolDAO.getUserDAO().usernameAlreadyUsed("admin"))
					return;
				
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
				try {
					Privatnutzer privatnutzer = new Privatnutzer("ayrat", "123456789", "ayrat", "ayrat@myevents.at", "123");
					PoolDAO.poolDAO.getUserDAO().speichereItem(privatnutzer);
				}
				catch (Exception e) {
				}

				try {
					Privatnutzer privatnutzer = new Privatnutzer("markus", "123456789", "markus", "markus@myevents.at", "123");
					PoolDAO.poolDAO.getUserDAO().speichereItem(privatnutzer);
				}
				catch (Exception e) {
				}

				try {
					Privatnutzer privatnutzer = new Privatnutzer("jakub", "123456789", "jakub", "jakub@myevents.at", "123");
					PoolDAO.poolDAO.getUserDAO().speichereItem(privatnutzer);
					
				}
				catch (Exception e) {
				}

				try {
					Privatnutzer privatnutzer = new Privatnutzer("katharina", "123456789", "katharina", "katharina@myevents.at", "123");
					PoolDAO.poolDAO.getUserDAO().speichereItem(privatnutzer);
				}
				catch (Exception e) {
				}

				
				//Veranstalter - es gibt keine Beschreibung, vielleicht ist es nicht wichtig
				int veranstalter1 = 0, veranstalter2 = 0;
				try {
					Veranstalter veranstalter = new Veranstalter("veranstalter_1", "123456789", "Veranstalter 1", "veranstalter1@myevents.at", "123");
					PoolDAO.poolDAO.getUserDAO().speichereItem(veranstalter);
					veranstalter1 = veranstalter.getUserId();
				}
				catch (Exception e) {
				}

				try {
					Veranstalter veranstalter = new Veranstalter("veranstalter_2", "123456789", "Veranstalter 2", "veranstalter2@myevents.at", "123");
					PoolDAO.poolDAO.getUserDAO().speichereItem(veranstalter);
					veranstalter2 = veranstalter.getUserId();
				}
				catch (Exception e) {
				}

				
				//Veranstaltungen
				int veranstaltung1 = 0, veranstaltung2 = 0, veranstaltung3 = 0, veranstaltung4 = 0;
				try {
					java.util.Calendar from = java.util.Calendar.getInstance();
					from.set(2016, java.util.Calendar.DECEMBER, 31, 22, 0, 0);
					java.util.Calendar till = java.util.Calendar.getInstance();
					till.set(2017, java.util.Calendar.JANUARY, 01, 05, 0, 0);

					Veranstaltung veranstaltung = new Veranstaltung(veranstalter1, "Veranstaltung 1", "Veranstaltung 1", "Sport", "Wien", from, till, 10);
					PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem(veranstaltung);
					veranstaltung1 = veranstaltung.getId();
					
				}
				catch (Exception e) {
				}
				
				try {
					java.util.Calendar from = java.util.Calendar.getInstance();
					from.set(2016, java.util.Calendar.DECEMBER, 31, 22, 00);
					java.util.Calendar till = java.util.Calendar.getInstance();
					till.set(2017, java.util.Calendar.JANUARY, 01, 05, 00);

					Veranstaltung veranstaltung = new Veranstaltung(veranstalter1, "Veranstaltung 2", "Veranstaltung 2", "Sport", "Wien", from, till, 10);
					PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem(veranstaltung);
					veranstaltung2 = veranstaltung.getId();
				}
				catch (Exception e) {
				}				
				
				try {
					java.util.Calendar from = java.util.Calendar.getInstance();
					from.set(2016, java.util.Calendar.DECEMBER, 31, 22, 0, 0);
					java.util.Calendar till = java.util.Calendar.getInstance();
					till.set(2017, java.util.Calendar.JANUARY, 01, 05, 0, 0);

					Veranstaltung veranstaltung = new Veranstaltung(veranstalter2, "Veranstaltung 3", "Veranstaltung 3", "Kochkurs", "Wien", from, till, 10);
					PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem(veranstaltung);
					veranstaltung3 = veranstaltung.getId();
				}
				catch (Exception e) {
				}
				
				try {
					java.util.Calendar from = java.util.Calendar.getInstance();
					from.set(2016, java.util.Calendar.DECEMBER, 31, 22, 0, 0);
					java.util.Calendar till = java.util.Calendar.getInstance();
					till.set(2017, java.util.Calendar.JANUARY, 01, 05, 0, 0);

					Veranstaltung veranstaltung = new Veranstaltung(veranstalter2, "Veranstaltung 4", "Veranstaltung 4", "Kochkurs", "Wien", from, till, 10);
					PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem(veranstaltung);
					veranstaltung4 = veranstaltung.getId();
				}
				catch (Exception e) {
				}
				
				
				// public Termine
				try {
					Privatnutzer user = (Privatnutzer)PoolDAO.poolDAO.getUserDAO().getUserbyUsername("ayrat");
					user.getKalender().getPublic_events().add(veranstaltung1);
					user.getKalender().getPublic_events().add(veranstaltung2);
					
					//vielleicht noch
					//PoolDAO.poolDAO.getUserDAO().speichereItem(user);
					//oder
					//PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem( PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltung1) );
					//PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem( PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltung2) );

				}
				catch (Exception e) {
				}

				
				try {
					Privatnutzer user = (Privatnutzer)PoolDAO.poolDAO.getUserDAO().getUserbyUsername("markus");
					user.getKalender().getPublic_events().add(veranstaltung3);
					user.getKalender().getPublic_events().add(veranstaltung4);
					
					//vielleicht noch
					//PoolDAO.poolDAO.getUserDAO().speichereItem(user);
					//oder
					//PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem( PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltung3) );
					//PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem( PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltung4) );

				}
				catch (Exception e) {
				}

				
				try {
					Privatnutzer user = (Privatnutzer)PoolDAO.poolDAO.getUserDAO().getUserbyUsername("jakub");
					user.getKalender().getPublic_events().add(veranstaltung1);
					user.getKalender().getPublic_events().add(veranstaltung3);

					//vielleicht noch
					//PoolDAO.poolDAO.getUserDAO().speichereItem(user);
					//oder
					//PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem( PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltung1) );
					//PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem( PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltung3) );

				}
				catch (Exception e) {
				}

				
				try {
					Privatnutzer user = (Privatnutzer)PoolDAO.poolDAO.getUserDAO().getUserbyUsername("katharina");
					user.getKalender().getPublic_events().add(veranstaltung2);
					user.getKalender().getPublic_events().add(veranstaltung3);
					
					//vielleicht noch
					//PoolDAO.poolDAO.getUserDAO().speichereItem(user);
					//oder
					//PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem( PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltung2) );
					//PoolDAO.poolDAO.getVeranstaltungDAO().speichereItem( PoolDAO.poolDAO.getVeranstaltungDAO().getItemById(veranstaltung3) );
				}
				catch (Exception e) {
				}

				
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
