package com.moviebooking.services;

import com.moviebooking.dtos.ShowResponse;
import com.moviebooking.entities.*;
import com.moviebooking.repositories.IShowRepository;
import com.moviebooking.repositories.IShowSeatRepository;

import java.util.ArrayList;
import java.util.List;

public class ShowService implements IShowService{
    private final IShowRepository iShowRepository;
    private final IShowSeatRepository iShowSeatRepository;

    public ShowService(IShowRepository iShowRepository, IShowSeatRepository iShowSeatRepository) {
        this.iShowRepository = iShowRepository;
        this.iShowSeatRepository = iShowSeatRepository;
    }

    public List<ShowResponse> getAllShowsByMovieTitle(String movieTitle){
        List<ShowResponse> getShowResponseList = new ArrayList<>();
        List<Show> showList = iShowRepository.getAllShowsForMovieName(movieTitle);
        for(Show show: showList){

            getShowResponseList.add(new ShowResponse(
                    show.getId(),
                    show.getMovieTitle(),
                    show.getCinemaName(),
                    show.getScreenName(),
                    show.getStart(),
                    show.getEnd()));
        }
        return getShowResponseList;
    }

    @Override
    public List<ShowSeat> getAllShowSeats(String showId) {
       return iShowSeatRepository.getShowSeatsByShowId(showId);
    }

}
