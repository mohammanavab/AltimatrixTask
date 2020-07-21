package com.redbus.agent.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.redbus.agent.entity.BusEntity;
import com.redbus.agent.form.BusSearchRequest;

public class BusReservationUtil {

	public static List<BusEntity> sortBusEntity(List<BusEntity> busEntities, BusSearchRequest request) {
		Comparator<BusEntity> comparator = null;
		if (StringUtils.isNotBlank(request.getSortBy())) {
			if (request.getSortBy().equals(ApplicationConstants.SORT_BY_OPERATOR_NAME)) {
				comparator = getOperatorNameComparator(request.getOrder());
			} else if (request.getSortBy().equals(ApplicationConstants.SORT_BY_DURATION)) {
				comparator = getDurationComparator(request.getOrder());
			} else if (request.getSortBy().equals(ApplicationConstants.SORT_BY_ARRIVAL_TIME)) {
				comparator = getArrivalTimeComparator(request.getOrder());
			} else if (request.getSortBy().equals(ApplicationConstants.SORT_BY_DEPARTURE_TIME)) {
				comparator = getArrivalTimeComparator(request.getOrder());
			}
			Collections.sort(busEntities, comparator);
		} else {
			Collections.sort(busEntities);
		}
		return busEntities;
	}

	public static Comparator<BusEntity> getOperatorNameComparator(String order) {
		Comparator<BusEntity> comparator = Comparator.comparing(BusEntity::getOperatorName);
		if (order != null && ApplicationConstants.ORDER_DESC.equalsIgnoreCase(order))
			comparator = comparator.reversed();
		return comparator;
	}

	public static Comparator<BusEntity> getDurationComparator(String order) {
		Comparator<BusEntity> comparator = Comparator.comparingInt(BusEntity::getDuration);
		if (order != null && ApplicationConstants.ORDER_DESC.equalsIgnoreCase(order))
			comparator = comparator.reversed();
		return comparator;
	}

	public static Comparator<BusEntity> getArrivalTimeComparator(String order) {
		Comparator<BusEntity> comparator = Comparator.comparing(BusEntity::getArrivalTime);
		if (order != null && ApplicationConstants.ORDER_DESC.equalsIgnoreCase(order))
			comparator = comparator.reversed();
		return comparator;
	}

	public static Comparator<BusEntity> getDepartureTimeComparator(String order) {
		Comparator<BusEntity> comparator = Comparator.comparing(BusEntity::getDepartureTime);
		if (order != null && ApplicationConstants.ORDER_DESC.equalsIgnoreCase(order))
			comparator = comparator.reversed();
		return comparator;
	}
}
