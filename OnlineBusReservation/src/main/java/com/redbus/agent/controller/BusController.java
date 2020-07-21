package com.redbus.agent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redbus.agent.form.BusSearchRequest;
import com.redbus.agent.form.BusSearchResponse;
import com.redbus.agent.service.BusService;
import com.redbus.agent.util.ApplicationConstants;

@RestController
public class BusController {

	@Autowired
	private BusService busService;

	@PostMapping(path = "/search-bus")
	public ResponseEntity<BusSearchResponse> searchBusByLocations(@Valid @RequestBody BusSearchRequest request) {
		BusSearchResponse response = null;
		System.out.println(request);
		response = busService.searchBusByLocations(request);
		response.setMessage("For this search " + response.getBusList().size() + " buses found");
		response.setResponseCode(ApplicationConstants.RESPONSE_SUCCESS_CODE);
		return new ResponseEntity<BusSearchResponse>(response, HttpStatus.OK);
	}
}
