package com.mouritech.swiggy_application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mouritech.swiggy_application.entity.Items;

public class ItemDto2 {
	@JsonIgnore
	private long id;

	private String itemName;

	private int price;

	private String restaurentName;
	//private int offerValue;
	@JsonIgnore
	private long restaurentId;

	public ItemDto2(Items items) {
		this.setId(items.getId());

		this.setItemName(items.getItemName());

		this.setPrice(items.getPrice());
		this.setRestaurentName(items.getRestaurent().getRestaurentName());
		this.setRestaurentId(items.getRestaurent().getId());
	}

	public long getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(long restaurentId) {
		this.restaurentId = restaurentId;
	}

	public ItemDto2(String itemName, int price, String restaurentName) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.restaurentName = restaurentName;
	}

	public ItemDto2(String itemName, int price, long restaurentId) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.restaurentId = restaurentId;
	}

	public ItemDto2() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getRestaurentName() {
		return restaurentName;
	}

	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}

	
}
