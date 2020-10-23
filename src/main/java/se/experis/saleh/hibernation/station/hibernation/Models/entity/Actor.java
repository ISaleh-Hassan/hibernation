package se.experis.saleh.hibernation.station.hibernation.Models.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Actors")
public class Actor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int actorId;

    @Column(name= "first_name")
    private String firstName;

    @Column(name= "last_name")
    private String lastName;

    @Column(name = "birth")
    private Date dateOfBirth;

    @Column(name= "url_to_imdb")
    private String urlToImdb;


    

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

    public Integer getId() {
        return actorId;
    }

    public void setId(Integer actorId) {
        this.actorId = actorId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

}
