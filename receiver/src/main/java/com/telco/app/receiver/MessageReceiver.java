package com.telco.app.receiver;

import com.telco.app.MessageHolder;
import com.telco.app.service.parsing.MessageParsingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MessageReceiver {

	@Autowired
	private MessageHolder messageHolder;
	@Autowired
	private List<MessageParsingStrategy> parseStrategies;

	public void receiveMsg(final String message) {
		for (MessageParsingStrategy messageParsingStrategy : parseStrategies) {
			if (messageParsingStrategy.parse(message)) {
				break;
			}
		}
		messageHolder.addMessage(message);
	}
}
 