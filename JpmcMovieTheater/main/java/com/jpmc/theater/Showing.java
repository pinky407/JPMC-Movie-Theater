package com.jpmc.theater;

import java.time.LocalDateTime;
import java.util.Objects;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public boolean isSequence(int sequence) {
        return this.sequenceOfTheDay == sequence;
    }

    public double getMovieFee() {
        return movie.getTicketPrice();
    }

    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    private double calculateFee(int audienceCount) {
        return movie.calculateTicketPrice(this) * audienceCount;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showing showing = (Showing) o;
        return  Objects.equals(movie, showing.movie)
                && Objects.equals(movie, showing.sequenceOfTheDay)
                && Objects.equals(movie, showing.showStartTime);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(movie, sequenceOfTheDay, showStartTime);
    }
}
