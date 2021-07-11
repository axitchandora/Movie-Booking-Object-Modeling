package com.moviebooking.commands;

import com.moviebooking.entities.Movie;
import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.ShowSeat;
import com.moviebooking.services.ShowService;
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

@DisplayName("DisplayShowSeatCommandTest")
@ExtendWith(MockitoExtension.class)
public class DisplayShowSeatCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @Mock
    Show show;

    @Mock
    ShowService showServiceMock;

    @InjectMocks
    DisplayShowSeatCommand displayShowSeatCommand;

    @Test
    @DisplayName("execute method Should Print List of ShowSeats to Console")
    public void execute_ShouldPrintShowSeatList(){
        //Arrange
        String showId = "1";
        List<ShowSeat> showSeatList = new ArrayList<>(
                List.of(
                        new ShowSeat("1#1#1",new Seat("1#1",1,1),show),
                        new ShowSeat("1#1#2",new Seat("1#2",1,2),show),
                        new ShowSeat("1#1#3",new Seat("1#3",1,3),show),
                        new ShowSeat("1#2#1",new Seat("2#1",2,1),show),
                        new ShowSeat("1#2#2",new Seat("2#2",2,2),show),
                        new ShowSeat("1#2#3",new Seat("2#3",2,3),show),
                        new ShowSeat("1#3#1",new Seat("3#1",3,1),show),
                        new ShowSeat("1#3#2",new Seat("3#2",3,2),show),
                        new ShowSeat("1#3#3",new Seat("3#3",3,3),show)
                )
        );


        when(showServiceMock.getAllShowSeats(showId)).thenReturn(showSeatList);

        String expectedOutput = "SeatRow - 1\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 1\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 2\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 1\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 2\n" +
                "Status - UNRESERVED\n" +
                "\n" +
                "SeatRow - 3\n" +
                "SeatColumn - 3\n" +
                "Status - UNRESERVED";

        //Act
        displayShowSeatCommand.execute(new ArrayList<>(List.of("DISPLAY-SEATS",showId)));

        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

        verify(showServiceMock).getAllShowSeats(showId);

    }


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
