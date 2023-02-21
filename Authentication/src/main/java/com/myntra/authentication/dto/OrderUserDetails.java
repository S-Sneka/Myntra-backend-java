package com.myntra.authentication.dto;

import org.springframework.stereotype.Component;

@Component
public class OrderUserDetails {
	private String phoneNumber;
	private String email;
	private String nameInAddress;
	private String address;
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNameInAddress() {
		return nameInAddress;
	}
	public void setNameInAddress(String nameInAddress) {
		this.nameInAddress = nameInAddress;
	}
}
