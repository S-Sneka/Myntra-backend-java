package com.myntra.authentication.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="User")
public class CustomUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String mobileNumber;
	@Column(nullable = false)
	private String password;
	@Column
	private String fullName;
	@Column
	private String email;
	@Column
	private String gender;
	@Column
	private String altMobNumber;
	@Column
	private String hintName;
	@Column
	private String location;
	@Column
	private String birthDay;

	public CustomUser() {
		
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public CustomUser(Long id, String mobileNumber, String password, String fullName, String email, String gender,
			String altMobNumber, String hintName, String location, String birthDay) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.gender = gender;
		this.altMobNumber = altMobNumber;
		this.hintName = hintName;
		this.location = location;
		this.birthDay = birthDay;
	}
	
}
