package com.example.events.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicsConfig {

  @Bean
  public NewTopic ordersTopic() {
    return new NewTopic("orders.created.v1", 3, (short) 1);
  }
}
