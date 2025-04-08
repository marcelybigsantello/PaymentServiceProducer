package com.masantello.payment_service.config;

import java.util.HashMap;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaAdmin.NewTopics;

@Configuration
public class KafkaAdminConfig {

	private final KafkaProperties properties;

	public KafkaAdminConfig(KafkaProperties properties) {
		this.properties = properties;
	}

	@Bean
	public KafkaAdmin kafkaAdmin() {
		var configs = new HashMap<String, Object>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
		return new KafkaAdmin(configs);
	}

	@Bean
	public NewTopics generateNewTopics() {
		return new KafkaAdmin.NewTopics(
				TopicBuilder.name("Valid.Payments").partitions(1).build()
		);
	}

}
