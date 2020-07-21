package com.redbus.agent.form;

import java.util.List;

import com.redbus.agent.entity.BusEntity;

public class BusSearchResponse extends BaseResponse {
	private static final long serialVersionUID = 1L;

	private List<BusEntity> busList;

	public List<BusEntity> getBusList() {
		return busList;
	}

	public void setBusList(List<BusEntity> busList) {
		this.busList = busList;
	}
}
