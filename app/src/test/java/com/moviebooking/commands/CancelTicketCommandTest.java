package com.moviebooking.commands;

import com.moviebooking.exceptions.NoSuchTicketFoundException;
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

import static org.mockito.Mockito.*;

@DisplayName("CancelTicketCommandTest")
@ExtendWith(MockitoExtension.class)
public class CancelTicketCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    TicketService ticketServiceMock;

    @InjectMocks
    CancelTicketCommand cancelTicketCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("execute method Should Print Successful Message to Console")
    public void execute_ShouldPrintSuccessfulMessage() throws NoSuchTicketFoundException {
        //Arrange
        Integer ticketId = 1;

        String expectedOutput = "Cancellation Successful!";

        //Act
        cancelTicketCommand.execute(new ArrayList<>(List.of("CANCEL-TICKET",ticketId.toString())));

        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

        verify(ticketServiceMock).cancelTicket(ticketId);

    }

    @Test
    @DisplayName("execute method Should Print Error Message to Console")
    public void execute_ShouldPrintErrorMessage() throws NoSuchTicketFoundException {
        //Arrange
        Integer ticketId = 1;

        doThrow(new NoSuchTicketFoundException()).when(ticketServiceMock).cancelTicket(ticketId);

        String expectedOutput = "No Such Ticket found!";

        //Act
        cancelTicketCommand.execute(new ArrayList<>(List.of("CANCEL-TICKET",ticketId.toString())));

        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

        verify(ticketServiceMock).cancelTicket(ticketId);

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
