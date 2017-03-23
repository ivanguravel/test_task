package com.telco.app.receiver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.telco.app.dto.BridgeDto;
import com.telco.app.service.BridgeService;
import com.telco.app.service.CustomObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class BridgeMessageReceiver {

	@Autowired
	private CustomObjectMapper objectMapper;
	@Autowired
	private BridgeService service;

	public void receiveMessage(final String message) throws IOException {
		List<BridgeDto> bridges = objectMapper.readValue(message, new TypeReference<List<BridgeDto>>() { });
		service.save(bridges);
	}
}
 