package com.myntra.authentication.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.dto.AddressDto;
import com.myntra.authentication.entity.Address;
import com.myntra.authentication.repository.AddressRepository;

@Service
public class AddressService {

	private APIResponse apiResponse;
	private AddressRepository addrRepository;
	private Address address;

	public AddressService(APIResponse apiResponse, AddressRepository addrRepository, Address address) {
		super();
		this.apiResponse = apiResponse;
		this.addrRepository = addrRepository;
		this.address = address;
	}

	public APIResponse saveAddress(Long userId, AddressDto addr) {
		address.setId(addr.getId());
		address.setName(addr.getName());
		address.setAddress(addr.getAddress());
		address.setCity(addr.getCity());
		address.setDefaultAddr(addr.isDefaultAddr());
		address.setTypeOfAddress(addr.getTypeOfAddress());
		address.setLocality(addr.getLocality());
		address.setMobileNumber(addr.getMobileNumber());
		address.setPincode(addr.getPincode());
		List<String> open = addr.getOpen();
		if (open.contains("Saturday"))
			address.setSaturdayOpen(true);
		if (open.contains("Sunday"))
			address.setSundayOpen(true);
		address.setState(addr.getState());
		address.setUserId(userId);
		List<Address> existingAddr = addrRepository.findByUserId(userId);
		if (address.isDefaultAddr()) {
			for (Address a : existingAddr) {
				if (a.isDefaultAddr()) {
					a.setDefaultAddr(false);
					addrRepository.save(a);
				}
			}
		} else {
			if (existingAddr.size() == 0) {
				address.setDefaultAddr(true);
			}
		}
		addrRepository.save(address);
		apiResponse.setData(null);
		apiResponse.setMessage("Address updated");
		apiResponse.setStatus(true);
		return apiResponse;
	}

	public APIResponse sendAllAddress(Long userId) {
		List<Address> addr = addrRepository.findByUserId(userId);
		List<AddressDto> address = new LinkedList<>();
		AddressDto defaultAddress = null;
		for (Address a : addr) {
			if (a.isDefaultAddr())
				defaultAddress = setAddress(a);
			else
				address.add(setAddress(a));
		}
		List<AddressDto> addressInOrder = new LinkedList<>();
		if (defaultAddress != null)
			addressInOrder.add(defaultAddress);
		if (address.size() != 0)
			addressInOrder.addAll(address);
		apiResponse.setData(addressInOrder);
		apiResponse.setMessage("Address");
		apiResponse.setStatus(true);
		return apiResponse;
	}

	public AddressDto setAddress(Address a) {
		AddressDto addressDto = new AddressDto();
		addressDto.setId(a.getId());
		addressDto.setAddress(a.getAddress());
		addressDto.setCity(a.getCity());
		addressDto.setDefaultAddr(a.isDefaultAddr());
		addressDto.setLocality(a.getLocality());
		addressDto.setMobileNumber(a.getMobileNumber());
		addressDto.setName(a.getName());
		List<String> open = new LinkedList<>();
		if (a.isSaturdayOpen())
			open.add("Saturday");
		if (a.isSundayOpen())
			open.add("Sunday");
		addressDto.setOpen(open);
		addressDto.setPincode(a.getPincode());
		addressDto.setState(a.getState());
		addressDto.setTypeOfAddress(a.getTypeOfAddress());
		return addressDto;
	}

	public APIResponse deleteAddress(Long id) {
		Address addr = addrRepository.findById(id).orElse(null);
		addrRepository.deleteById(id);
		if (addr.isDefaultAddr()) {
			List<Address> existingAddr = addrRepository.findByUserId(addr.getUserId());
			for (Address a : existingAddr) {
				a.setDefaultAddr(true);
				addrRepository.save(a);
				break;
			}
		}
		apiResponse.setData(null);
		apiResponse.setMessage("Address removed");
		apiResponse.setStatus(true);
		return apiResponse;
	}

	public List<String> getAddressString(Long addrId) {
		Address addr = addrRepository.findById(addrId).orElse(null);
		if (addr != null) {
			List<String> fullAddress = new LinkedList<>();
			String address = addr.getAddress() + " " + addr.getLocality() + ", " + addr.getCity() + " - "
					+ addr.getPincode();
			fullAddress.add(addr.getName());
			fullAddress.add(address);
			return fullAddress;
		}
		return null;
	}

	public Long sendDefaultAddress(Long userId) {
		Long addressId = addrRepository.findDefaultAddress(userId);
		if (addressId == null)
			addressId = (long) 0;
		return addressId;
	}

	public Object sendAddress(Long addressId) {
		Address address = addrRepository.findById(addressId).orElse(null);
		return address;
	}
}
