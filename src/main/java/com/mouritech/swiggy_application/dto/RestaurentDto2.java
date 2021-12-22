package com.mouritech.swiggy_application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RestaurentDto2 {
	private Long id;

	private String restaurentName;
	private String restaurentLocation;

	@JsonIgnore
	private String userEmail;

	public RestaurentDto2() {
		// TODO Auto-generated constructor stub
	}

	public RestaurentDto2(String restaurentName, String restaurentLocation, String userEmail) {
		this.restaurentName = restaurentName;
		this.restaurentLocation = restaurentLocation;
		this.userEmail = userEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRestaurentName() {
		return restaurentName;
	}

	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}

	public String getRestaurentLocation() {
		return restaurentLocation;
	}

	public void setRestaurentLocation(String restaurentLocation) {
		this.restaurentLocation = restaurentLocation;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

}
