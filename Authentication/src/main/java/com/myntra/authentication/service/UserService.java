package com.myntra.authentication.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.myntra.authentication.common.APIResponse;
import com.myntra.authentication.dao.JwtUtil;
import com.myntra.authentication.dto.ChangePass;
import com.myntra.authentication.dto.JwtToken;
import com.myntra.authentication.dto.OrderUserDetails;
import com.myntra.authentication.dto.PhoneNumberDto;
import com.myntra.authentication.dto.UpdateDetails;
import com.myntra.authentication.dto.UpdateNumDto;
import com.myntra.authentication.entity.CustomUser;
import com.myntra.authentication.repository.UserRepository;


@Service
public class UserService {
	
	private JwtTokenService jwtTokenService;
	private CustomUser user;
	private UserRepository userRepository ;
	private APIResponse apiResponse;
	private AuthenticationManager authenticationManager;
	private JwtUtil jwtutil;
	private PasswordEncoder passwordEncoder;
	private OrderUserDetails userDetails;
	private AddressService addrService;

	public UserService(JwtTokenService jwtTokenService, CustomUser user, UserRepository userRepository,
			APIResponse apiResponse, AuthenticationManager authenticationManager, JwtUtil jwtutil,
			PasswordEncoder passwordEncoder,OrderUserDetails userDetails,AddressService addrService) {
		super();
		this.jwtTokenService = jwtTokenService;
		this.user = user;
		this.userRepository = userRepository;
		this.apiResponse = apiResponse;
		this.authenticationManager = authenticationManager;
		this.jwtutil = jwtutil;
		this.passwordEncoder = passwordEncoder;
		this.userDetails = userDetails;
		this.addrService = addrService;
	}

	public APIResponse save(CustomUser user) {
		apiResponse.setData(null);
		apiResponse.setStatus(false);
		boolean flag = true;
		if(!isValidMobNum(user.getMobileNumber())) {
			apiResponse.setMessage("Enter valid mobile number");
			flag = false;
		}
		else if(!isValidPassword(user.getPassword())) {
			apiResponse.setMessage("Password should contain atleast 8 characters, 1 special character, 1 UpperCase, 1 number");
			flag = false;
		}
		else if(!user.getEmail().equals("")) {
			if(!isValidEmail(user.getEmail())) {
				apiResponse.setMessage("Enter valid email");
				flag = false;
			}
			else if(userRepository.findByEmail(user.getEmail())!=null) {
				apiResponse.setMessage("Email already exists");
				flag = false;
			}
		}
		else if(!user.getAltMobNumber().equals("")) {
			if(!isValidMobNum(user.getAltMobNumber())) {
				apiResponse.setMessage("Enter valid alternate mobile number");
				flag = false;
			}
		}
		if(flag){
			String password = user.getPassword();
			user.setPassword(passwordEncoder.encode(password));
			userRepository.save(user);
			apiResponse.setMessage("Registertion Successful");
			apiResponse.setData(jwtTokenService.createAuthenticationToken(user.getMobileNumber(),password));
			apiResponse.setStatus(true);
		}
		return apiResponse;
	}
	
	public boolean isValidPassword(String password)
    {
        String regex = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        if (password == null) {
            return false;
        }
        Matcher m = p.matcher(password);
        return m.matches();
    }
	
	public boolean isValidMobNum(String s)
	{
		Pattern p = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$");
		Matcher m = p.matcher(s);
		return (m.matches());
	}
	
	public boolean isValidEmail(String email) {
		String regex = "^(.+)@(.+)$";    
        Pattern pattern = Pattern.compile(regex);    
        Matcher matcher = pattern.matcher(email);  
        return matcher.matches();  
	}
	
	public APIResponse update(Long userId,UpdateDetails update) {
		user = userRepository.findById(userId).orElse(null);
		CustomUser emailCheckUser = userRepository.findByEmail(update.getEmail());
		if(emailCheckUser!=null && emailCheckUser.getId()!=userId) {
			apiResponse.setData(null);
			apiResponse.setStatus(false);
			apiResponse.setMessage("Email already exists");
			return apiResponse;
		}
		user.setAltMobNumber(update.getAltMobNumber());
		user.setFullName(update.getFullName());
		user.setBirthDay(update.getBirthDay());
		user.setEmail(update.getEmail());
		user.setGender(update.getGender());
		user.setHintName(update.getHintName());
		user.setLocation(update.getLocation());
		userRepository.save(user);
		apiResponse.setData(null);
		apiResponse.setMessage("Updated Successfully");
		apiResponse.setStatus(true);
		return apiResponse;
	}
	
	public APIResponse checkNum(PhoneNumberDto phoneNumber) {
		user = userRepository.findByMobileNum(phoneNumber.getPhoneNumber());
		apiResponse.setData(null);
		if(user!=null) {
			apiResponse.setMessage("Already Exists");
			apiResponse.setStatus(false);
		}
		else {
			apiResponse.setMessage("New number");
			apiResponse.setStatus(true);
		}
		return apiResponse;
	}
	
	public APIResponse updateNum(UpdateNumDto phoneNumber) {
		user = userRepository.findByMobileNum(phoneNumber.getOldNumber());
		user.setMobileNumber(phoneNumber.getNewNumber());
		userRepository.save(user);
		apiResponse.setData(jwtTokenService.sendTokenPhone(phoneNumber.getNewNumber()));
		apiResponse.setMessage("Number updated");
		apiResponse.setStatus(true);			
		return apiResponse;
	}
	
	public APIResponse changePassword(ChangePass changePass) {
		user = userRepository.findByMobileNum(changePass.getMobileNumber());
		if(user==null) {
			apiResponse.setData(null);
			apiResponse.setMessage("User not found");
			apiResponse.setStatus(false);
		}
		else {
			try {
				authenticationManager.authenticate(new  UsernamePasswordAuthenticationToken(changePass.getMobileNumber(),changePass.getOldPassword()));
			}catch(BadCredentialsException e) {
				throw new BadCredentialsException("Invalid userId or password",e);
			}
			user.setPassword(passwordEncoder.encode(changePass.getNewPassword()));
			userRepository.save(user);
			apiResponse.setData(null);
			apiResponse.setMessage("Password updated");
			apiResponse.setStatus(true);	
		}
		return apiResponse;
	}

	public APIResponse getUser(String jwtToken) {
		try {
			String phone = jwtutil.extractUser(jwtToken);			
			user = userRepository.findByMobileNum(phone);
			UpdateDetails userDetails = new UpdateDetails(user.getFullName(), user.getEmail(), user.getBirthDay(), user.getLocation(),
					user.getGender(), user.getAltMobNumber(),user.getHintName(),user.getMobileNumber());
			apiResponse.setData(userDetails);
			apiResponse.setMessage("user details");
			apiResponse.setStatus(true);			
		}
		catch(Exception e) {
			apiResponse.setData(null);
			apiResponse.setMessage("invalid token");
			apiResponse.setStatus(false);			
		}
		return apiResponse;
	}
	
	public APIResponse getUserId(JwtToken jwtToken) {
		String phone = jwtutil.extractUser(jwtToken.getJwt());			
		user = userRepository.findByMobileNum(phone);
		apiResponse.setData(user.getId());
		apiResponse.setMessage("user id");
		apiResponse.setStatus(true);			
		return apiResponse;
	}

	public APIResponse getOrderUserDetails(Long userId, Long addrId) {
		CustomUser user = userRepository.findById(userId).orElse(null);
		userDetails.setEmail(user.getEmail());
		userDetails.setPhoneNumber(user.getMobileNumber());
		List<String> address = addrService.getAddressString(addrId);
		userDetails.setNameInAddress(address.get(0));
		userDetails.setAddress(address.get(1));
		apiResponse.setData(userDetails);
		return apiResponse;
	}

}

