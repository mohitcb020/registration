package com.cg.hcms.registration.model;

import java.util.List;

import com.cg.hcms.registration.entity.UserEntity;

public class UserList {


	private List<UserEntity> usersList;

	public UserList() {
		super();
	}

	public List<UserEntity> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<UserEntity> usersList) {
		this.usersList = usersList;
	}

	public UserList(List<UserEntity> userList) {
		super();
		this.usersList = userList;
	}
    
	@Override
	public String toString() {
		return "UsersList [userList=" + usersList + "]";
	}
	
}

