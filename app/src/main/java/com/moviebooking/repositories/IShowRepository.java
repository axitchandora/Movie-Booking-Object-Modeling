package com.moviebooking.repositories;

import com.moviebooking.entities.Show;

import java.util.List;

public interface IShowRepository {
    List<Show> getAllShowsForMovieName(String title);
    Show getShowById(String id);
    void saveShow(Show show);
}
