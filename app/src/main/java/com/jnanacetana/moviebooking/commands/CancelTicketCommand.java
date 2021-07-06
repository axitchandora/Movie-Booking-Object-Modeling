package com.jnanacetana.moviebooking.commands;

import com.jnanacetana.moviebooking.exceptions.NoSuchTicketFoundException;
import com.jnanacetana.moviebooking.services.ITicketService;

import java.util.List;

public class CancelTicketCommand implements ICommand{

    private final ITicketService iTicketService;

    public CancelTicketCommand(ITicketService iTicketService) {
        this.iTicketService = iTicketService;
    }

    @Override
    public void execute(List<String> tokens) {
        Integer ticketId = Integer.parseInt(tokens.get(1));
        try {
            iTicketService.cancelTicket(ticketId);
            System.out.println("Cancellation Successful!");
            System.out.println();
        } catch (NoSuchTicketFoundException e) {
            System.out.println(e);
        }
    }
}
