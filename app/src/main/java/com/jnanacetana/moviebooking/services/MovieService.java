package com.jnanacetana.moviebooking.services;

import com.jnanacetana.moviebooking.entities.Movie;
import com.jnanacetana.moviebooking.repositories.IMovieRepository;

import java.util.List;

public class MovieService implements IMovieService{
    private final IMovieRepository iMovieRepository;

    public MovieService(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return iMovieRepository.getAllMovies();
    }
}
