package com.masai.Service;

import java.util.List;

import com.masai.Exceptions.UserExceptions;
import com.masai.Model.User;

public interface UserService {
	
	public User AddUser(User user)throws UserExceptions;
	
	public User UpdateUser(User user)throws UserExceptions;
	
	public User DeleteUser(User user)throws UserExceptions;
	
	public List<User> ShowAllUsers(User user)throws UserExceptions;

}
