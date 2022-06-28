package org.jonathanrodriguez.eternalfamilies.repository;

import org.jonathanrodriguez.eternalfamilies.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<Event, Long> {

}
