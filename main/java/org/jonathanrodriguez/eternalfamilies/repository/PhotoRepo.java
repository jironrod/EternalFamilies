package org.jonathanrodriguez.eternalfamilies.repository;

import org.jonathanrodriguez.eternalfamilies.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepo extends JpaRepository<Photo, Long> {

}