package com.chatapp.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.chatapp.constants.AppConstants;
import com.chatapp.entity.Message;
import com.chatapp.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	private Logger logger = LoggerFactory.getLogger(MessageService.class);
	
	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	public Message sendMessage(Message message) {
		this.kafkaTemplate.send(AppConstants.TOPIC_NAME, message);
		this.logger.info("message produced from user1.");
		return messageRepository.save(message);
	}
		
}
