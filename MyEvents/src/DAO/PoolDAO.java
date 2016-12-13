package DAO;


import user.*;
import main.*;

/*
 * Dieser Klasse enthaelt alle DAO Objekte unserer App
 */
public class PoolDAO {
	
	public static PoolDAO poolDAO = null;
	
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
