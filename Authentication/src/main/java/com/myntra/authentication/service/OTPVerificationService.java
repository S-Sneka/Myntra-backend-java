package com.myntra.authentication.service;

import org.springframework.stereotype.Service;
import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.config.OTPConfig;
import com.myntra.authentication.dto.VerifyOTP;
import com.myntra.authentication.repository.UserRepository;
import com.twilio.Twilio;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;

@Service
public class OTPVerificationService {

	private OTPService otpService;
	private APIResponse apiResponse;
	private OTPConfig otpConfig;
	private JwtTokenService tokenService;
	private UserRepository userRepository;

	public OTPVerificationService(OTPService otpService, APIResponse apiResponse, OTPConfig otpConfig,
			JwtTokenService tokenService, UserRepository userRepository) {
		super();
		this.otpService = otpService;
		this.apiResponse = apiResponse;
		this.otpConfig = otpConfig;
		this.tokenService = tokenService;
		this.userRepository = userRepository;
	}

	public APIResponse sendOTP(String number) {
//		PhoneNumber to = new PhoneNumber(number);
//		PhoneNumber from = new PhoneNumber(otpConfig.getTrialNumber());
		Twilio.init(otpConfig.getAccountSid(),otpConfig.getAuthToken());
		String msg = "[#] "+otpService.generateOTP(number)+" is your OTP for Myntra."
				+ " DO NOT share with anyone. MYNTRA never calls to ask for OTP."
				+ " The otp expires in 10 mins. - Myntra OvqRoh2Noqy";//+otpService.generateOTP(number)
		try {
//			Message.creator(to,from,msg).create();
			System.out.println("\n"+msg+"\n");
			apiResponse.setMessage("OTP Sent");
			apiResponse.setStatus(true);
			apiResponse.setData(null);
		}
		catch(Exception e) {
			apiResponse.setMessage("Invalid Mobile number");
			apiResponse.setStatus(false);
			apiResponse.setData(null);
		}
		return apiResponse;
	}

	public APIResponse verify(VerifyOTP otp) {
		String phoneNumber = otp.getPhoneNumber();
		if (otp.getOtp() == otpService.getOtp(phoneNumber)) {
			otpService.clearOTP(phoneNumber);
			if(userRepository.findByMobileNum(phoneNumber)==null)
			{
				apiResponse.setMessage("New User");
				apiResponse.setStatus(true);
				apiResponse.setData(null);
			}
			else {
				apiResponse.setMessage("Existing User");
				apiResponse.setStatus(true);
				apiResponse.setData(tokenService.sendTokenPhone(phoneNumber));		
			}
		}
		else {
			apiResponse.setMessage("Incorrect OTP");
			apiResponse.setStatus(false);
			apiResponse.setData(null);
		}
		return apiResponse;
	}
	
	public APIResponse verifyUpdateotp(VerifyOTP otp) {
		String phoneNumber = otp.getPhoneNumber();
		if (otp.getOtp() == otpService.getOtp(phoneNumber)) {
			otpService.clearOTP(phoneNumber);
			apiResponse.setMessage("OTP is correct");
			apiResponse.setStatus(true);
			apiResponse.setData(null);
		}
		else {
			apiResponse.setMessage("Incorrect OTP");
			apiResponse.setStatus(false);
			apiResponse.setData(null);
		}
		return apiResponse;
	}
	
}
