package main;

import java.util.ArrayList;
import java.util.Calendar;

import DAO.PersistableObject;

public class Veranstaltung extends PersistableObject {
	private int userId;
	private String name;
	private String description;
	private String category;
	private String location;
	private Calendar startTime;
	private Calendar endTime;
	private int availablePlaces;
	private double averageRating;
	private int numberOfRatings;
	
	
	public Veranstaltung(int eventId, int userId, String name, String description,
			String category, String location, Calendar startTime, Calendar endTime,
			int availablePlaces, double averageRating, int numberOfRatings) {
		super(eventId);
		this.userId=userId;
		this.name=name;
		this.description=description;
		this.category=category;
		this.location=location;
		this.startTime=startTime;
		this.endTime=endTime;
		this.availablePlaces=availablePlaces;
		this.averageRating=averageRating;
		this.numberOfRatings=numberOfRatings;
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
	
	public double getAverageRating() {
		return averageRating;
	}
	
	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}
	
	public int getNumberOfRatings() {
		return numberOfRatings;
	}
	
	public void setNumberOfRatings(int numberOfRatings) {
		this.numberOfRatings = numberOfRatings;
	}
	
}
