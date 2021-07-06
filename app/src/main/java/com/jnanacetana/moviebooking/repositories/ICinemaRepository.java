package com.jnanacetana.moviebooking.repositories;

import com.jnanacetana.moviebooking.entities.Cinema;

public interface ICinemaRepository {
    Cinema getCinemaById(String id);
    void saveCinema(Cinema cinema);
    void updateCinema(Cinema cinema);
}
