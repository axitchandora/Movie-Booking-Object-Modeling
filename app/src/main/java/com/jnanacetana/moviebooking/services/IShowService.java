package com.jnanacetana.moviebooking.services;

import com.jnanacetana.moviebooking.dtos.ShowResponse;
import com.jnanacetana.moviebooking.entities.ShowSeat;

import java.util.List;

public interface IShowService {
    List<ShowResponse> getAllShowsByMovieTitle(String movieTitle);
    List<ShowSeat> getAllShowSeats(String showId);
}
