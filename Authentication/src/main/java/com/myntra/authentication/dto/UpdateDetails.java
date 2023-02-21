package com.myntra.authentication.dto;


public class UpdateDetails {
	private String mobileNumber;
	private String FullName;
	private String email;
	private String birthDay;
	private String location;
	private String gender;
	private String altMobNumber;
	private String hintName;
	
	public UpdateDetails(String fullName, String email, String birthDay, String location, String gender, String altMob,
			String hintName,String mobileNumber) {
		super();
		FullName = fullName;
		this.email = email;
		this.birthDay = birthDay;
		this.location = location;
		this.gender = gender;
		this.altMobNumber = altMob;
		this.hintName = hintName;
		this.mobileNumber = mobileNumber;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAltMobNumber() {
		return altMobNumber;
	}

	public void setAltMobNumber(String altMobNumber) {
		this.altMobNumber = altMobNumber;
	}

	public String getHintName() {
		return hintName;
	}

	public void setHintName(String hintName) {
		this.hintName = hintName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
