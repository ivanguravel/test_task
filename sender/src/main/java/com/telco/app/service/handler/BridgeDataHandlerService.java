package com.telco.app.service.handler;

import com.telco.app.dto.BridgeDto;
import com.telco.app.dto.BridgeNamesDto;
import com.telco.app.dto.BridgeResponse;
import com.telco.app.service.BridgeService;
import com.telco.app.service.CustomObjectMapper;
import com.telco.app.service.SocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class BridgeDataHandlerService implements DataHandlerService {

    @Value("${v_switch.bridges.start.query}")
    private String startQuery;
    @Value("${v_switch.bridges.by.name}")
    private String bridgesInfoByName;

    @Autowired
    private SocketService socketService;
    @Autowired
    private CustomObjectMapper objectMapper;
    @Autowired
    private BridgeService service;

    @Override
    public void handle() {
        String responseWithBridgeName = socketService.writeAndGetResponse(startQuery);
        try {
            BridgeNamesDto bridgeNamesDto = objectMapper.readValue(responseWithBridgeName, BridgeNamesDto.class);
            bridgeNamesDto.getConfiguredBridges().forEach(bridgeName -> {
                String bridgesInfo = socketService.writeAndGetResponse(String.format(bridgesInfoByName, bridgeName));
                List<BridgeDto> bridgeDtos = jsonToBridges(bridgesInfo);
                if (Objects.nonNull(bridgeDtos)) {
                    System.out.println("Json prepared for saving");
                    service.save(bridgeDtos);
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<BridgeDto> jsonToBridges(final String json) {
        try {
            BridgeResponse response = objectMapper.readValue(json, BridgeResponse.class);
            return response.getBridgeDtos();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
