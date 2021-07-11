package com.moviebooking.services;

import com.moviebooking.entities.Movie;
import com.moviebooking.repositories.IMovieRepository;

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
