package com.cg.hcms.registration.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hcms.registration.entity.UserEntity;
import com.cg.hcms.registration.exception.ContactNumberAlreadyExistException;
import com.cg.hcms.registration.exception.EmailAlreadyExistException;
import com.cg.hcms.registration.exception.UserNameAlreadyExistException;
import com.cg.hcms.registration.exception.UserNotFoundException;
import com.cg.hcms.registration.model.UserList;
import com.cg.hcms.registration.model.UserModel;
import com.cg.hcms.registration.repository.RegisterRepository;

@Service
public class RegisterServiceImpl implements RegisterService{

	  

			@Autowired
			private RegisterRepository registerRepo;
			
			private Random random = new Random();
			
			String errorMessage=" is Already Exist";
			
			@Override
			public UserModel registerUser(UserModel user) {
				
				user.setUserId(Integer.toString(random.nextInt(1000000)));
				
				if(registerRepo.getUserByUserName(user.getUserName())!=null)
					throw new UserNameAlreadyExistException("User with Name "+user.getUserName()+errorMessage);
				
				if(registerRepo.getUserByContactNumber(user.getContactNumber())!=null)
					throw new ContactNumberAlreadyExistException("User with ContactNumber "+user.getContactNumber()+errorMessage);
				
				if(registerRepo.getUserByUserEmail(user.getUserEmail())!=null)
					throw new EmailAlreadyExistException("User with Email "+user.getUserEmail()+errorMessage);
			
				return UserModel.toModel(registerRepo.save(UserModel.toEntity(user)));
			}

			@Override
			public UserModel getUser(String userId) {
			
				if(!registerRepo.existsById(userId))
					throw new UserNotFoundException("User with id "+userId+" Not Found");
				
				return UserModel.toModel(registerRepo.getOne(userId));
			
			}

			@Override
			public UserList getAllUsers() {
			
				return new UserList(registerRepo.findAll());
			
			}

			@Override
			public UserModel validateUser(String userName, String userPassword) {
		        
			         UserEntity user=registerRepo.getUserByUserNameAndUserPassword(userName, userPassword);

				 if(user==null)
				 {
					 throw new UserNotFoundException("Invalid UserName and Password");
				 }
				 
				 return UserModel.toModel(user);
			}

			@Override
			public boolean removeAllUsers() {
				registerRepo.deleteAll();
				return registerRepo.findAll().isEmpty();
			}
			
			@Override
			public boolean removeUserById(String userId) {
				registerRepo.deleteById(userId);
				return true;
			}
		}

