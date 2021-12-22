package com.mouritech.swiggy_application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mouritech.swiggy_application.entity.Items;
import com.mouritech.swiggy_application.entity.Offers;

public class OfferDto {
	@JsonIgnore
	private long id;

	private int offerValue;
	@JsonIgnore
	private String restaurentName;

	private long restaurentId;

	public OfferDto(Offers offers) {
		this.setId(offers.getId());

		this.setOfferValue(offers.getOfferValue());

		this.setRestaurentName(offers.getRestaurent().getRestaurentName());
		this.setRestaurentId(offers.getRestaurent().getId());
	}

	public long getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(long restaurentId) {
		this.restaurentId = restaurentId;
	}

	public OfferDto(int offerValue, String restaurentName) {
		super();
		this.offerValue = offerValue;
		this.restaurentName = restaurentName;
	}

	public OfferDto(int offerValue, long restaurentId) {
		super();
		this.offerValue = offerValue;
		this.restaurentId = restaurentId;
	}

	public OfferDto() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getOfferValue() {
		return offerValue;
	}

	public void setOfferValue(int offerValue) {
		this.offerValue = offerValue;
	}

	public String getRestaurentName() {
		return restaurentName;
	}

	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}

}
