package org.jonathanrodriguez.eternalfamilies.repository;

import org.jonathanrodriguez.eternalfamilies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	// will come in handy at a later time
	User findByEmail(String email);
}
