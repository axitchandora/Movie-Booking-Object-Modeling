package com.moviebooking.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CinemaTest")
public class CinemaTest {

    @Test
    @DisplayName("getScreenByName method Should Return Screen Given ScreenName")
    public void getScreenByName_GivenScreenName_ShouldReturnScreen(){
        //Arrange
        Cinema cinema = new Cinema("1","CinemaA");
        cinema.addScreen(new Screen("1","ScreenA"));
        cinema.addScreen(new Screen("2","ScreenB"));
        cinema.addScreen(new Screen("3","ScreenC"));

        Screen actualScreen = new Screen("2","ScreenB");

        //Act
        Screen expectedScreen = cinema.getScreenByName("ScreenB");

        //Assert
        Assertions.assertEquals(expectedScreen,actualScreen);
    }

    @Test
    @DisplayName("getScreenByName method Should Return Null Given ScreenName Not Present In Cinema")
    public void getScreenByName_GivenScreenNameNotPresentInCinema_ShouldReturnNull(){
        //Arrange
        Cinema cinema = new Cinema("1","CinemaA");
        cinema.addScreen(new Screen("1","ScreenA"));
        cinema.addScreen(new Screen("2","ScreenB"));
        cinema.addScreen(new Screen("3","ScreenC"));


        //Act
        Screen expectedScreen = cinema.getScreenByName("ScreenD");

        //Assert
        Assertions.assertNull(expectedScreen);
    }
}
