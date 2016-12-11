package main;

import java.util.ArrayList;

import DAO.PersistableObject;

public class PrivaterKalender extends PersistableObject{
	ArrayList<Integer> public_events;
	ArrayList<Termin> private_appointments;
	
	public PrivaterKalender(){
		public_events = new ArrayList<Integer>();
		private_appointments = new ArrayList<Termin>();		
	}

	public ArrayList<Integer> getPublic_events() {
		return public_events;
	}

	public void setPublic_events(ArrayList<Integer> public_events) {
		this.public_events = public_events;
	}

	public ArrayList<Termin> getPrivate_appointments() {
		return private_appointments;
	}

	public void setPrivate_appointments(ArrayList<Termin> private_appointments) {
		this.private_appointments = private_appointments;
	}
	
	
	
}
