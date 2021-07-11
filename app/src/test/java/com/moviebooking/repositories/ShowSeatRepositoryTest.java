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
public class ShowSeatRepositoryTest {
    private ShowSeatRepository showSeatRepository;

    @BeforeEach
    void setup() throws ParseException {

        Map<String, ShowSeat> showSeatMap = new HashMap<>();
        for(int i=1; i<=3; i++){
            for (int j = 1; j <= 8; j++) {
                for (int k = 1; k <= 8; k++) {
                    String id = i + "#" + j + "#" + k;
                    String seatId = j + "#" + k;
                    showSeatMap.put(id,new ShowSeat(id, new Seat(seatId,j,k),new Show(String.valueOf(i),
                            new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                            new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                            new Screen("1","ScreenA"),
                            new Cinema("1","CinemaA"),
                            new Movie("1","MovieA",120))));
                }
            }
        }
        showSeatRepository = new ShowSeatRepository(showSeatMap);
    }

    @Test
    @DisplayName("getShowSeatsByShowId Should Return List of ShowSeats Given Show Id")
    public void getShowSeatsByShowId_GivenShowId_ReturnShowSeatList() throws ParseException {
        //Arrange
        List<ShowSeat> expectedShowSeatList = new ArrayList<>();
        for (int j = 1; j <= 8; j++) {
            for (int k = 1; k <= 8; k++) {
                    String id = 1 + "#" + j + "#" + k;
                    String seatId = j + "#" + k;
                    expectedShowSeatList.add(new ShowSeat(id, new Seat(seatId,j,k),new Show(String.valueOf(1),
                            new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                            new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                            new Screen("1","ScreenA"),
                            new Cinema("1","CinemaA"),
                            new Movie("1","MovieA",120))));
            }
        }
        //Act
        List<ShowSeat> actualShowSeatList = showSeatRepository.getShowSeatsByShowId("1");
        //Assert
       Assertions.assertTrue(expectedShowSeatList.size() == actualShowSeatList.size()
               && expectedShowSeatList.containsAll(actualShowSeatList)
               && actualShowSeatList.containsAll(expectedShowSeatList));
    }


    @Test
    @DisplayName("getShowSeatsByShowId Should Return Empty List Given Show Id If Show is Not Present")
    public void getShowSeatsByShowId_GivenShowId_ReturnEmptyListIfShowNotPresent() throws ParseException {
        //Arrange
        List<ShowSeat> expectedShowSeatList = new ArrayList<>();

        //Act
        List<ShowSeat> actualShowSeatList = showSeatRepository.getShowSeatsByShowId("4");
        //Assert
        Assertions.assertEquals(expectedShowSeatList,actualShowSeatList);
    }

    @Test
    @DisplayName("getShowSeat method Should Return ShowSeat Given Show id and Seat Id")
    public void getShowSeat_GivenShowIdSeatId_ReturnShowSeat() throws ParseException {
        //Arrange
        ShowSeat expectedShowSeat = new ShowSeat("2#1#2",new Seat("1#2",1,2),new Show("2",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120)));
        //Act
        ShowSeat actualShowSeat = showSeatRepository.getShowSeat("2","1#2");
        //Assert
        Assertions.assertEquals(expectedShowSeat,actualShowSeat);
    }

    @Test
    @DisplayName("getShowSeat method Should Return Null Given Show id and Seat Id If ShowSeat Not Present")
    public void getShowSeat_GivenShowIdAndSeatId_ReturnNullIfShowSeatNotPresent(){
        //Arrange
        String actualShowId = "6";
        String actualStringId = "1#1";
        //Act
        ShowSeat actualShowSeat = showSeatRepository.getShowSeat(actualShowId,actualStringId);
        //Assert
        Assertions.assertNull(actualShowSeat);
    }

    @Test
    @DisplayName("addShowSeats method Should Add ShowSeats Given Show and list of Seats")
    public void addShowSeats_GivenShowAndSeatList_ShouldAddShowSeats() throws ParseException {
        //Arrange
        String showId = "6";
        List<Seat> seatList = new ArrayList<>();
        for (int j = 1; j <= 8; j++) {
            for (int k = 1; k <= 8; k++) {
                String seatId = j + "#" + k;
                seatList.add(new Seat(seatId,j,k));
            }
        }

        Show show = new Show(showId,
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120));

        List<ShowSeat> expectedShowSeatList = new ArrayList<>();
        for (int j = 1; j <= 8; j++) {
            for (int k = 1; k <= 8; k++) {
                String id = showId + "#" + j + "#" + k;
                String seatId = j + "#" + k;
                expectedShowSeatList.add(new ShowSeat(id, new Seat(seatId,j,k),new Show(showId,
                        new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                        new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                        new Screen("1","ScreenA"),
                        new Cinema("1","CinemaA"),
                        new Movie("1","MovieA",120))));
            }
        }

        //Act
        showSeatRepository.addShowSeats(show,seatList);
        List<ShowSeat> actualShowSeatList = showSeatRepository.getShowSeatsByShowId(showId);
        //Assert
        Assertions.assertTrue(expectedShowSeatList.size() == actualShowSeatList.size()
                && expectedShowSeatList.containsAll(actualShowSeatList)
                && actualShowSeatList.containsAll(expectedShowSeatList));

    }

    @Test
    @DisplayName("updateShowSeat Should Update ShowSeat")
    public void updateShowSeat_ShouldUpdateShowSeat() throws ParseException {
        //Arrange
        ShowSeat expectedShowSeat = new ShowSeat("2#1#2",new Seat("1#2",1,2),new Show("2",
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 13:30"),
                new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("20/07/2021 16:00"),
                new Screen("1","ScreenA"),
                new Cinema("1","CinemaA"),
                new Movie("1","MovieA",120)));

        //Act
        //Reserve the Seat
        expectedShowSeat.lock();
        showSeatRepository.updateShowSeat(expectedShowSeat);
        //Assert
        Assertions.assertEquals(expectedShowSeat,showSeatRepository.getShowSeat("2","1#2"));
    }
}
