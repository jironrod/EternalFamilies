package org.jonathanrodriguez.eternalfamilies.repository;

import org.jonathanrodriguez.eternalfamilies.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {

}