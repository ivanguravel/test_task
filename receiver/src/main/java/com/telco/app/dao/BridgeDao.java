package com.telco.app.dao;

import com.telco.app.domain.Bridge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name = "bridges")
public interface BridgeDao extends CrudRepository<Bridge, Long> {
}
