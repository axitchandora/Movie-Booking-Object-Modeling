package com.jnanacetana.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@DisplayName("ShowTest")
public class ShowTest {

    @Test
    @DisplayName("checkSeatLocked method Should Return True Given Seat Id If Seat is Locked")
    public void checkSeatLocked_GivenSeatId_ShouldReturnTrueIfLocked(){
        //Arrange
        ShowSeat showSeat1 = new ShowSeat("1#1",1,1);
        showSeat1.lock();
        ShowSeat showSeat2 = new ShowSeat("1#2",1,2);
        ShowSeat[] showSeats = { showSeat1, showSeat2 };
        Show show = new Show("1",
                new Date(),
                new Date(),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120),
                Arrays.asList(showSeats));

        //Act
        boolean expectedResult = show.checkSeatLocked("1#1");

        //Assert
        Assertions.assertTrue(expectedResult);

    }

    @Test
    @DisplayName("checkSeatLocked method Should Return False Given Seat Id If Seat is Not Locked")
    public void checkSeatLocked_GivenSeatId_ShouldReturnFalseIfNotLocked(){
        //Arrange
        ShowSeat showSeat1 = new ShowSeat("1#1",1,1);
        showSeat1.lock();
        ShowSeat showSeat2 = new ShowSeat("1#2",1,2);
        ShowSeat[] showSeats = { showSeat1, showSeat2 };
        Show show = new Show("1",
                new Date(),
                new Date(),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120),
                Arrays.asList(showSeats));

        //Act
        boolean expectedResult = show.checkSeatLocked("1#2");

        //Assert
        Assertions.assertFalse(expectedResult);

    }
}
