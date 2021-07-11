package com.moviebooking.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@DisplayName("ShowSeatTest")
public class ShowSeatTest {
    private Show show;
    private Seat seat;

    @BeforeEach()
    void setup() throws ParseException {
        show = new Show("1",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120));
        seat = new Seat("1#1",1,1);
    }

    @Test
    @DisplayName("lock method Should Lock Seat")
    public void lock_ShouldLockSeat(){
        //Arrange
        ShowSeat showSeat = new ShowSeat("1#1#1",seat,show);
        //Act
        showSeat.lock();
        //Assert
        Assertions.assertTrue(showSeat.isLocked());
    }

    @Test
    @DisplayName("unLock method Should unLock Locked Seat")
    public void unlock_ShouldUnlockSeat(){
        //Arrange
        ShowSeat showSeat = new ShowSeat("1#1#1",seat,show);
        showSeat.lock();
        //Act
        showSeat.unlock();
        //Assert
        Assertions.assertFalse(showSeat.isLocked());
    }
}
