package com.moviebooking.exceptions;

public class SeatNotAvailableException extends Exception{

    @Override
    public String toString() {
        return "Some Seats are already Booked! Please try booking available seats!";
    }
}
