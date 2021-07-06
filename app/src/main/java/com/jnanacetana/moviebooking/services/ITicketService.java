package com.jnanacetana.moviebooking.services;

import com.jnanacetana.moviebooking.entities.Seat;
import com.jnanacetana.moviebooking.entities.Ticket;
import com.jnanacetana.moviebooking.exceptions.NoSuchTicketFoundException;
import com.jnanacetana.moviebooking.exceptions.SeatNotAvailableException;

import java.util.List;

public interface ITicketService {

    Ticket bookTicket(String customerId, String showId, List<Seat> seatList) throws SeatNotAvailableException;
    void cancelTicket(Integer ticketId) throws NoSuchTicketFoundException;
}
