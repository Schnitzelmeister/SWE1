package user;

import java.util.ArrayList;

import management.PrivatnutzerManagement;

public class Privatnutzer extends User{
	private Integer kalender;
	private ArrayList<Integer> bewertete_veranstaltungen;
	private PrivatnutzerManagement management;
	
	public Integer getKalender() {
		return kalender;
	}
	
	public void setKalender(Integer kalender) {
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
