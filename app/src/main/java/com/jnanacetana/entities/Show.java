package com.jnanacetana.moviebooking.entities;


import java.util.Date;
import java.util.List;

public class Show {
    private final String id;
    private final Date start;
    private final Date end;
    private final Screen screen;
    private final Cinema cinema;
    private final Movie movie;
    private final List<ShowSeat> showSeatList;

    public Show(String id, Date start, Date end, Screen screen, Cinema cinema, Movie movie, List<ShowSeat> showSeatList) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.screen = screen;
        this.cinema = cinema;
        this.movie = movie;
        this.showSeatList = showSeatList;
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

    public List<ShowSeat> getShowSeatList() {
        return showSeatList;
    }

    public boolean checkSeatLocked(String seatId) {
        ShowSeat showSeat = showSeatList
                .stream()
                .filter(seat -> seatId.equals(seat.getId()))
                .findAny()
                .orElse(null);

        if (showSeat != null && showSeat.isLocked()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Show)) return false;
        Show show = (Show) o;
        return getId().equals(show.getId());
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
                ", showSeatList=" + showSeatList +
                '}';
    }
}
