package se.experis.saleh.hibernation.station.hibernation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.experis.saleh.hibernation.station.hibernation.Models.DTO.ActorDTO;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.Actor;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.CommonResponse;
import se.experis.saleh.hibernation.station.hibernation.Repositories.ActorRepository;
import se.experis.saleh.hibernation.station.hibernation.Utils.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;
    private ActorDTO actorDTO= new ActorDTO();

    @GetMapping("/actor/all")
    public ResponseEntity<CommonResponse> getAllActors(HttpServletRequest request){

        CommonResponse commonResponse= new CommonResponse();
        List<Actor> allActors = actorRepository.findAll();
        ArrayList <ActorDTO> actorsToReturn= actorDTO.createActorDtoObjects(allActors);

        commonResponse.setData(actorsToReturn);
        commonResponse.setMessage("Every actors");

        HttpStatus resp = HttpStatus.OK;

        return new ResponseEntity<>(commonResponse,resp);
    }

    @GetMapping("/actor/{actor_Id}")
    public ResponseEntity<CommonResponse> getActorById(HttpServletRequest request, @PathVariable("actor_Id") int actorId){
        Command cmd = new Command(request);

        CommonResponse cr = new CommonResponse();
        HttpStatus resp;

        if(actorRepository.existsById(actorId)){
            Actor actor= actorRepository.getOne(actorId);
            cr.setData(actorDTO.createActorDtoObject(actor));
            cr.setMessage("Actor with id: " +actorId);
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

    @PostMapping("/actor/add")
    public ResponseEntity<Actor> addActor(HttpServletRequest request, @RequestBody Actor actor){
        actor = actorRepository.save(actor);

        HttpStatus resp = HttpStatus.CREATED;

        return new ResponseEntity<>(actor,resp);
    }

    @PatchMapping("/actor/update/{acotrId}")
    public ResponseEntity<CommonResponse> updateActor(HttpServletRequest request, @RequestBody Actor actorToUpdate, @PathVariable("actorId") Integer actorId){
        Command cmd = new Command(request);

        CommonResponse cr= new CommonResponse();
        HttpStatus resp= HttpStatus.NOT_FOUND;

        Actor actor = new Actor();
        if(actorRepository.existsById(actorId)){

            actor = actorRepository.getOne(actorId);

            if(actorToUpdate.getFirstName() !=null){
                actorToUpdate.setFirstName(actor.getFirstName());
            }
            if(actorToUpdate.getDateOfBirth() !=null){
                actorToUpdate.setDateOfBirth(actor.getDateOfBirth());
            }
            if(actorToUpdate.getFirstName() !=null){
                actorToUpdate.setFirstName(actor.getFirstName());
            }
            if(actorToUpdate.getUrlToImdb() !=null){
                actorToUpdate.setUrlToImdb(actor.getUrlToImdb());
            }
            resp= HttpStatus.OK;
            actorRepository.save(actor);
        }
        else {
            cr.setMessage("Author not found with id: " + actorId);
        }
        return new ResponseEntity<>(cr,resp);
    }

    @DeleteMapping("/actor/delete/{actorId}")
    public ResponseEntity<CommonResponse> deleteActor(HttpServletRequest request, @PathVariable("actorId")  Integer actorId) {
        Command cmd = new Command(request);

        //process
        CommonResponse cr = new CommonResponse();
        HttpStatus resp;

        if(actorRepository.existsById(actorId)) {
            actorRepository.deleteById(actorId);
            cr.setMessage("Deleted author with id: " + actorId);
            resp = HttpStatus.OK;
        } else {
            cr.setMessage("Author not found with id: " + actorId);
            resp = HttpStatus.NOT_FOUND;
        }

        //log and return
        cmd.setResult(resp);
        return new ResponseEntity<>(cr, resp);
    }

}
