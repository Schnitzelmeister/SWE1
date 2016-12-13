package main;

import java.util.Calendar;

import DAO.PersistableObject;

public class Termin extends PersistableObject {
	private String name;
	private String location;
	private String beschreibung;
	private Calendar startTime;
	private Calendar endTime;
	
	public Termin(int id, String name, String location, Calendar startTime, Calendar endTime, String beschreibung) {
		super(id);
		this.name=name;
		this.location=location;
		this.startTime=startTime;
		this.endTime=endTime;
		this.beschreibung=beschreibung;
	}
	
	public int getAppointmentId() {
		return super.id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Calendar getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	
	public Calendar getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	
	public String getBeschreibung(){
		return this.beschreibung;
	}
	
	public void setBeschreibung(String beschreib){
		this.beschreibung=beschreib;
	}
	
}
