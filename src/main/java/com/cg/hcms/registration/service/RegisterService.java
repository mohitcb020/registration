package com.cg.hcms.registration.service;

import com.cg.hcms.registration.model.UserList;
import com.cg.hcms.registration.model.UserModel;

public interface RegisterService {
    
	UserModel registerUser(UserModel user);
	
	UserModel getUser(String userId);
	
	UserList getAllUsers();
	
	UserModel validateUser(String userName,String userPassword); 
	
	boolean removeAllUsers();
	
	boolean removeUserById(String userId);
}


