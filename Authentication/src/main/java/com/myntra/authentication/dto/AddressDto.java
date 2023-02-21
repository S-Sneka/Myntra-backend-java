package com.myntra.authentication.dto;

import java.util.List;

public class AddressDto {
	private Long id;
	private String name;
	private String mobileNumber;
	private String pincode;
	private String address;
	private String locality;
	private String city;
	private String state;
	private String typeOfAddress;
	private List<String> open;
	private boolean defaultAddr;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String getTypeOfAddress() {
		return typeOfAddress;
	}
	public void setTypeOfAddress(String typeOfAddress) {
		this.typeOfAddress = typeOfAddress;
	}
	public List<String> getOpen() {
		return open;
	}
	public void setOpen(List<String> open) {
		this.open = open;
	}
	public boolean isDefaultAddr() {
		return defaultAddr;
	}
	public void setDefaultAddr(boolean defaultAddr) {
		this.defaultAddr = defaultAddr;
	}
	@Override
	public String toString() {
		return "AddressDto [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", pincode=" + pincode
				+ ", address=" + address + ", locality=" + locality + ", city=" + city + ", state=" + state
				+ ", typeOfAddress=" + typeOfAddress + ", open=" + open + ", defaultAddr=" + defaultAddr + "]";
	}
	
}
