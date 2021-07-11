package com.moviebooking.repositories;

import com.moviebooking.entities.Seat;
import com.moviebooking.entities.Show;
import com.moviebooking.entities.ShowSeat;

import java.util.List;

public interface IShowSeatRepository {
    List<ShowSeat> getShowSeatsByShowId(String id);
    ShowSeat getShowSeat(String showId, String seatId);
    void addShowSeats(Show show, List<Seat> seatList);
    void updateShowSeat(ShowSeat showSeat);
}
