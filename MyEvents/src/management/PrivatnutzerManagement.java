package management;

import java.util.ArrayList;

import main.*;

/**
 * Der Privatnutzer benutzt diese Klasse um Termine zu erstellen, Veranstaltungen zu importieren oder 
 * auf dem Privatenkalender zu löschen und Veranstaltungen zu bewerten.
 *
 */
public class PrivatnutzerManagement { 
	
	public void addVeranstaltungzuPriv(int id){
		ArrayList<Integer> ver =new ArrayList<Integer>();
		ver=PrivaterKalender.getPublic_events();
		ver.add(id);
		PrivaterKalender.setPublic_events(ver);
	}
	
	public void removeVeranstaltung(int id){
		ArrayList<Integer> ver =new ArrayList<Integer>();
		ver=PrivaterKalender.getPublic_events();
		Integer index;
		for(Integer i : ver ){
			if(i==id) index=i;
		}
		ver.remove(index);
		PrivaterKalender.setPublic_events(ver);
		
	}

	public void addPrivateEvent(Termin termin){
		ArrayList<Termin> termine=new ArrayList<Termin>();
		termine=PrivaterKalender.getPrivate_appointments();
		termine.add(termin);
		PrivaterKalender.setPrivate_appointments(termine);
		
	}
	
	//wurdebewertet()
}
