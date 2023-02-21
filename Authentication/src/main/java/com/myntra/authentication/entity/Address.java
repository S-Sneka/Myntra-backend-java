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
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long userId;
	@Column
	private String mobileNumber;
	@Column
	private String name;
	@Column
	private String pincode;
	@Column
	private String address;
	@Column
	private String locality;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String typeOfAddress;
	@Column
	private boolean saturdayOpen;
	@Column
	private boolean sundayOpen;
	@Column
	private boolean defaultAddr;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTypeOfAddress() {
		return typeOfAddress;
	}
	public void setTypeOfAddress(String typeOfAddress) {
		this.typeOfAddress = typeOfAddress;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isSaturdayOpen() {
		return saturdayOpen;
	}
	public void setSaturdayOpen(boolean saturdayOpen) {
		this.saturdayOpen = saturdayOpen;
	}
	public boolean isSundayOpen() {
		return sundayOpen;
	}
	public void setSundayOpen(boolean sundayOpen) {
		this.sundayOpen = sundayOpen;
	}
	public boolean isDefaultAddr() {
		return defaultAddr;
	}
	public void setDefaultAddr(boolean defaultAddr) {
		this.defaultAddr = defaultAddr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
