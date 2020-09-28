package com.cg.hcms.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hcms.registration.model.UserList;
import com.cg.hcms.registration.model.UserModel;
import com.cg.hcms.registration.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@PostMapping("/adduser")
	public ResponseEntity<?> registerUser(@RequestBody UserModel user) 
	{
		return ResponseEntity.ok(registerService.registerUser(user));
	}
	
	@GetMapping("/getuser/user-id/{userId}")
	public ResponseEntity<?> getUser(@PathVariable String userId)
	{
		return ResponseEntity.ok(registerService.getUser(userId));
	}
	
	@GetMapping("/getallusers")
	public UserList getAllUsers()
	{
		return registerService.getAllUsers();
	}
	
	@GetMapping("/validateuser/username/{userName}/userpassword/{userPassword}")
	public ResponseEntity<?> validateUser(@PathVariable String userName,@PathVariable String userPassword)
	{
		return ResponseEntity.ok(registerService.validateUser(userName, userPassword));
	}
	
	@DeleteMapping("/removeallusers")
	public ResponseEntity<?> removeAllUsers()
	{
		registerService.removeAllUsers();
		return ResponseEntity.ok("All Users Removed");
	}
	
	@DeleteMapping("/removeuser/{userId}")
	public ResponseEntity<?> removeUser(@PathVariable String userId)
	{
		return ResponseEntity.ok(registerService.removeUserById(userId)); 
	}
}
