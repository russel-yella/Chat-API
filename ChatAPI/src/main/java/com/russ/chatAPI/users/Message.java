package com.russ.chatAPI.users;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name ="message")
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String sender;
    private String recipient;
	private String content;
	
   @Enumerated(EnumType.STRING)
    private MessageStatus status;
   
    private LocalDateTime sentTime;
    private LocalDateTime recievedTime;
    private LocalDateTime readTime;

}
