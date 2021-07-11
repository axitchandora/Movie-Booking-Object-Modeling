package com.moviebooking.commands;

import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Ticket;
import com.moviebooking.exceptions.SeatNotAvailableException;
import com.moviebooking.services.TicketService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("BookTicketCommandTest")
@ExtendWith(MockitoExtension.class)
public class BookTicketCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    Ticket ticket;

    @Mock
    TicketService ticketServiceMock;

    @InjectMocks
    BookTicketCommand bookTicketCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("execute method Should Print Ticket Id to Console")
    public void execute_ShouldPrintTicketId() throws SeatNotAvailableException {
        //Arrange
        String customerId = "1";
        String showId = "1";
        Seat seat1_2 = new Seat("1#2",1,2);
        Seat seat1_3 = new Seat("1#3",1,3);
        List<Seat> seatList = new ArrayList<>(List.of(seat1_2,seat1_3));

        when(ticketServiceMock.bookTicket(customerId,showId,seatList)).thenReturn(ticket);
        when(ticket.getId()).thenReturn(1);

        String expectedOutput = "Ticket ID - 1";

        //Act
        bookTicketCommand.execute(new ArrayList<>(List.of("BOOK-TICKET",customerId,showId,seat1_2.getId(),seat1_3.getId())));

        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

        verify(ticketServiceMock).bookTicket(customerId,showId,seatList);

    }

    @Test
    @DisplayName("execute method Should Print Error Message to Console")
    public void execute_ShouldPrintErrorMessage() throws SeatNotAvailableException {
        //Arrange
        String customerId = "1";
        String showId = "1";
        Seat seat1_2 = new Seat("1#2",1,2);
        Seat seat1_3 = new Seat("1#3",1,3);
        List<Seat> seatList = new ArrayList<>(List.of(seat1_2,seat1_3));

        when(ticketServiceMock.bookTicket(customerId,showId,seatList)).thenThrow(new SeatNotAvailableException());

        String expectedOutput = "Some Seats are already Booked! Please try booking available seats!";

        //Act
        bookTicketCommand.execute(new ArrayList<>(List.of("BOOK-TICKET",customerId,showId,seat1_2.getId(),seat1_3.getId())));

        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

        verify(ticketServiceMock).bookTicket(customerId,showId,seatList);

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
