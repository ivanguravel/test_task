package com.telco.app.dao;

import com.telco.app.domain.Bridge;
import com.telco.app.utils.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name = "bridges_new")
public interface BridgeDao extends CrudRepository<Bridge, String> {
   List<Bridge> findByState(final State state);
}
