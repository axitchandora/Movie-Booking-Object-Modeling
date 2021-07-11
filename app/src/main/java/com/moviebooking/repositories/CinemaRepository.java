package com.moviebooking.repositories;

import com.moviebooking.entities.Cinema;

import java.util.HashMap;
import java.util.Map;

public class CinemaRepository implements  ICinemaRepository{
    private final Map<String, Cinema> cinemaMap;

    public CinemaRepository() {
        cinemaMap = new HashMap<>();
    }

    public CinemaRepository(Map<String, Cinema> cinemaMap) {
        this.cinemaMap = cinemaMap;
    }

    @Override
    public Cinema getCinemaById(String id) {
        return cinemaMap.get(id);
    }

    @Override
    public void saveCinema(Cinema cinema) {
        cinemaMap.put(cinema.getId(),cinema);
    }

    @Override
    public void updateCinema(Cinema cinema) {
        cinemaMap.put(cinema.getId(),cinema);
    }

}
