package com.moviebooking.repositories;

import com.moviebooking.entities.Customer;
import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.Ticket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketRepository implements ITicketRepository{

    private static Integer counter = 0;
    private final Map<Integer,Ticket> ticketMap;

    public TicketRepository(){
        ticketMap = new HashMap<>();
    }

    public TicketRepository(Map<Integer, Ticket> ticketMap, Integer counter) {
        this.ticketMap = ticketMap;
        TicketRepository.counter = counter;
    }

    @Override
    public Ticket getTicketById(Integer id) {
        return ticketMap.get(id);
    }


    @Override
    public void removeTicket(Integer id) {
        ticketMap.remove(id);
    }

    @Override
    public Ticket saveTicket(Customer customer, Show show, List<Seat> seatList) {
        counter++;
        Ticket ticket = new Ticket(counter,customer,show,seatList);
        ticketMap.put(counter,ticket);
        return ticket;
    }
}
