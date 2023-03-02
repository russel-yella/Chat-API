package com.russ.chatAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.russ.chatAPI.users.Message;


public interface MessageRepository extends JpaRepository<Message, Long> {
	List<Message> findByRecipient(String username);
}