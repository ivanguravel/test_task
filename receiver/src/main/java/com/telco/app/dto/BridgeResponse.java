package com.telco.app.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@JsonDeserialize(using = BridgeResponse.BridgeResponseDeserializer.class)
public class BridgeResponse {
    private final List<BridgeDto> bridgeDtos;

    public BridgeResponse(List<BridgeDto> bridgeDtos) {
        this.bridgeDtos = bridgeDtos;
    }

    public List<BridgeDto> getBridgeDtos() {
        return bridgeDtos;
    }

    public static class BridgeResponseDeserializer extends StdDeserializer<BridgeResponse> {

        protected BridgeResponseDeserializer(Class<?> vc) {
            super(vc);
        }

        public BridgeResponseDeserializer() {
            this(null);
        }

        @Override
        public BridgeResponse deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonNode node = p.getCodec().readTree(p);
            JsonNode result = node.get("result");
            if (result.isArray()) {
                JsonNode rows = result.get(0).get("rows");
                Iterator<JsonNode> iterator = rows.iterator();
                JsonNode jsonNode;
                List<BridgeDto> bridgeDtos = new ArrayList<>();
                while (iterator.hasNext()) {
                    jsonNode = iterator.next();
                    BridgeDto dto = new BridgeDto(jsonNode.get("name").asText(),
                                                  jsonNode.get("datapath_id").asText(),
                                                  jsonNode.get("_uuid").get(1).asText(), "");
                    bridgeDtos.add(dto);
                }

                return new BridgeResponse(bridgeDtos);
            }

            return null;
        }
    }
}
