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

@DisplayName("ShowRepositoryTest")
public class ShowRepositoryTest {

    private ShowRepository showRepository;

    @BeforeEach
    void setup() throws ParseException {
        Map<String, Show> showMap = new HashMap<>();
        showMap.put("1",new Show("1",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120)));
        showMap.put("2",new Show("2",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("2","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("2","MovieB",120)));
        showMap.put("3",new Show("3",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("4","ScreenA"),
                new Cinema("2","CinemaB"),
                new Movie("1","MovieA",120)));
        showRepository = new ShowRepository(showMap);

    }

    @Test
    @DisplayName("getAllShowsForMovieName method Should Return List of Shows Given Movie Title")
    public void getAllShowsForMovieName_GivenMovieTitle_ShouldReturnShowList() throws ParseException {
        //Arrange
        List<Show> expectedShowsList = new ArrayList<>(
                List.of(
                        new Show("1",
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                                new Screen("1","ScreenA"),
                                new Cinema("1","CinemaA"),
                                new Movie("1","MovieA",120)),
                        new Show("3",
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                                new Screen("4","ScreenA"),
                                new Cinema("2","CinemaB"),
                                new Movie("1","MovieA",120)
                )
        )
        );
        //Act
        List<Show> actualShowsList = showRepository.getAllShowsForMovieName("MovieA");

        //Assert
       Assertions.assertTrue(expectedShowsList.size() == actualShowsList.size()
               && expectedShowsList.containsAll(actualShowsList)
               && actualShowsList.containsAll(expectedShowsList));
    }

    @Test
    @DisplayName("getAllShowsForMovieName method Should Return Empty List If Given Movie Title Not Present ")
    public void getAllShowsForMovieName_GivenMovieTitle_ShouldReturnEmptyListIfNotPresent() throws ParseException {
        //Arrange
        String movieTitle = "MovieC";
        //Act
        List<Show> actualShowsList = showRepository.getAllShowsForMovieName(movieTitle);

        //Assert
        Assertions.assertEquals(new ArrayList<>(),actualShowsList);
    }

    @Test
    @DisplayName("getShowById method Should Return Show Given Show Id")
    public void getShowById_GivenShowId_ShouldReturnShow() throws ParseException {
        //Arrange
        Show expectedShow = new Show("3",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("4","ScreenA"),
                new Cinema("2","CinemaB"),
                new Movie("1","MovieA",120));
        //Act
        Show actualShow = showRepository.getShowById("3");
        //Assert
        Assertions.assertEquals(expectedShow,actualShow);
    }

    @Test
    @DisplayName("getShowById  method Should Return null Given Show Id If Show not found")
    public void getShowById_GivenShowId_ShouldReturnNull(){
        //Arrange
        String showId = "4";
        //Act
        Show actualShow = showRepository.getShowById(showId);
        //Assert
        Assertions.assertNull(actualShow);
    }

    @Test
    @DisplayName("saveShow method Should Save Show")
    public void saveShow_ShouldSaveShow() throws ParseException {
        //Arrange
        Show expectedShow = new Show("4",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("5","ScreenA"),
                new Cinema("2","CinemaB"),
                new Movie("1","MovieA",120));
        //Act
      showRepository.saveShow(expectedShow);

        //Assert
        Assertions.assertEquals(expectedShow, showRepository.getShowById("4"));
    }

}
