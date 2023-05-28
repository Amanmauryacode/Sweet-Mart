package com.masai.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DTO.LoginDTO;
import com.masai.Exceptions.LoginException;
import com.masai.Model.CurrentUserSession;
import com.masai.Service.LoginService;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private LoginService customerLogin;
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> logInCustomer(@RequestBody LoginDTO dto) throws LoginException {
		
		CurrentUserSession result = customerLogin.logIntoAccount(dto);
		
		return new ResponseEntity<CurrentUserSession>(result,HttpStatus.OK);
		
		
	}
	
	@PostMapping("/logout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		System.out.println(key);
		return customerLogin.logOutFromAccount(key);
		
	}
	
	
	
}