package com.moviebooking.commands;

import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Ticket;
import com.moviebooking.exceptions.SeatNotAvailableException;
import com.moviebooking.services.ITicketService;

import java.util.ArrayList;
import java.util.List;

public class BookTicketCommand implements ICommand{

    private final ITicketService iTicketService;

    public BookTicketCommand(ITicketService iTicketService) {
        this.iTicketService = iTicketService;
    }

    @Override
    public void execute(List<String> tokens) {
        String showId = tokens.get(2);
        String customerName = tokens.get(1);
        List<Seat> seatList = new ArrayList<>();
        for(int i=3; i< tokens.size(); i++){
           String[] words = tokens.get(i).split("#");
           Seat seat = new Seat(tokens.get(i),Integer.parseInt(words[0]),Integer.parseInt(words[1]));
           seatList.add(seat);
        }
        try {
            Ticket ticket = iTicketService.bookTicket(customerName,showId,seatList);
            System.out.println("Ticket ID - "+ticket.getId());
            System.out.println();
        } catch (SeatNotAvailableException e) {
            System.out.println(e);
        }
    }
}
