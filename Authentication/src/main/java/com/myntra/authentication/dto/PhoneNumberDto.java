package com.myntra.authentication.dto;

import org.springframework.stereotype.Component;

@Component
public class PhoneNumberDto {
	private String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
