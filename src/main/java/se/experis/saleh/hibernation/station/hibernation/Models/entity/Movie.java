package se.experis.saleh.hibernation.station.hibernation.Models.entity;

import com.fasterxml.jackson.annotation.JsonGetter;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int movieid;

    @Column(nullable = false)
    private String title;

    @JsonGetter("Actors")
    private List<String> actors() {
        return actors.stream()
                .map(actor -> {
                    return "/actor/" + actor.getId();
                }).collect(Collectors.toList());
    }

    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
            name = "Movie_Actors",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") }
    )
    private Set<Actor> actors = new HashSet<Actor>();

    @ManyToOne
    @JoinColumn(name = "genreId")
    private Genre genre;

    @Column
    private Date ReleaseYear;

    @Column
    private byte rating;

    @Column
    private double movieLength;

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Date getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        ReleaseYear = releaseYear;
    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public double getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(double movieLength) {
        this.movieLength = movieLength;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
