package com.telco.app.service;

import com.telco.app.dao.BridgeDao;
import com.telco.app.domain.Bridge;
import com.telco.app.dto.BridgeDto;
import com.telco.app.utils.BridgeConverter;
import com.telco.app.utils.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BridgeService {

    @Autowired
    private BridgeDao dao;

    public void save(final List<BridgeDto> bridges) {
        for (BridgeDto dto : bridges) {
            dao.save(BridgeConverter.convert(dto));
        }
    }

    public List<BridgeDto> findByType(final String type) {
        List<Bridge> bridges = dao.findByState(State.getValue(type));
        return bridges.parallelStream().map(BridgeConverter::convert).collect(Collectors.toList());
    }

    public List<BridgeDto> findAll() {
        Iterable<Bridge> bridges = dao.findAll();
        List<BridgeDto> result = new ArrayList<>();
        for (Bridge bridge : bridges) {
            result.add(BridgeConverter.convert(bridge));
        }
        return result;
    }
}
