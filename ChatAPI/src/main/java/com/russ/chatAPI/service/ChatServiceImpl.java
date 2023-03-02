package com.russ.chatAPI.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.russ.chatAPI.repository.MessageRepository;
import com.russ.chatAPI.repository.UserRepository;
import com.russ.chatAPI.users.Message;
import com.russ.chatAPI.users.MessageStatus;
import com.russ.chatAPI.users.User;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MessageRepository messageRepository;

	@Override
	public String sendMessage(String senderName, String recipientName, String content) {
		Optional<User> sender = userRepository.findBySurName(senderName);
		Optional<User> recipient = userRepository.findBySurName(recipientName);
		if (sender.isPresent() && recipient.isPresent()) {
			Message message = new Message();
			message.setSender(sender.get().getSurName());
			message.setRecipient(recipient.get().getSurName());
			message.setContent(content);
			message.setStatus(MessageStatus.SENT);
			message.setSentTime(LocalDateTime.now());
			messageRepository.save(message);
			return "Message Sent From " + message.getSender() + " to " + message.getRecipient();
		} else {
			return "User not Found ";
		}
	}

	@Override
	public List<String> getMessagesByReceiver(String userName) {
		List<String> recieverMessages = new ArrayList<>();

		List<Message> messages = messageRepository.findByRecipient(userName);
		for (Message message : messages) {
			if (message.getRecipient().equals(userName)) {
				recieverMessages.add(message.getSender() + ": " + message.getContent());
				message.setStatus(MessageStatus.DELIVERED);
				message.setRecievedTime(LocalDateTime.now());
				messageRepository.save(message);
			}

		}
		return recieverMessages;
	}

	@Override
	public Message getMessageById(String userName, long id) {
		List<Message> user = messageRepository.findByRecipient(userName);
		Message message = messageRepository.getById(id);
		message.setStatus(MessageStatus.READ);
		message.setReadTime(LocalDateTime.now());
		return messageRepository.save(message);

	}

}
