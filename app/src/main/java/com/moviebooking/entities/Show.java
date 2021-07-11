package com.moviebooking.entities;


import java.util.Date;
import java.util.Objects;

public class Show {
    private final String id;
    private final Date start;
    private final Date end;
    private final Screen screen;
    private final Cinema cinema;
    private final Movie movie;

    public Show(String id, Date start, Date end, Screen screen, Cinema cinema, Movie movie) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.screen = screen;
        this.cinema = cinema;
        this.movie = movie;
    }

    public String getId() {
        return id;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getScreenName() {
        return screen.getName();
    }

    public String getCinemaName() {
        return cinema.getName();
    }

    public String getMovieTitle() {
        return movie.getTitle();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Show)) return false;
        Show show = (Show) o;
        return getId().equals(show.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Show{" +
                "id='" + id + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", screen=" + screen +
                ", cinema=" + cinema +
                ", movie=" + movie +
                '}';
    }
}
