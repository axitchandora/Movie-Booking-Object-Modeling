package com.jnanacetana.moviebooking.repositories;

import com.jnanacetana.moviebooking.entities.Movie;

import java.util.List;

public interface IMovieRepository {
    List<Movie> getAllMovies();
    void saveMovie(Movie movie);
    Movie getMovieById(String id);
}
