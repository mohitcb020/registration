package com.cg.hcms.registration.model;

import java.math.BigInteger;

import com.cg.hcms.registration.entity.UserEntity;
    
   
	public class UserModel {

		
		private String userId;
		private String userName;
		private String userPassword;
		private BigInteger contactNumber;
		private String userEmail;
		private String userRole;
		private Integer age;
		private String gender;
		
		public UserModel() {
			super();
		}

		public UserModel(String userId, String userName, String userPassword, BigInteger contactNumber, String userEmail,
				String userRole, Integer age, String gender) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.userPassword = userPassword;
			this.contactNumber = contactNumber;
			this.userEmail = userEmail;
			this.userRole = userRole;
			this.age = age;
			this.gender = gender;
		}



		public String getUserRole() {
			return userRole;
		}

		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}

		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserPassword() {
			return userPassword;
		}
		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}
		public BigInteger getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(BigInteger contactNumber) {
			this.contactNumber = contactNumber;
		}
		public String getUserEmail() {
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
					+ ", contactNumber=" + contactNumber + ", userEmail=" + userEmail + ", userRole=" + userRole + ", age="
					+ age + ", gender=" + gender + "]";
		}	
		
		public static UserEntity toEntity(UserModel source) {
			UserEntity result = new UserEntity();
			
			result.setAge(source.getAge());
			result.setContactNumber(source.getContactNumber());
			result.setGender(source.getGender());
			result.setUserEmail(source.getUserEmail());
			result.setUserId(source.getUserId());
			result.setUserName(source.getUserName());
			result.setUserPassword(source.getUserPassword());
			result.setUserRole(source.getUserRole());
			
			return result;
		}
		
		public static UserModel toModel(UserEntity source) {
			UserModel result = new UserModel();
			
			result.setAge(source.getAge());
			result.setContactNumber(source.getContactNumber());
			result.setGender(source.getGender());
			result.setUserEmail(source.getUserEmail());
			result.setUserId(source.getUserId());
			result.setUserName(source.getUserName());
			result.setUserPassword(source.getUserPassword());
			result.setUserRole(source.getUserRole());
			
			return result;
		}
		
	}

