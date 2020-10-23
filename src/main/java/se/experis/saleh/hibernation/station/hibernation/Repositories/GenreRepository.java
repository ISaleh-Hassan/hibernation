package se.experis.saleh.hibernation.station.hibernation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

}