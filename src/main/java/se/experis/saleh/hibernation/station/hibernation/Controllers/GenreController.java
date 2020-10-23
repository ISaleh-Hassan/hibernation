package se.experis.saleh.hibernation.station.hibernation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.Actor;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.CommonResponse;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.Genre;
import se.experis.saleh.hibernation.station.hibernation.Repositories.GenreRepository;
import se.experis.saleh.hibernation.station.hibernation.Utils.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @PostMapping("/genre/add")
    public ResponseEntity<CommonResponse> addGenre(HttpServletRequest request, HttpServletResponse response, @RequestBody Genre genre){
        genre = genreRepository.save(genre);

        CommonResponse cr = new CommonResponse();
        cr.setData(genre);
        cr.setMessage("New author with id: " + genre.getGenreId());
        HttpStatus resp = HttpStatus.CREATED;
        response.addHeader("Location", "/genre/" + genre.getGenreId());

        return new ResponseEntity<>(cr, resp);
    }


    @GetMapping("/genre/{genre_Id}")
    public ResponseEntity<CommonResponse> getActorById(HttpServletRequest request, @PathVariable("genre_Id") int genreId){
        Command cmd = new Command(request);

        CommonResponse cr = new CommonResponse();
        HttpStatus resp;

        if(genreRepository.existsById(genreId)){
            cr.setData(genreRepository.getOne(genreId));
            cr.setMessage("Actor with id: " +genreId);
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

    @GetMapping("/genre/all")
    public ResponseEntity<CommonResponse> getAllGenres(HttpServletRequest request){

        CommonResponse cr = new CommonResponse();
        cr.setData(genreRepository.findAll());
        cr.setMessage("All genres");

        HttpStatus resp = HttpStatus.OK;

        return new ResponseEntity<>(cr, resp);
    }

    @DeleteMapping("/genre/{id}")
    public ResponseEntity<CommonResponse> deleteAuthor(HttpServletRequest request, @PathVariable Integer id) {

        CommonResponse cr = new CommonResponse();
        HttpStatus resp;

        if(genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
            cr.setMessage("Deleted author with id: " + id);
            resp = HttpStatus.OK;
        } else {
            cr.setMessage("Author not found with id: " + id);
            resp = HttpStatus.NOT_FOUND;
        }


        return new ResponseEntity<>(cr, resp);
    }
}
