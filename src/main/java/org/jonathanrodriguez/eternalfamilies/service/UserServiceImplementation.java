package org.jonathanrodriguez.eternalfamilies.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.jonathanrodriguez.eternalfamilies.model.Role;
import org.jonathanrodriguez.eternalfamilies.model.User;
import org.jonathanrodriguez.eternalfamilies.repository.UserRepository;
import org.jonathanrodriguez.eternalfamilies.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserServiceImplementation(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {

		User user = new User(null, 
				registrationDto.getFirstName(), 
				registrationDto.getLastName(),
				registrationDto.getEmail(), 
				passwordEncoder.encode(registrationDto.getPassword()),
				Arrays.asList(new Role("ROLE_USER")));

		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or passoword");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(user.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {

		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
