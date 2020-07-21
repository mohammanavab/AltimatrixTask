package com.redbus.agent.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.redbus.agent.entity.BusEntity;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Integer> {

	@Query(value = "select b.bus_id, b.bus_no, b.source, b.destination, b.operator_name, b.duration, b.price, b.departure_time from bus b where b.source = ?1 AND b.destination = ?2", nativeQuery = true)
	List<BusEntity> findBySourceAndDestination(String source, String destination);
}
