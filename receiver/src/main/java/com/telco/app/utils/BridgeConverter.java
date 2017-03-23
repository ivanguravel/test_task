package com.telco.app.utils;

import com.telco.app.domain.Bridge;
import com.telco.app.dto.BridgeDto;

public class BridgeConverter {

    public static Bridge convert(final BridgeDto dto) {
        Bridge bridge = new Bridge();

        bridge.setUuid(dto.getUuid());
        bridge.setDataPathId(dto.getDataPathId());
        bridge.setName(dto.getName());
        bridge.setState(State.getValue(dto.getState()));

        return bridge;
    }

    public static BridgeDto convert(final Bridge bridge) {
        return new BridgeDto(bridge.getName(), bridge.getUuid(), bridge.getDataPathId(), bridge.getState().name());
    }

    private BridgeConverter() {
    }
}
