package com.moviebooking.entities;

import java.util.List;
import java.util.Objects;

public class Ticket {
    private final Integer id;
    private final Customer customer;
    private final Show show;
    private final List<Seat> seatList;

    public Ticket(Integer id, Customer customer, Show show, List<Seat> seatList) {
        this.id = id;
        this.customer = customer;
        this.show = show;
        this.seatList = seatList;
    }

    public Integer getId() {
        return id;
    }

    public String getCustomerName(){
        return customer.getName();
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public String getShowId(){
        return show.getId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return getId().equals(ticket.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", customer=" + customer +
                ", show=" + show +
                ", seatList=" + seatList +
                '}';
    }
}
