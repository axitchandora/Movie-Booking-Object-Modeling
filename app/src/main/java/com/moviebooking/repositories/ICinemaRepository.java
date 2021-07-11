package com.moviebooking.repositories;

import com.moviebooking.entities.Cinema;

public interface ICinemaRepository {
    Cinema getCinemaById(String id);
    void saveCinema(Cinema cinema);
    void updateCinema(Cinema cinema);
}
