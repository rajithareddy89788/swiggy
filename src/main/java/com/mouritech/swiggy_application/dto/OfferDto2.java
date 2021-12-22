package com.mouritech.swiggy_application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mouritech.swiggy_application.entity.Items;
import com.mouritech.swiggy_application.entity.Offers;

public class OfferDto2 {
	@JsonIgnore
	private long id;

	private int offerValue;

	private String restaurentName;
	@JsonIgnore
	private long restaurentId;

	public OfferDto2(Offers offers) {
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

	public OfferDto2(int offerValue, String restaurentName) {
		super();
		this.offerValue = offerValue;
		this.restaurentName = restaurentName;
	}

	public OfferDto2(int offerValue, long restaurentId) {
		super();
		this.offerValue = offerValue;
		this.restaurentId = restaurentId;
	}

	public OfferDto2() {
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
