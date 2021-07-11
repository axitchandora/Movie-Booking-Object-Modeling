package com.moviebooking.services;

import com.moviebooking.dtos.ShowResponse;
import com.moviebooking.entities.*;
import com.moviebooking.repositories.ShowRepository;
import com.moviebooking.repositories.ShowSeatRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("ShowServiceTest")
@ExtendWith(MockitoExtension.class)
public class ShowServiceTest {

    @Mock
    ShowRepository showRepositoryMock;

    @Mock
    ShowSeatRepository showSeatRepositoryMock;

    @InjectMocks
    ShowService showService;

    @Test
    @DisplayName("getAllShowsByMovieTitle method Should Return ShowResponse List Given Movie Title")
    public void getAllShowsByMovieTitle_GivenMovieTitle_ShouldReturnShowResponseList() throws ParseException {
        //Arrange

        List<Show> showList = new ArrayList<>(
                List.of(
                        new Show("1",
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                                new Screen("1","ScreenA"),
                                new Cinema("1","CinemaA"),
                                new Movie("1","MovieA",120)),
                        new Show("3",
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 12:30"),
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 15:00"),
                                new Screen("4","ScreenA"),
                                new Cinema("2","CinemaB"),
                                new Movie("1","MovieA",120))
                        )
        );

        List<ShowResponse> actualShowResponseList = new ArrayList<>(
                List.of(
                       new ShowResponse(
                               "1",
                               "MovieA",
                               "CinemaA",
                               "ScreenA",
                               new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                               new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"))
                        ,
                        new ShowResponse(
                                "3",
                                "MovieA",
                                "CinemaB",
                                "ScreenA",
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 12:30"),
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 15:00")
                        )
                )
        );

        when(showRepositoryMock.getAllShowsForMovieName("MovieA")).thenReturn(showList);

        //Act
        List<ShowResponse> expectedShowList = showService.getAllShowsByMovieTitle("MovieA");

        //Assert
        Assertions.assertEquals(expectedShowList,actualShowResponseList);

        verify(showRepositoryMock).getAllShowsForMovieName("MovieA");
    }

    @Test
    @DisplayName("getAllShowsByMovieTitle method Should Return Empty ShowResponse List If No Movies Found For Given Movie Title")
    public void getAllShowsByMovieTitle_GivenMovieTitle_ShouldReturnEmptyShowResponseListIfNoMoviesFound() throws ParseException {
        //Arrange
        List<Show> showList = new ArrayList<>();

        List<ShowResponse> actualShowResponseList = new ArrayList<>();

        when(showRepositoryMock.getAllShowsForMovieName("MovieA")).thenReturn(showList);

        //Act
        List<ShowResponse> expectedShowList = showService.getAllShowsByMovieTitle("MovieA");

        //Assert
        Assertions.assertEquals(expectedShowList,actualShowResponseList);

        verify(showRepositoryMock).getAllShowsForMovieName("MovieA");
    }

    @Test
    @DisplayName("getAllShowSeats method Should Return ShowSeat List Given Show Id")
    public void getAllShowSeats_GivenShowId_ShouldReturnShowSeatList() throws ParseException {
        //Arrange
        Show show  = new Show("1",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120));

        List<ShowSeat> actualShowSeatList = new ArrayList<>(
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

        when(showSeatRepositoryMock.getShowSeatsByShowId("1")).thenReturn(actualShowSeatList);

        //Act
        List<ShowSeat> expectedShowSeatList = showService.getAllShowSeats("1");

        //Assert
        Assertions.assertEquals(expectedShowSeatList,actualShowSeatList);

        verify(showSeatRepositoryMock).getShowSeatsByShowId("1");
    }
}
