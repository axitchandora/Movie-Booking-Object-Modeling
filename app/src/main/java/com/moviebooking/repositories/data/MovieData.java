package com.moviebooking.repositories.data;

import com.moviebooking.entities.Movie;
import com.moviebooking.repositories.IMovieRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MovieData implements IData{

    private final IMovieRepository iMovieRepository;

    public MovieData(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }

    @Override
    public void loadData(String dataPath, String delimiter) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(dataPath));
            String line = reader.readLine();
            while (line != null) {
                List<String> tokens = Arrays.asList(line.split(delimiter));
                addMovie(tokens.get(0),tokens.get(1),Integer.parseInt(tokens.get(2)));
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void addMovie(String movieId, String title, int durationInMins){
        iMovieRepository.saveMovie(new Movie(movieId,title,durationInMins));
    }

}
