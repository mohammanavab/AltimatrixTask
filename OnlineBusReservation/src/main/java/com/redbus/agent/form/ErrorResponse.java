package com.redbus.agent.form;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse extends BaseResponse {

	private static final long serialVersionUID = 1L;

	private Map<String, String> errors;

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

}
