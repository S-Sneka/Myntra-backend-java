package com.myntra.authentication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.dto.LoginPasDto;
import com.myntra.authentication.dto.PhoneNumberDto;
import com.myntra.authentication.dto.VerifyOTP;
import com.myntra.authentication.service.JwtTokenService;
import com.myntra.authentication.service.OTPVerificationService;

@CrossOrigin
@RestController
@RequestMapping("/loginorsignup")
public class LoginOrSignUpController {

	private OTPVerificationService otpVerificationService;
	private JwtTokenService jwtTokenService;
	
	public LoginOrSignUpController(OTPVerificationService otpVerificationService, JwtTokenService jwtTokenService) {
		super();
		this.otpVerificationService = otpVerificationService;
		this.jwtTokenService = jwtTokenService;
	}
	
	@GetMapping("/test")
	public String sendOTP() {
		return "Server running";
	}

	@PostMapping("/sendotp")
	public APIResponse sendOTP(@RequestBody PhoneNumberDto sendOtp) {
		return otpVerificationService.sendOTP(sendOtp.getPhoneNumber());
	}
	
	@PostMapping("/verifyotp")
	public APIResponse verifyOTP(@RequestBody VerifyOTP verifyOtp) {
		return otpVerificationService.verify(verifyOtp);
	}
	
	@PostMapping("/password")
	public APIResponse register(@RequestBody LoginPasDto loginDto) {
		return jwtTokenService.sendTokenPass(loginDto);
	}

}
