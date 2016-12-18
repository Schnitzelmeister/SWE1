package main;

import java.util.Calendar;

import DAO.PersistableObject;

public class Termin  implements java.io.Serializable {
	private static final long serialVersionUID = 100L;
	
	private String name;
	private String location;
	private String beschreibung;
	private Calendar startTime;
	private Calendar endTime;
	
	public Termin(String name, String location, Calendar startTime, Calendar endTime, String beschreibung) {
		this.name=name;
		this.location=location;
		this.startTime=startTime;
		this.endTime=endTime;
		this.beschreibung=beschreibung;
	}
	
	public Termin(){}
	
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
