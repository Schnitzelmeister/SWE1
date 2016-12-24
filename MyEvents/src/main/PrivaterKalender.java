package main;

import java.util.ArrayList;

import DAO.PersistableObject;

public class PrivaterKalender implements java.io.Serializable {
	
	private static final long serialVersionUID = 100L;
	
	ArrayList<Integer> public_events;
	ArrayList<Integer> private_appointments;
	
	public PrivaterKalender(){
		public_events = new ArrayList<Integer>();
		private_appointments = new ArrayList<Integer>();		
	}

	public ArrayList<Integer> getPublic_events() {
		return public_events;
	}

	public void setPublic_events(ArrayList<Integer> public_events) {
		this.public_events = public_events;
	}

	public ArrayList<Integer> getPrivate_appointments() {
		return private_appointments;
	}

	public  void setPrivate_appointments(ArrayList<Integer> private_appointments) {
		this.private_appointments = private_appointments;
	}
	
	
	
}
