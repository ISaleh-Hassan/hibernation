package se.experis.saleh.hibernation.station.hibernation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.saleh.hibernation.station.hibernation.Models.DTO.MovieDTO;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.Actor;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.CommonResponse;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.Movie;
import se.experis.saleh.hibernation.station.hibernation.Repositories.MovieRepository;
import se.experis.saleh.hibernation.station.hibernation.Utils.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    private MovieDTO movieDTO = new MovieDTO();


    @GetMapping("/movie/all")
    public ResponseEntity<CommonResponse> getAllMovies(HttpServletRequest request){

        CommonResponse commonResponse= new CommonResponse();
        List<Movie> allMovies = movieRepository.findAll();
        ArrayList<MovieDTO> movieToReturn= movieDTO.createMovieDtoObjects(allMovies);

        commonResponse.setData(movieToReturn);
        commonResponse.setMessage("Every actors");

        HttpStatus resp = HttpStatus.OK;

        return new ResponseEntity<>(commonResponse,resp);
    }


    @GetMapping("/movie/{movie_Id}")
    public ResponseEntity<CommonResponse> getMovieById(HttpServletRequest request, @PathVariable("movie_Id") int movieId){
        Command cmd = new Command(request);

        CommonResponse cr = new CommonResponse();
        HttpStatus resp;

        if(movieRepository.existsById(movieId)){
            Movie movie= movieRepository.getOne(movieId);
            cr.setData(movieDTO.createMovieDtoObject(movie));
            cr.setMessage("Actor with id: " +movie);
            resp = HttpStatus.OK;
        }
        else{
            cr.setData(null);
            cr.setMessage("Author not found");
            resp = HttpStatus.NOT_FOUND;
        }

        cmd.setResult(resp);
        return new ResponseEntity<>(cr, resp);
    }

    @PostMapping("/movie/add")
    public ResponseEntity<Movie> addMovie(HttpServletRequest request, @RequestBody Movie movie){
        movie = movieRepository.save(movie);

        HttpStatus resp = HttpStatus.CREATED;

        return new ResponseEntity<>(movie,resp);
    }

    @PatchMapping("/movie/update/{movieId}")
    public ResponseEntity<CommonResponse> updateMovie(HttpServletRequest request, @RequestBody Movie movieToUpdate, @PathVariable("movieId") Integer movieId){
        Command cmd = new Command(request);

        CommonResponse cr= new CommonResponse();
        HttpStatus resp= HttpStatus.NOT_FOUND;

        Movie movie = new Movie();
        if(movieRepository.existsById(movieId)){

            movie = movieRepository.getOne(movieId);

            if(movieToUpdate.getActors() !=null){
                movieToUpdate.setActors(movie.getActors());
            }
            if(movieToUpdate.getGenre() !=null){
                movieToUpdate.setGenre(movie.getGenre());
            }
            if(movieToUpdate.getRating() !=0){
                movieToUpdate.setRating(movie.getRating());
            }

            resp= HttpStatus.OK;
            movieRepository.save(movie);
        }
        else {
            cr.setMessage("Movie not found with id: " + movieId);
        }
        return new ResponseEntity<>(cr,resp);
    }

    @DeleteMapping("/movie/delete/{movieId}")
    public ResponseEntity<CommonResponse> deleteActor(HttpServletRequest request, @PathVariable("movieId")  Integer movieId) {

        CommonResponse cr = new CommonResponse();
        HttpStatus resp;

        if(movieRepository.existsById(movieId)) {
            movieRepository.deleteById(movieId);
            cr.setMessage("Deleted movie with id: " + movieId);
            resp = HttpStatus.OK;
        } else {
            cr.setMessage("Movie not found with id: " + movieId);
            resp = HttpStatus.NOT_FOUND;
        }

        return new ResponseEntity<>(cr, resp);
    }

}
