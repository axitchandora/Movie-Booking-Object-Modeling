package com.moviebooking.repositories;

import com.moviebooking.entities.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@DisplayName("TicketRepositoryTest")
public class TicketRepositoryTest {
    private TicketRepository ticketRepository;

    @BeforeEach
    void setup() throws ParseException {
        Map<Integer, Ticket> ticketMap = new HashMap<>();
        Customer customer = new Customer("1","CustomerA","customerA@gmail.com");
        Show show  = new Show("1",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120));
        Seat seat1_2 = new Seat("1#2",1,2);
        Seat seat1_3 = new Seat("1#3",1,3);
        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );
        Ticket ticket = new Ticket(1,customer,show,seatList);
        ticketMap.put(1,ticket);
        ticketRepository = new TicketRepository(ticketMap,1);

    }

    @Test
    @DisplayName("getTicketById method Should Return Ticket Given Ticket Id")
    public void getTicketById_GivenTicketId_ShouldReturnTicket() throws ParseException {
        //Arrange
        Customer customer = new Customer("1","CustomerA","customerA@gmail.com");
        Show show  = new Show("1",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120));
        Seat seat1_2 = new Seat("1#2",1,2);
        Seat seat1_3 = new Seat("1#3",1,3);
        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );
        Ticket expectedTicket = new Ticket(1,customer,show,seatList);
        //Act
       Ticket actualTicket = ticketRepository.getTicketById(1);
        //Assert
        Assertions.assertEquals(expectedTicket,actualTicket);
    }

    @Test
    @DisplayName("getTicketById method Should Return null Given Ticket Id If Ticket not found")
    public void getTicketById_GivenTicketId_ShouldReturnNull(){
        //Arrange
        Integer ticketId = 2;
        //Act
        Ticket actualTicket = ticketRepository.getTicketById(ticketId);
        //Assert
        Assertions.assertNull(actualTicket);
    }

    @Test
    @DisplayName("saveTicket method Should Save Ticket")
    public void saveTicket_ShouldSaveTicket() throws ParseException {
        //Arrange
        Customer customer = new Customer("1","CustomerA","customerA@gmail.com");
        Show show  = new Show("2",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("2","ScreenB"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120));
        Seat seat1_2 = new Seat("1#2",1,2);
        Seat seat1_3 = new Seat("1#3",1,3);
        List<Seat> seatList = new ArrayList<>(
                List.of(seat1_2, seat1_3)
        );
        Ticket expectedTicket = new Ticket(2,customer,show,seatList);
        //Act
       ticketRepository.saveTicket(customer,show,seatList);

        //Assert
        Assertions.assertEquals(expectedTicket,ticketRepository.getTicketById(2));
    }

    @Test
    @DisplayName("removeTicket method Should Remove Ticket Given Ticket Id")
    public void removeTicket_ShouldRemoveTicket()  {
        //Arrange
        Integer ticketId = 1;
        //Act
         ticketRepository.removeTicket(1);

        //Assert
        Assertions.assertNull(ticketRepository.getTicketById(1));
    }
}
