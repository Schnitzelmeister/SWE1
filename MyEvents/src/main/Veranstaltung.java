package main;

import java.util.ArrayList;
import java.util.Calendar;

import DAO.PersistableObject;

public class Veranstaltung extends PersistableObject {
	private static final long serialVersionUID = 100L;
	
	private int userId;
	private String name;
	private String description;
	private String category;
	private String location;
	private Calendar startTime;
	private Calendar endTime;
	private int availablePlaces;
	ArrayList<Integer> rating;
	Integer teilnehmer;
	
	
	public Veranstaltung(int userId, String name, String description,
			String category, String location, Calendar startTime, Calendar endTime,
			int availablePlaces) {
		this.userId=userId;
		this.name=name;
		this.description=description;
		this.category=category;
		this.location=location;
		this.startTime=startTime;
		this.endTime=endTime;
		this.availablePlaces=availablePlaces;
		rating = new ArrayList<Integer>();
		this.teilnehmer=0;
	}
	
	public Veranstaltung(){}
	
	public int getEventId() {
		return super.id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
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
	
	public int getAvailablePlaces() {
		return availablePlaces;
	}
	
	public void setAvailablePlaces(int availablePlaces) {
		this.availablePlaces = availablePlaces;
	}
	
	public ArrayList<Integer> getRating(){
		return rating;
	}
	
	public void addRating(Integer ratingFromUser){
		rating.add(ratingFromUser);
	}
	
	public double calculateRatingAverage(){
		double average=0;
		Integer sum=0;
		
		for(int i=0; i<rating.size(); i++){
			sum+=rating.get(i);
		}
		
		return average=(((double)sum)/((double)rating.size()));
	}
	
	public void setTeilnehmer(int t){
		this.teilnehmer=teilnehmer+t;
	}
	
	public Integer getTeilnehmer(){
		return teilnehmer;
	}
	
	
	
	
	
	
	
	
}
