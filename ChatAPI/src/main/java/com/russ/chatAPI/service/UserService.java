package com.russ.chatAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.russ.chatAPI.exception.CreateUserException;
import com.russ.chatAPI.repository.UserRepository;
import com.russ.chatAPI.users.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
 
	
		public User saveUser(User user) {
		String userName = user.getSurName();
		Optional<User> sender = repository.findBySurName(userName);
			if(sender.isPresent() && sender.get().getSurName().equals(userName)) {
				throw new CreateUserException("UserName Already exist: " + userName);
					}
			else
			return repository.save(user);
			
		}
		  public Optional<User> getUserByName(String name) {
		      return repository.findBySurName(name);
		    }
}
