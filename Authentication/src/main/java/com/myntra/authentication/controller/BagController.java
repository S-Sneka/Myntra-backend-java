package com.myntra.authentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.service.BagService;
import com.myntra.authentication.service.JwtTokenService;


@CrossOrigin
@RestController
@RequestMapping("/bag")
public class BagController {
	private BagService bagService;
	private JwtTokenService jwtTokenService;
	Long userId;
	
	public BagController(BagService bagService,JwtTokenService jwtTokenService) {
		super();
		this.bagService = bagService;
		this.jwtTokenService = jwtTokenService;
	}

	@PostMapping("/add")
	public APIResponse addToBag(@RequestHeader("Authorization") String jwtToken,@RequestBody Object bag) {
		userId = jwtTokenService.getUserId(jwtToken.substring(7));
		return bagService.addToBag(userId,bag);
	}
	
	@PostMapping("/move")
	public APIResponse moveToBag(@RequestHeader("Authorization") String jwtToken,@RequestBody Object bag) {
		userId = jwtTokenService.getUserId(jwtToken.substring(7));
		return bagService.moveToBag(userId,bag);
	}
	
	@GetMapping()
	public APIResponse getBag(@RequestHeader("Authorization") String jwtToken) {
		userId = jwtTokenService.getUserId(jwtToken.substring(7));
		return bagService.getBag(userId);
	}
	
	@DeleteMapping()
	public APIResponse removeFromBag(@RequestHeader("Authorization") String jwtToken,@RequestBody Object bag) {
		userId = jwtTokenService.getUserId(jwtToken.substring(7));
		return bagService.removeFromBag(userId,bag);
	}
	
	@PutMapping()
	public APIResponse editBag(@RequestHeader("Authorization") String jwtToken,@RequestBody Object bag) {
		userId = jwtTokenService.getUserId(jwtToken.substring(7));
		return bagService.editBag(userId,bag);
	}
}
