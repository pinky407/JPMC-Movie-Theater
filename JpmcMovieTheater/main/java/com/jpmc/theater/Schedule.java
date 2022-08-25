package com.jpmc.theater;

import java.time.LocalDateTime;

public class Schedule {
	
	private int sequenceOfTheDay;
	private String showStartTime;
	private String title;
	private String runningTime;
	private double ticketPrice;
	
	public int getSequenceOfTheDay() {
		return sequenceOfTheDay;
	}
	public void setSequenceOfTheDay(int sequenceOfTheDay) {
		this.sequenceOfTheDay = sequenceOfTheDay;
	}
	public String getShowStartTime() {
		return showStartTime;
	}
	public void setShowStartTime(String showStartTime) {
		this.showStartTime = showStartTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(String runningTime) {
		this.runningTime = runningTime;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	@Override
	public String toString() {
		return sequenceOfTheDay + ": " + showStartTime + " " + title + " " +runningTime + " $" + ticketPrice ;
	}
	
	
	

}
