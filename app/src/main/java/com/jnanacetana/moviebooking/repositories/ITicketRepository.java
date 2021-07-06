package com.jnanacetana.moviebooking.repositories;

import com.jnanacetana.moviebooking.entities.Customer;
import com.jnanacetana.moviebooking.entities.Seat;
import com.jnanacetana.moviebooking.entities.Show;
import com.jnanacetana.moviebooking.entities.Ticket;

import java.util.List;

public interface ITicketRepository {
    Ticket getTicketById(Integer id);
    Ticket saveTicket(Customer customer, Show show, List<Seat> seatList);
    void removeTicket(Integer id);
}
