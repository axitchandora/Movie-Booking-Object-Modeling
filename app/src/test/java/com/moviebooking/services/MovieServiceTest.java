package com.moviebooking.services;

import com.moviebooking.entities.Movie;
import com.moviebooking.repositories.MovieRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("MovieServiceTest")
@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    MovieRepository movieRepositoryMock;

    @InjectMocks
    MovieService movieService;

    @Test
    @DisplayName("getAllMovies method Should Return All Movies")
    public void getAllMovies_ShouldReturnAllMovies(){
        //Arrange
        List<Movie> actualMovieList = new ArrayList<>();
        actualMovieList.add(new Movie("1","MovieA",120));
        actualMovieList.add(new Movie("2","MovieB",150));
        actualMovieList.add(new Movie("3","MovieC",180));

        when(movieRepositoryMock.getAllMovies()).thenReturn(actualMovieList);

        //Act
        List<Movie> expectedMovieList = movieService.getAllMovies();

        //Assert
        Assertions.assertEquals(expectedMovieList,actualMovieList);

        verify(movieRepositoryMock).getAllMovies();

    }

    @Test
    @DisplayName("getAllMovies method Should Return Empty List if No Movies")
    public void getAllMovies_ShouldReturnEmptyListIfNoMovies(){
        //Arrange
        List<Movie> actualMovieList = new ArrayList<>();

        when(movieRepositoryMock.getAllMovies()).thenReturn(actualMovieList);

        //Act
        List<Movie> expectedMovieList = movieService.getAllMovies();

        //Assert
        Assertions.assertEquals(expectedMovieList,actualMovieList);

        verify(movieRepositoryMock).getAllMovies();

    }
}
