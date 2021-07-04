package com.jnanacetana.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ShowSeatTest")
public class ShowSeatTest {

    @Test
    @DisplayName("lock method Should Lock Seat")
    public void lock_ShouldLockSeat(){
        //Arrange
        ShowSeat showSeat = new ShowSeat("1#1",1,1);
        //Act
        showSeat.lock();
        //Assert
        Assertions.assertTrue(showSeat.isLocked());
    }

    @Test
    @DisplayName("unLock method Should unLock Locked Seat")
    public void unlock_ShouldUnlockSeat(){
        //Arrange
        ShowSeat showSeat = new ShowSeat("1#1",1,1);
        showSeat.lock();
        //Act
        showSeat.unLock();
        //Assert
        Assertions.assertFalse(showSeat.isLocked());
    }
}
