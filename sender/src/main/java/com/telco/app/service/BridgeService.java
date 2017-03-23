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
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class BridgeService {

    @Autowired
    private BridgeDao dao;

    public void save(final List<BridgeDto> bridges) {
        for (BridgeDto dto : bridges) {
            String name = dto.getName();
            Bridge bridge = BridgeConverter.convert(dto);
            if (dao.exists(name)) {
                Bridge fromDb = dao.findOne(name);
                if (!bridge.equals(fromDb)) {
                    bridge.setState(State.MODIFIED);
                    dao.save(bridge);
                }
            } else {
                bridge.setState(State.NEW);
                dao.save(bridge);
            }
        }

        // Mark as removed.
        List<Bridge> removedBridges = dao.findByNameNotInNames(bridges
                .parallelStream()
                .map(BridgeDto::getName)
                .collect(Collectors.toList()));
        for (Bridge bridge : removedBridges) {
            bridge.setState(State.REMOVED);
            dao.save(bridge);
        }
    }

    public List<BridgeDto> findAll() {
        Iterable<Bridge> bridges = dao.findAll();
        List<BridgeDto> dtos = new ArrayList<>();
        for (Bridge bridge : bridges) {
            dtos.add(BridgeConverter.convert(bridge));
        }
        return dtos;
    }
}
