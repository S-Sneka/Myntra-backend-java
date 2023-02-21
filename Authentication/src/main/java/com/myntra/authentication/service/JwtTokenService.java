package com.myntra.authentication.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.dao.JwtUtil;
import com.myntra.authentication.dto.JwtToken;
import com.myntra.authentication.dto.LoginPasDto;
import com.myntra.authentication.entity.CustomUser;
import com.myntra.authentication.exception.UserNotFoundException;
import com.myntra.authentication.repository.UserRepository;

@Service
public class JwtTokenService {
	
	private CustomUser user;
	private UserRepository userRepository ;
	private APIResponse apiResponse;
	private AuthenticationManager authenticationManager;
	private MyUserDetailsService userdetailsservice;
	private JwtUtil jwtutil;
	
	public JwtTokenService(CustomUser user, UserRepository userRepository, APIResponse apiResponse,
			AuthenticationManager authenticationManager, MyUserDetailsService userdetailsservice, JwtUtil jwtutil) {
		super();
		this.user = user;
		this.userRepository = userRepository;
		this.apiResponse = apiResponse;
		this.authenticationManager = authenticationManager;
		this.userdetailsservice = userdetailsservice;
		this.jwtutil = jwtutil;
	}

	public JwtToken createAuthenticationToken(String phoneNumber,String password) {
		try {
		authenticationManager.authenticate(new  UsernamePasswordAuthenticationToken(phoneNumber,password));
		}catch(BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect user id or password",e);
		}
		final UserDetails userdetails=userdetailsservice.loadUserByUsername(phoneNumber);
		final String jwt=jwtutil.generateToken(userdetails);
		return new JwtToken(jwt);
		
	}
	
	public JwtToken sendTokenPhone(String phoneNumber) {
		final UserDetails userdetails=userdetailsservice.loadUserByUsername(phoneNumber);
		final String jwt=jwtutil.generateToken(userdetails);
		return new JwtToken(jwt);
	}
	
	public APIResponse sendTokenPass(LoginPasDto loginDto) {
		if(loginDto.getUserId().contains("@")) {
			user= userRepository.findByEmail(loginDto.getUserId());
		}
		else {
			user= userRepository.findByMobileNum(loginDto.getUserId());			
		}
		if(user!=null) {
			apiResponse.setData(createAuthenticationToken(loginDto.getUserId(),loginDto.getPassword()));
			apiResponse.setMessage("Login Successful");
			apiResponse.setStatus(true);	
		}
		else {
			throw new UserNotFoundException("User Not Found");	
		}
		return apiResponse;
	}
	
	public void validateToken(String token) {
		jwtutil.isTokenExpired(token);
	}
	
	public Long getUserId(String jwtToken) {
		validateToken(jwtToken);
		String phone = jwtutil.extractUser(jwtToken);			
		user = userRepository.findByMobileNum(phone);
		return user.getId();
	}

}
