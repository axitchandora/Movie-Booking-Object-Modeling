package com.moviebooking.services;

import com.moviebooking.dtos.ShowResponse;
import com.moviebooking.entities.ShowSeat;

import java.util.List;

public interface IShowService {
    List<ShowResponse> getAllShowsByMovieTitle(String movieTitle);
    List<ShowSeat> getAllShowSeats(String showId);
}
