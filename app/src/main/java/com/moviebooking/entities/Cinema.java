package com.moviebooking.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cinema {
    private final String id;
    private final String name;
    private final Map<String,Screen> screenMap;

    public Cinema(String id, String name) {
        this.id = id;
        this.name = name;
        this.screenMap = new HashMap<>();
    }

    public void addScreen(Screen screen){
        screenMap.put(screen.getId(),screen);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Screen getScreenByName(String screenName){
        return screenMap.values()
                .stream().filter(screen -> screenName.equals(screen.getName()))
                .findAny()
                .orElse(null);
    }

    public Screen getScreenById(String screenId){
        return screenMap.get(screenId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cinema)) return false;
        Cinema cinema = (Cinema) o;
        return getId().equals(cinema.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", screenMap=" + screenMap +
                '}';
    }
}
