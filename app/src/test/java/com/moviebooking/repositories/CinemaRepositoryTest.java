package com.moviebooking.repositories;

import com.moviebooking.entities.Cinema;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@DisplayName("CinemaRepositoryTest")
public class CinemaRepositoryTest {

    private CinemaRepository cinemaRepository;

    @BeforeEach
    void setup(){
        Map<String, Cinema> cinemaMap = new HashMap<>();
        cinemaMap.put("1",new Cinema("1","CinemaA"));
        cinemaMap.put("2",new Cinema("2","CinemaB"));
        cinemaMap.put("3",new Cinema("3","CinemaC"));
        cinemaRepository = new CinemaRepository(cinemaMap);
    }

    @Test
    @DisplayName("getCinemaById method Should Return Cinema Given Cinema Id")
    public void getCinemaById_GivenCinemaId_ShouldReturnCinema(){
        //Arrange
        Cinema expectedCinema = new Cinema("3","CinemaC");
        //Act
        Cinema actualCinema = cinemaRepository.getCinemaById("3");
        //Assert
        Assertions.assertEquals(expectedCinema,actualCinema);
    }

    @Test
    @DisplayName("getCinemaById method Should Return null Given Cinema Id If Cinema not found")
    public void getCinemaById_GivenCinemaId_ShouldReturnNull(){
        //Arrange
        String cinemaId = "4";
        //Act
        Cinema actualCinema = cinemaRepository.getCinemaById(cinemaId);
        //Assert
        Assertions.assertNull(actualCinema);
    }

    @Test
    @DisplayName("saveCinema method Should Save Cinema")
    public void saveCinema_ShouldSaveCinema(){
        //Arrange
        Cinema expectedCinema = new Cinema("4","CinemaD");
        //Act
        cinemaRepository.saveCinema(expectedCinema);

        //Assert
        Assertions.assertEquals(expectedCinema,cinemaRepository.getCinemaById("4"));
    }

    @Test
    @DisplayName("updateCinema method Should Update Cinema")
    public void updateCinema_ShouldUpdateCinema(){
        //Arrange
        Cinema expectedCinema = new Cinema("3","CinemaD");
        //Act
        cinemaRepository.updateCinema(expectedCinema);

        //Assert
        Assertions.assertEquals(expectedCinema,cinemaRepository.getCinemaById("3"));
    }


}
