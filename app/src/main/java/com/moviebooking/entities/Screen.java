package com.moviebooking.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Screen {
    private final String id;
    private final String name;
    private final List<Seat> seatList;

    public Screen(String id, String name) {
        this.id = id;
        this.name = name;
        this.seatList = new ArrayList<>();
    }

    public void addSeat(Seat seat){
        seatList.add(seat);
    }


    public List<Seat> getSeatList() {
        return seatList;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Screen)) return false;
        Screen screen = (Screen) o;
        return getId().equals(screen.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", seatList=" + seatList +
                '}';
    }
}
