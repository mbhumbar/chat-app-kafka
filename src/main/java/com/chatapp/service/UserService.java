package com.chatapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatapp.entity.User;
import com.chatapp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User create(User user) {
		return userRepository.save(user);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public Optional<User> getSingleUser(Long id) {
		return Optional.of(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
	}

	public User update(User user, Long id) {

		Optional<User> userDetails = userRepository.findById(id);
		User userData = null;
		if (userDetails.isPresent()) {
			userData = userDetails.get();
			if (!userData.getEmailId().equals(user.getEmailId())) {
				userData.setEmailId(user.getEmailId());
			}

			if (!userData.getName().equals(user.getName())) {
				userData.setName(user.getName());
			}

			if (!userData.getMobileNo().equals(user.getMobileNo())) {
				userData.setMobileNo(user.getMobileNo());
			}

			if (!userData.getPassword().equals(user.getPassword())) {
				userData.setPassword(user.getPassword());
			}

			userRepository.save(userData);

		} else {

			System.out.println("user is not present...");
		}
		return userData;
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
