package com.jnanacetana.moviebooking.repositories;

import com.jnanacetana.moviebooking.entities.Seat;
import com.jnanacetana.moviebooking.entities.Show;
import com.jnanacetana.moviebooking.entities.ShowSeat;

import java.util.List;

public interface IShowSeatRepository {
    List<ShowSeat> getShowSeatsByShowId(String id);
    ShowSeat getShowSeat(String showId, String seatId);
    void addShowSeats(Show show, List<Seat> seatList);
    void updateShowSeat(ShowSeat showSeat);
}
