package com.moviebooking.commands;

import com.moviebooking.entities.Movie;
import com.moviebooking.services.IMovieService;

import java.util.List;

public class DisplayMovieCommand implements ICommand{

    private final IMovieService iMovieService;

    public DisplayMovieCommand(IMovieService iMovieService) {
        this.iMovieService = iMovieService;
    }

    @Override
    public void execute(List<String> tokens) {
       List<Movie> movieList =  iMovieService.getAllMovies();
       movieList.stream()
               .forEach(movie -> {
                   System.out.println("Movie ID - " +movie.getId());
                   System.out.println("Title - "+movie.getTitle());
                   System.out.println("Duration - "+movie.getDurationInMins());
                   System.out.println();
               });
    }
}
