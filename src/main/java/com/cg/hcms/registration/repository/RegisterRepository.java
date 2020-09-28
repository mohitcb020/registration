package com.cg.hcms.registration.repository;

import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hcms.registration.entity.UserEntity;



public interface RegisterRepository extends JpaRepository<UserEntity, String> {

	public UserEntity getUserByUserName(String userName);
	
	public UserEntity getUserByContactNumber(BigInteger contactNumber);
	
	public UserEntity getUserByUserEmail(String userEmail);
	
    public UserEntity getUserByUserNameAndUserPassword(String userName,String userPassword);
}

