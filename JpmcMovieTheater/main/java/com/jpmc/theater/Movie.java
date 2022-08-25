package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing) {
    	
        return ticketPrice - getDiscount(showing);
    }

    private double getDiscount(Showing showing) {
    	
    	LocalDateTime startTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0));
    	LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 0));
    	
    	List<Double> discountList  = new ArrayList<>();
   
        if (MOVIE_CODE_SPECIAL == specialCode) { 
            discountList.add(ticketPrice * 0.2); // 20% discount for special movie
        }
        
        if(showing.getStartTime().isAfter(startTime) && showing.getStartTime().isBefore(endTime)) {
        	discountList.add(ticketPrice * 0.25); // Any movies showing starting between 11AM ~ 4pm, you'll get 25% discount
        }

        if (showing.getSequenceOfTheDay() == 1) {
        	discountList.add(3.0); // $3 discount for 1st show
        }else if (showing.getSequenceOfTheDay() == 2) {
        	discountList.add(2.0); // $2 discount for 2nd show
        }
        else if (showing.getSequenceOfTheDay() == 7) {
        	discountList.add(1.0); // $2 discount for 2nd show
        }
        
        if(discountList.isEmpty()) {
        	return 0.0;
        }
        
        return Collections.max(discountList);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}