package se.experis.saleh.hibernation.station.hibernation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.experis.saleh.hibernation.station.hibernation.Models.Actor;
import se.experis.saleh.hibernation.station.hibernation.Repositories.ActorRepository;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @GetMapping("/actor")
    public ResponseEntity<Actor> getAllActors(HttpServletRequest request, @RequestBody Actor actor){
        actor = (Actor) actorRepository.findAll();

        HttpStatus resp = HttpStatus.FOUND;

        return new ResponseEntity<>(actor,resp);
    }

    @PostMapping("/actor")
    public ResponseEntity<Actor> addActor(HttpServletRequest request, @RequestBody Actor actor){
        actor = actorRepository.save(actor);

        HttpStatus resp = HttpStatus.CREATED;

        return new ResponseEntity<>(actor,resp);
    }


}
