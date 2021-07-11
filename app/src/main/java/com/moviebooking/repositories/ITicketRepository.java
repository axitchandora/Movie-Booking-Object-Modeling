package com.moviebooking.repositories;

import com.moviebooking.entities.Customer;
import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.Ticket;

import java.util.List;

public interface ITicketRepository {
    Ticket getTicketById(Integer id);
    Ticket saveTicket(Customer customer, Show show, List<Seat> seatList);
    void removeTicket(Integer id);
}
