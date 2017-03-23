package com.telco.app.controller;

import com.telco.app.dto.BridgeDto;
import com.telco.app.service.BridgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bridges")
public class MessageBrokerController {

    @Autowired
    private BridgeService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<BridgeDto> getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/by-type", method = RequestMethod.GET)
    public List<BridgeDto> getByType(@RequestParam(value="type") final String type) {
        return service.findByType(type);
    }
}
