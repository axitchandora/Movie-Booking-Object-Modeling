package com.jnanacetana.moviebooking.entities;

public class ShowSeat extends Seat {
    private boolean isLocked;

    public ShowSeat(String seatId, int seatRow, int seatColumn) {
        super(seatId, seatRow, seatColumn);
        this.isLocked = false;
    }

    public void lock() {
        isLocked = true;
    }

    public void unLock(){
        isLocked = false;
    }

    public boolean isLocked() {
        return isLocked;
    }

    @Override
    public String toString() {
        return "ShowSeat{" +
                "id='" + id + '\'' +
                ", seatRow=" + seatRow +
                ", seatColumn=" + seatColumn +
                ", isLocked=" + isLocked +
                '}';
    }
}