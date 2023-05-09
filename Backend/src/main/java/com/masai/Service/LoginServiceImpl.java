package com.masai.Service;


import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.DTO.LoginDTO;
import com.masai.Exceptions.LoginException;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.Customer;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionDao;


@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerRepository cDao;
	
	@Autowired
	private SessionDao sDao;
	
	
	
	@Override
	public CurrentUserSession logIntoAccount(LoginDTO dto)throws LoginException{
		
		
		Customer existingCustomer= cDao.findByUserName(dto.getUserName());
		
		if(existingCustomer == null) {
			
			throw new LoginException("Please Enter a valid User Name");
			
			 
		}
		
		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingCustomer.getUserId());
		
		
		
		
		
		
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
		
			if(validCustomerSessionOpt.isPresent()) {
				throw new LoginException("User already Logged In with this name");
				
			}
			String key = RandomStringGenerator.generateRandomString(8);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getUserId(),key,LocalDateTime.now(),dto.getRole());
			
			sDao.save(currentUserSession);

			return currentUserSession;
		}
		else
			throw new LoginException("Please Enter a valid password");
		
		
	}


	@Override
	public String logOutFromAccount(String key)throws LoginException {
		
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		System.out.println(key);
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sDao.delete(validCustomerSession);
		
		
		return "Logged Out !";
		
		
	}

}