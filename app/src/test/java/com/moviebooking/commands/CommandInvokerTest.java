package com.moviebooking.commands;

import com.moviebooking.exceptions.NoSuchCommandException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.mockito.Mockito.*;


@DisplayName("CommandInvokerTest")
@ExtendWith(MockitoExtension.class)
public class CommandInvokerTest {

    private CommandInvoker commandInvoker;

    @Mock
    BookTicketCommand bookTicketCommand;

    @Mock
    CancelTicketCommand cancelTicketCommand;

    @Mock
    DisplayMovieCommand displayMovieCommand;

    @Mock
    DisplayShowCommand displayShowCommand;

    @Mock
    DisplayShowSeatCommand displayShowSeatCommand;

    @BeforeEach
    void setup(){
        commandInvoker = new CommandInvoker();
        commandInvoker.register("DISPLAY-MOVIES",displayMovieCommand);
        commandInvoker.register("DISPLAY-SHOWS",displayShowCommand);
        commandInvoker.register("DISPLAY-SEATS",displayShowSeatCommand);
        commandInvoker.register("BOOK-TICKET",bookTicketCommand);
        commandInvoker.register("CANCEL-TICKET",cancelTicketCommand);
    }

    @Test
    @DisplayName("executeCommand method Should Execute Command Given CommandName and List of tokens")
    public void executeCommand_GivenNameAndTokens_ShouldExecuteCommand() throws NoSuchCommandException {
        //Act
        commandInvoker.executeCommand("DISPLAY-MOVIES", anyList());
        commandInvoker.executeCommand("DISPLAY-SHOWS", anyList());
        commandInvoker.executeCommand("DISPLAY-SEATS", anyList());
        commandInvoker.executeCommand("BOOK-TICKET", anyList());
        commandInvoker.executeCommand("CANCEL-TICKET", anyList());

        //Assert
        verify(displayMovieCommand).execute(anyList());
        verify(displayShowCommand).execute(anyList());
        verify(displayShowSeatCommand).execute(anyList());
        verify(bookTicketCommand).execute(anyList());
        verify(cancelTicketCommand).execute(anyList());

    }

    @Test
    @DisplayName("executeCommand method Should Throw Exception Given Incorrect CommandName and List of tokens")
    public void executeCommand_GivenIncorrectNameAndTokens_ShouldThrowException() {
        //Act and Assert
        Assertions.assertThrows(NoSuchCommandException.class,() -> commandInvoker.executeCommand("RANDOM-COMMAND",new ArrayList<String>()));
    }
}
