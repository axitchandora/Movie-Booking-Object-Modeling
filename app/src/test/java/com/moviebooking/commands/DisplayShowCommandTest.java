package com.moviebooking.commands;

import com.moviebooking.dtos.ShowResponse;
import com.moviebooking.services.ShowService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("DisplayShowCommandTest")
@ExtendWith(MockitoExtension.class)
public class DisplayShowCommandTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Mock
    ShowService showServiceMock;

    @InjectMocks
    DisplayShowCommand displayShowCommand;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("execute method Should Print List of Shows to Console")
    public void execute_ShouldPrintShowList() throws ParseException {
        //Arrange
        String movieTitle = "MovieA";
        List<ShowResponse> showResponseList = new ArrayList<>();

        Date start = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 10:30");
        Date end = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:00");

        showResponseList.add(new ShowResponse("1","MovieA","CinemaA", "ScreenA",start,end));
        showResponseList.add(new ShowResponse("2","MovieA","CinemaA", "ScreenB",start,end));
        showResponseList.add(new ShowResponse("3","MovieA","CinemaA", "ScreenC",start,end));

        when(showServiceMock.getAllShowsByMovieTitle(movieTitle)).thenReturn(showResponseList);

        String expectedOutput = "Show ID - 1\n" +
                "Title - MovieA\n" +
                "Start - 20/07/2021 10:30\n" +
                "End - 20/07/2021 13:00\n" +
                "Cinema - CinemaA\n" +
                "Screen - ScreenA\n" +
                "\n" +
                "Show ID - 2\n" +
                "Title - MovieA\n" +
                "Start - 20/07/2021 10:30\n" +
                "End - 20/07/2021 13:00\n" +
                "Cinema - CinemaA\n" +
                "Screen - ScreenB\n" +
                "\n" +
                "Show ID - 3\n" +
                "Title - MovieA\n" +
                "Start - 20/07/2021 10:30\n" +
                "End - 20/07/2021 13:00\n" +
                "Cinema - CinemaA\n" +
                "Screen - ScreenC";

        //Act
        displayShowCommand.execute(new ArrayList<>(List.of("DISPLAY-SHOWS",movieTitle)));

        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

        verify(showServiceMock).getAllShowsByMovieTitle(movieTitle);

    }

    @Test
    @DisplayName("execute Should Print Empty to Console If No Shows")
    public void execute_ShouldPrintEmpty(){
        //Arrange
        String movieTitle = "MovieA";
        List<ShowResponse> showResponseList = new ArrayList<>();

        when(showServiceMock.getAllShowsByMovieTitle(movieTitle)).thenReturn(showResponseList);

        String actualOutput = "";

        //Act
        displayShowCommand.execute(new ArrayList<>(List.of("DISPLAY-MOVIES",movieTitle)));

        //Assert
        Assertions.assertEquals(actualOutput,outputStreamCaptor.toString().trim());

        verify(showServiceMock).getAllShowsByMovieTitle(movieTitle);

    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
