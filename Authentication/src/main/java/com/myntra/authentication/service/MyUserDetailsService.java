package com.myntra.authentication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myntra.authentication.entity.CustomUser;
import com.myntra.authentication.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String data) throws UsernameNotFoundException {
		CustomUser user;
		if(data.contains("@")) {
			user= userrepository.findByEmail(data);
		}
		else {
			user= userrepository.findByMobileNum(data);			
		}
		return new User(user.getMobileNumber(),user.getPassword(),new ArrayList<>());
	}
}
