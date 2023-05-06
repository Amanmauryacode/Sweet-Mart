package com.masai.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.LoginException;
import com.masai.Model.CurrentUserSession;
import com.masai.Model.Customer;
import com.masai.Model.LoginDTO;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionDao;




@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerRepository cDao;
	
	@Autowired
	private SessionDao sDao;
	
	
	
	@Override
	public String logIntoAccount(LoginDTO dto)throws LoginException{
		
		
		Customer existingCustomer= cDao.findByMobileNo(dto.getMobileNo());
		
		if(existingCustomer == null) {
			
			throw new LoginException("Please Enter a valid mobile number");
			
			 
		}
		
		
		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingCustomer.getUserId());
		
		
		
		
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key=(int)Math.random()+"";
			
			
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getUserId(),key,LocalDateTime.now());
			
			sDao.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		
		
	}


	@Override
	public String logOutFromAccount(String key)throws LoginException {
		
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sDao.delete(validCustomerSession);
		
		
		return "Logged Out !";
		
		
	}

}
