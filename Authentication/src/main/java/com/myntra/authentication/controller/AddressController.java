package com.myntra.authentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.dto.AddressDto;
import com.myntra.authentication.service.AddressService;
import com.myntra.authentication.service.JwtTokenService;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {
	
	private JwtTokenService jwtTokenService;
	private String token;
	private AddressService addressService;
	private Long userId;

	public AddressController(JwtTokenService jwtTokenService,AddressService addressService) {
		super();
		this.jwtTokenService = jwtTokenService;
		this.addressService = addressService;
	}

	@PostMapping("/save")
	public APIResponse saveAddress(@RequestHeader("Authorization") String jwtToken,@RequestBody AddressDto address) {
		token = jwtToken.substring(7);
		userId = jwtTokenService.getUserId(token);
		return addressService.saveAddress(userId,address);
	}

	@PutMapping("/edit")
	public APIResponse editAddress(@RequestBody AddressDto address,@RequestHeader("Authorization") String jwtToken) {
		token = jwtToken.substring(7);
		userId = jwtTokenService.getUserId(token);
		return addressService.saveAddress(userId,address);
	}
	
	@DeleteMapping("/remove/{id}")
	public APIResponse removeAddress(@RequestHeader("Authorization") String jwtToken,@PathVariable Long id) {
		token = jwtToken.substring(7);
		jwtTokenService.validateToken(token);
		return addressService.deleteAddress(id);
	}
	
	@GetMapping()
	public APIResponse sendAddress(@RequestHeader("Authorization") String jwtToken) {
		token = jwtToken.substring(7);
		userId = jwtTokenService.getUserId(token);
		return addressService.sendAllAddress(userId);
	}
	
	@GetMapping("/default/{userId}") //bag
	public Long sendDefaultAddressId(@PathVariable Long userId) {
		return addressService.sendDefaultAddress(userId);
	}
	
	@GetMapping("/{addressId}") //bag
	public Object sendAddress(@PathVariable Long addressId) {
		return addressService.sendAddress(addressId);
	}
}
