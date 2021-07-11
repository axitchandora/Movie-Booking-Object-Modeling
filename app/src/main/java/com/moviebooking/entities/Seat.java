package com.moviebooking.entities;

import java.util.Objects;

public class Seat {

    private final String id;
    private final int seatRow;
    private final int seatColumn;

    public Seat(String id, int seatRow, int seatColumn) {
        this.seatRow = seatRow;
        this.seatColumn = seatColumn;
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public int getSeatColumn() {
        return seatColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat seat = (Seat) o;
        return getId().equals(seat.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id='" + id + '\'' +
                ", seatRow=" + seatRow +
                ", seatColumn=" + seatColumn +
                '}';
    }
}
