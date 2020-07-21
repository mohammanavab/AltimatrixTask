package com.redbus.agent.form;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BusSearchRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Source may not be null or blank")
	private String source;

	@NotEmpty(message = "Destination may not be null or blank")
	private String destination;

	@NotNull(message = "Travel Date should not be empty")
	private Date travelDate;

	@JsonFormat(pattern = "dd-MM-YYYY")
	private Date returnDate;

	private String sortBy;

	private String order;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "BusSearchRequest [source=" + source + ", destination=" + destination + ", travelDate=" + travelDate
				+ ", returnDate=" + returnDate + ", sortBy=" + sortBy + ", order=" + order + "]";
	}
}
