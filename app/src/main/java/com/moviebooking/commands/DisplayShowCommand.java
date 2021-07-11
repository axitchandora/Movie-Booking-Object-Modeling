package com.moviebooking.commands;

import com.moviebooking.dtos.ShowResponse;
import com.moviebooking.services.IShowService;

import java.text.SimpleDateFormat;
import java.util.List;

public class DisplayShowCommand implements ICommand{

    private final IShowService iShowService;

    public DisplayShowCommand(IShowService iShowService) {
        this.iShowService = iShowService;
    }

    @Override
    public void execute(List<String> tokens) {
        String movieTitle = tokens.get(1);
        List<ShowResponse> showResponseList = iShowService.getAllShowsByMovieTitle(movieTitle);
        showResponseList.stream()
                .forEach(showResponse -> {
                    System.out.println("Show ID - "+showResponse.getShowId());
                    System.out.println("Title - "+showResponse.getMovieTitle());
                    System.out.println("Start - "+ new SimpleDateFormat("dd/MM/yyyy HH:mm").format(showResponse.getStart()));
                    System.out.println("End - "+ new SimpleDateFormat("dd/MM/yyyy HH:mm").format(showResponse.getEnd()));
                    System.out.println("Cinema - "+showResponse.getCinemaName());
                    System.out.println("Screen - "+showResponse.getScreenName());
                    System.out.println();
                });
    }
}
