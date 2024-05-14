package com.chatapp.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.chatapp.constants.AppConstants;

@Configuration
public class KafkaTopicConfig {
	
	@Bean
	public NewTopic privateTopic() {
		return TopicBuilder.name(AppConstants.TOPIC_NAME)
				.partitions(10)
				.replicas(0)
				.compact().build();
	}

}
