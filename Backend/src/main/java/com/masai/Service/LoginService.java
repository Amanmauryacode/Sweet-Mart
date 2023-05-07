package com.masai.Service;

import com.masai.Exceptions.LoginException;
import com.masai.Model.LoginDTO;

public interface LoginService {
	
	public String logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
