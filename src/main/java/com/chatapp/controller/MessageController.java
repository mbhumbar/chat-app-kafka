package com.chatapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatapp.entity.Message;
import com.chatapp.service.MessageService;

@RestController
@RequestMapping("/message")
public class MessageController {
	
	
	@Autowired
	private MessageService messageService;

	@PostMapping("/send")
	public Message sendMeeage(@RequestBody Message message) {
		this.messageService.sendMessage(message);
		return message;
	}
	

}
