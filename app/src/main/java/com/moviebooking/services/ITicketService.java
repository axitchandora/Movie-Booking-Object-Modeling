package com.moviebooking.services;

import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Ticket;
import com.moviebooking.exceptions.NoSuchTicketFoundException;
import com.moviebooking.exceptions.SeatNotAvailableException;

import java.util.List;

public interface ITicketService {

    Ticket bookTicket(String customerId, String showId, List<Seat> seatList) throws SeatNotAvailableException;
    void cancelTicket(Integer ticketId) throws NoSuchTicketFoundException;
}
