package com.moviebooking.services;

import com.moviebooking.entities.*;
import com.moviebooking.exceptions.NoSuchTicketFoundException;
import com.moviebooking.exceptions.SeatNotAvailableException;
import com.moviebooking.repositories.ICustomerRepository;
import com.moviebooking.repositories.IShowRepository;
import com.moviebooking.repositories.IShowSeatRepository;
import com.moviebooking.repositories.ITicketRepository;

import java.util.List;

public class TicketService implements  ITicketService{

    private final ICustomerRepository iCustomerRepository;
    private final IShowSeatRepository iShowSeatRepository;
    private final IShowRepository iShowRepository;
    private final ITicketRepository iTicketRepository;

    public TicketService(ICustomerRepository iCustomerRepository, IShowSeatRepository iShowSeatRepository, IShowRepository iShowRepository, ITicketRepository iTicketRepository) {
        this.iCustomerRepository = iCustomerRepository;
        this.iShowSeatRepository = iShowSeatRepository;
        this.iShowRepository = iShowRepository;
        this.iTicketRepository = iTicketRepository;
    }

    @Override
    public Ticket bookTicket(String customerId, String showId, List<Seat> seatList) throws SeatNotAvailableException {
        Customer customer = iCustomerRepository.getCustomerById(customerId);
        Show show = iShowRepository.getShowById(showId);
        for(Seat seat : seatList){
            ShowSeat showSeat = iShowSeatRepository.getShowSeat(showId,seat.getId());
            if(showSeat.isLocked()){
                throw new SeatNotAvailableException();
            }
        }
        for(Seat seat : seatList){
            ShowSeat showSeat = iShowSeatRepository.getShowSeat(showId,seat.getId());
            showSeat.lock();
            iShowSeatRepository.updateShowSeat(showSeat);
        }

        Ticket ticket = iTicketRepository.saveTicket(customer,show,seatList);
        return ticket;
    }

    @Override
    public void cancelTicket(Integer ticketId) throws NoSuchTicketFoundException {
        Ticket ticket = iTicketRepository.getTicketById(ticketId);
        if(ticket == null){
            throw new NoSuchTicketFoundException();
        }
        List<Seat> seatList = ticket.getSeatList();
        for(Seat seat : seatList){
            ShowSeat showSeat = iShowSeatRepository.getShowSeat(ticket.getShowId(),seat.getId());
            showSeat.unlock();
            iShowSeatRepository.updateShowSeat(showSeat);
        }
        iTicketRepository.removeTicket(ticketId);
    }
}
