package se.experis.saleh.hibernation.station.hibernation.Models.DTO;

import se.experis.saleh.hibernation.station.hibernation.Models.entity.Actor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActorDTO {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String urlToImdb;

    public ActorDTO(){

    }

    public ActorDTO(String firstName, String lastName, Date dateOfBirth, String urlToImdb) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.urlToImdb = urlToImdb;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUrlToImdb() {
        return urlToImdb;
    }

    public void setUrlToImdb(String urlToImdb) {
        this.urlToImdb = urlToImdb;
    }

    public ActorDTO createActorDtoObject(Actor actor){
            ActorDTO actorDTO= new ActorDTO();

            actorDTO.setFirstName(actor.getFirstName());
            actorDTO.setLastName(actor.getLastName());
            actorDTO.setDateOfBirth(actor.getDateOfBirth());
            actorDTO.setUrlToImdb(actor.getUrlToImdb());
        return actorDTO;
    }

    public ArrayList<ActorDTO> createActorDtoObjects(List<Actor> actorList){
        ArrayList<ActorDTO> actorsToReturn= new ArrayList<>();

        for (int i = 0; i < actorList.size(); i++) {
            ActorDTO actorDTO= new ActorDTO();

            actorDTO.setFirstName(actorList.get(i).getFirstName());
            actorDTO.setLastName(actorList.get(i).getLastName());
            actorDTO.setDateOfBirth(actorList.get(i).getDateOfBirth());
            actorDTO.setUrlToImdb(actorList.get(i).getUrlToImdb());

            actorsToReturn.add(actorDTO);
        }
        return actorsToReturn;
    }
}
