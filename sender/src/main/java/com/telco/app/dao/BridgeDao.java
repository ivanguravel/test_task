package com.telco.app.dao;

import com.telco.app.domain.Bridge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

@Repository
@Table(name = "bridges")
public interface BridgeDao extends CrudRepository<Bridge, String> {
    @Query("select b from Bridge b where b.name not in :names")
    List<Bridge> findByNameNotInNames(@Param("names") final List<String> names);
}
