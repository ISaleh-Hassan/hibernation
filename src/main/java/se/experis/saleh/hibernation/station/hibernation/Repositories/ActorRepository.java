package se.experis.saleh.hibernation.station.hibernation.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.experis.saleh.hibernation.station.hibernation.Models.entity.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
