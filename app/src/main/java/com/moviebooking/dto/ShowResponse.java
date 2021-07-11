package com.moviebooking.dtos;

import java.util.Date;
import java.util.Objects;

public class ShowResponse {
    private String showId;
    private String movieTitle;
    private String cinemaName;
    private String screenName;
    private Date start;
    private Date end;

    public ShowResponse(String showId, String movieTitle, String cinemaName, String screenName, Date start, Date end) {
        this.showId = showId;
        this.movieTitle = movieTitle;
        this.cinemaName = cinemaName;
        this.screenName = screenName;
        this.start = start;
        this.end = end;
    }

    public String getShowId() {
        return showId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public String getScreenName() {
        return screenName;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShowResponse)) return false;
        ShowResponse that = (ShowResponse) o;
        return getShowId().equals(that.getShowId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShowId());
    }

    @Override
    public String toString() {
        return "GetShowResponse{" +
                "showId='" + showId + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", screenName='" + screenName + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
