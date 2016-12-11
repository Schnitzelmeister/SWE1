package user;

import java.util.ArrayList;

import main.PrivaterKalender;
import management.PrivatnutzerManagement;

public class Privatnutzer extends User{
	
	private static final long serialVersionUID = 100L;
	
	private PrivaterKalender kalender;
	private ArrayList<Integer> bewertete_veranstaltungen;
	private transient PrivatnutzerManagement management;
	
	
	public Privatnutzer(String username, String passwort, String realName, String email, String phone){
		super(username, passwort, realName, email, phone);
		bewertete_veranstaltungen = new ArrayList<Integer>();
		management= new PrivatnutzerManagement();
		kalender = new PrivaterKalender();
	}
	
	public PrivaterKalender getKalender() {
		return kalender;
	}
	
	public void setKalender(PrivaterKalender kalender) {
		this.kalender = kalender;
	}
	
	public ArrayList<Integer> getBewertete_veranstaltungen() {
		return bewertete_veranstaltungen;
	}
	
	public void setBewertete_veranstaltungen(ArrayList<Integer> bewertete_veranstaltungen) {
		this.bewertete_veranstaltungen = bewertete_veranstaltungen;
	}
	public PrivatnutzerManagement getManagement() {
		return management;
	}
	public void setManagement(PrivatnutzerManagement management) {
		this.management = management;
	}
	
	
	
	
}
