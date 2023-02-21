package com.myntra.authentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.dto.ChangePass;
import com.myntra.authentication.dto.PhoneNumberDto;
import com.myntra.authentication.dto.UpdateDetails;
import com.myntra.authentication.dto.UpdateNumDto;
import com.myntra.authentication.dto.VerifyOTP;
import com.myntra.authentication.entity.CustomUser;
import com.myntra.authentication.service.JwtTokenService;
import com.myntra.authentication.service.OTPVerificationService;
import com.myntra.authentication.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/profile")
public class UserController {
	
	private JwtTokenService jwtTokenService;
	private UserService userService;
	private OTPVerificationService otpService;
	private String token;

	public UserController(JwtTokenService jwtTokenService, UserService userService, OTPVerificationService otpService) {
		super();
		this.jwtTokenService = jwtTokenService;
		this.userService = userService;
		this.otpService = otpService;
	}

	@PostMapping("/register")
	public APIResponse register(@RequestBody CustomUser user) {
		return userService.save(user);
	}
	
	@PutMapping("/update")
	public APIResponse register(@RequestHeader("Authorization") String jwtToken,@RequestBody UpdateDetails user) {
		token = jwtToken.substring(7);
		Long userId = jwtTokenService.getUserId(token);
		return userService.update(userId,user);
	}

	@GetMapping(path="/getuserdetails")
	public APIResponse sendUser(@RequestHeader("Authorization") String jwtToken) {
		token = jwtToken.substring(7);
		jwtTokenService.validateToken(token);
		return userService.getUser(token);
	}
	
	@PostMapping("/changePassword")
	public APIResponse changePass(@RequestHeader("Authorization") String jwtToken,@RequestBody ChangePass changePass) {
		token = jwtToken.substring(7);
		jwtTokenService.validateToken(token);
		return userService.changePassword(changePass);
	}
	
	@PostMapping("/checknumber")
	public APIResponse checknumber(@RequestHeader("Authorization") String jwtToken,@RequestBody PhoneNumberDto phoneNumber) {
		token = jwtToken.substring(7);
		jwtTokenService.validateToken(token);
		return userService.checkNum(phoneNumber);
	}
	
	@PutMapping("/updatenumber")
	public APIResponse updatenumber(@RequestHeader("Authorization") String jwtToken,@RequestBody UpdateNumDto phoneNumber) {
		token = jwtToken.substring(7);
		jwtTokenService.validateToken(token);
		return userService.updateNum(phoneNumber);
	}
	
	@PostMapping("/update/sendotp")
	public APIResponse sendOTP(@RequestHeader("Authorization") String jwtToken,@RequestBody PhoneNumberDto sendOtp) {
		token = jwtToken.substring(7);
		jwtTokenService.validateToken(token);
		return otpService.sendOTP(sendOtp.getPhoneNumber());
	}
	
	@PostMapping("/update/verifyotp")
	public APIResponse verifyUpdateOTP(@RequestHeader("Authorization") String jwtToken,@RequestBody VerifyOTP verifyOTP) {
		token = jwtToken.substring(7);
		jwtTokenService.validateToken(token);
		return otpService.verifyUpdateotp(verifyOTP);
	}
	
	@GetMapping(path="/details/{userId}/{addrId}") //order details
	public APIResponse userDetails(@PathVariable Long userId,@PathVariable Long addrId) {
		return userService.getOrderUserDetails(userId,addrId);
	}
	
}
