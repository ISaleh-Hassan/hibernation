package se.experis.saleh.hibernation.station.hibernation.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Date dateOfBirth;

    @Column
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
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
