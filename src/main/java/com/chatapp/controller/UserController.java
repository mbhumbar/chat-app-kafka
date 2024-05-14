package com.chatapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.entity.User;
import com.chatapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/")
	public String demo() {
		
		return "welcome to the chat app";
	}
	
	@PostMapping("/create")
	public User create(@RequestBody User user) {
		return userService.create(user);
	}
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/get/{id}")
	public Optional<User> getSingleUser(@PathVariable Long id) {
		return userService.getSingleUser(id);
		
	}
	
	@PutMapping("/update/{id}")
	public User update(@RequestBody User user, @PathVariable Long id) {
		
		return userService.update(user,id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		userService.deleteUser(id);
		return "user delete successfully....";
	}
}
