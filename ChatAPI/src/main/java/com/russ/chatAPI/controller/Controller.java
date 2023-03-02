package com.russ.chatAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.russ.chatAPI.service.ChatService;
import com.russ.chatAPI.service.UserService;
import com.russ.chatAPI.users.Message;
import com.russ.chatAPI.users.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class Controller {

	@Autowired
	private UserService userService;
	@Autowired
	private ChatService chatService;

	@Operation(summary = "Create A User", description = "Creates a new user with the specified information.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Created"),
	@ApiResponse(responseCode = "404", description = "Not found") })
	
	
	@PostMapping("/createUser")
	public User createUser(@RequestBody(description = "User information", required = true, 
            content = @Content(mediaType = "application/json", 
            schema = @Schema(implementation = User.class), 
            examples = @ExampleObject(value = "{\"fullName\":\"BigRuss\",\"surName\":\"russ\"}"))) User user) {
		return userService.saveUser(user);
	}

	@Operation(summary = "Send Messages Between Users" )
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
	@ApiResponse(responseCode = "404", description = "Not found") })
	
	
	@PostMapping("/sendMessage")
	public void sendMessage(@Parameter(description = "senderName", required = true, example = "russ") @RequestParam String senderName,@Parameter(description = "recieverName", required = true, example = "ro") @RequestParam String recipientName,
			@RequestBody String content) {
		chatService.sendMessage(senderName, recipientName, content);
	}

	@Operation(summary = "Get All Messages for A Specific Users")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
	@ApiResponse(responseCode = "404", description = "Not found") })
	
	
	@GetMapping("/getMessage")
	public List<String> getMessage(@Parameter(description = "UserName", required = true, example = "russ") @RequestParam String userName) {
		return chatService.getMessagesByReceiver(userName);
	}

	@Operation(summary = "Get a Particular Message Of a User, using Message Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successful operation"),
    @ApiResponse(responseCode = "404", description = "Not found") })
	
	
	@GetMapping("/ getMessageById")
	public Message getMessageById(@Parameter(description = "UserName", required = true, example = "russ")@RequestParam String userName, @Parameter(description = "Message id", required = true, example = "1")@RequestParam Long id) {
		return chatService.getMessageById(userName, id);
	}
}
