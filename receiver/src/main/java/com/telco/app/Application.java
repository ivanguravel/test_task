package com.telco.app;

import com.telco.app.receiver.MessageReceiver;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value={"classpath:application.properties"})
public class Application {

	@Bean
	SimpleMessageListenerContainer container(final ConnectionFactory connectionFactory,
											 final MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames("test");
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(final MessageReceiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMsg");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
