package org.jonathanrodriguez.eternalfamilies.service;

import java.util.List;

import org.jonathanrodriguez.eternalfamilies.model.User;
import org.jonathanrodriguez.eternalfamilies.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);

	List<User> getAllUsers();

	User getUserById(long id);

}
