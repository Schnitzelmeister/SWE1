package DAO;

import main.Veranstaltung;

public interface VeranstaltungDAO {
	public Veranstaltung getVeranstaltung(Integer id);
	public void deleteVeranstaltung(Integer id);
	public void saveVeranstaltung(Veranstaltung veranstaltung) ;
}
