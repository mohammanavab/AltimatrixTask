package com.redbus.agent.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redbus.agent.dao.BusRepository;
import com.redbus.agent.entity.BusEntity;
import com.redbus.agent.exception.BusNotFoundException;
import com.redbus.agent.form.BusSearchRequest;
import com.redbus.agent.form.BusSearchResponse;
import com.redbus.agent.util.BusReservationUtil;

@Service
public class BusService {
	@Autowired
	private BusRepository repository;

	public BusSearchResponse searchBusByLocations(BusSearchRequest request) {
		List<BusEntity> busEntities = null;
		BusSearchResponse response = null;
		final long hours = 3600 * 1000;
		busEntities = repository.findBySourceAndDestination(request.getSource(), request.getDestination());
		if (busEntities != null && !busEntities.isEmpty()) {
			response = new BusSearchResponse();
			for (BusEntity busEntity : busEntities) {
				busEntity.setArrivalTime(
						new Date((long) (busEntity.getDepartureTime().getTime() + (busEntity.getDuration() * hours))));
			}
			busEntities = BusReservationUtil.sortBusEntity(busEntities, request);
			response.setBusList(busEntities);
		} else {
			throw new BusNotFoundException(
					"No bus found form " + request.getSource() + " to " + request.getDestination());
		}
		return response;
	}
}
