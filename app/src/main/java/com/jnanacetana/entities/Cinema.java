package com.jnanacetana.moviebooking.entities;


import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final String id;
    private final String name;
    private final List<Screen> screenList;

    public Cinema(String id, String name) {
        this.id = id;
        this.name = name;
        this.screenList = new ArrayList<>();
    }

    public void addScreen(Screen screen){
        screenList.add(screen);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Screen getScreenByName(String screenName){
        return screenList.stream().filter(screen -> screenName.equals(screen.getName()))
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cinema)) return false;
        Cinema cinema = (Cinema) o;
        return getId().equals(cinema.getId());
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", screenList=" + screenList +
                '}';
    }
}
