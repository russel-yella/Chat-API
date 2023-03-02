package com.russ.chatAPI.service;

import java.util.List;

import com.russ.chatAPI.users.Message;

public interface ChatService {
	/**
	 * Method SendMessage is used to send texts between 2 valid Users it stores the
	 * message, time and sending and changes message status to sent
	 * 
	 * @param senderName
	 * @param recipientName
	 * @param content
	 * @return texts sent to the database
	 */
	public String sendMessage(String senderName, String recipientName, String content);

	/**
	 * Method getMessageByReciever is used to recieved all texts of a certain Valid
	 * user message is recieved by the user, thus message status changes to
	 * Delivered and the time of delivery updated in the database
	 * 
	 * @param userName
	 * @return messages to user
	 */
	public List<String> getMessagesByReceiver(String userName);

	/**
	 * Method getMessageById takes userName and id as input and returns everything
	 * concerning a particular text hence, message status changed to READ and read
	 * time updated
	 * 
	 * @param userName
	 * @param id
	 * @return everything about a message to a user
	 */
	public Message getMessageById(String userName, long id);

}
