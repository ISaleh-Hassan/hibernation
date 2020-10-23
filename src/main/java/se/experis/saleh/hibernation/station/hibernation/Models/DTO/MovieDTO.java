package se.experis.saleh.hibernation.station.hibernation.Models.DTO;

import se.experis.saleh.hibernation.station.hibernation.Models.entity.Actor;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.Genre;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.Movie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDTO {
    private String title;
    private Date releaseYear;
    private int rating;
    private int genreId;
    private double movieLength;

    public MovieDTO createMovieDtoObject(Movie Movie){
        MovieDTO movieDTO = new MovieDTO();

        movieDTO.setTitle(Movie.getTitle());
        movieDTO.setGenreId(Movie.getGenre().getGenreId());
        movieDTO.setRating(Movie.getRating());
        movieDTO.setMovieLength(Movie.getMovieLength());
        movieDTO.setReleaseYear(Movie.getReleaseYear());

        return movieDTO;
    }

    public ArrayList<MovieDTO> createMovieDtoObjects(List<Movie> movieList){
        ArrayList<MovieDTO> moviesToReturn= new ArrayList<>();

        for (int i = 0; i < movieList.size(); i++) {
            MovieDTO movieDTO= new MovieDTO();

            movieDTO.setTitle(movieList.get(i).getTitle());
            movieDTO.setGenreId(movieList.get(i).getGenre().getGenreId());
            movieDTO.setRating(movieList.get(i).getRating());
            movieDTO.setMovieLength(movieList.get(i).getMovieLength());
            movieDTO.setReleaseYear(movieList.get(i).getReleaseYear());

            moviesToReturn.add(movieDTO);
        }
        return moviesToReturn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public double getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(double movieLength) {
        this.movieLength = movieLength;
    }
}
