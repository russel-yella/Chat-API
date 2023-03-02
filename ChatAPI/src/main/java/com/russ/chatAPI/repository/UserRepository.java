package com.russ.chatAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.russ.chatAPI.users.User;


public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findBySurName(String username);

}
