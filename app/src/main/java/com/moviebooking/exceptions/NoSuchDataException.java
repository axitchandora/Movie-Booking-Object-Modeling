package com.moviebooking.exceptions;

public class NoSuchDataException extends Exception {
    @Override
    public String toString() {
        return "No such Data Found!";
    }
}
