package com.moviebooking.entities;

import java.util.Objects;

public class ShowSeat {


    private final String id;
    private final Seat seat;
    private final Show show;
    private ShowSeatStatus showSeatStatus;

    public ShowSeat(String id, Seat seat, Show show) {
        this.id = id;
        this.seat = seat;
        this.show = show;
        this.showSeatStatus = ShowSeatStatus.UNRESERVED;
    }

    public void lock() {
        showSeatStatus = ShowSeatStatus.RESERVED;
    }

    public void unlock(){
        showSeatStatus = ShowSeatStatus.UNRESERVED;
    }

    public boolean isLocked() {
        return showSeatStatus == ShowSeatStatus.RESERVED;
    }

    public String getId() {
        return id;
    }

    public Seat getSeat() {
        return seat;
    }

    public  int getSeatRow(){
        return seat.getSeatRow();
    }

    public int getSeatColumn(){
        return seat.getSeatColumn();
    }

    public Show getShow() {
        return show;
    }

    public ShowSeatStatus getShowSeatStatus() {
        return showSeatStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowSeat)) return false;
        ShowSeat showSeat = (ShowSeat) o;
        return getId().equals(showSeat.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "ShowSeat{" +
                "id='" + id + '\'' +
                ", seat=" + seat +
                ", show=" + show +
                ", showSeatStatus=" + showSeatStatus +
                '}';
    }
}
