package com.masai.Service;

import com.masai.DTO.LoginDTO;
import com.masai.Exceptions.LoginException;
import com.masai.Model.CurrentUserSession;

public interface LoginService {
	
	public CurrentUserSession logIntoAccount(LoginDTO dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
