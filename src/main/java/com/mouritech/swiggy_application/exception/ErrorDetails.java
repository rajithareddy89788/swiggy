package com.mouritech.swiggy_application.exception;

import java.util.Date;

public class ErrorDetails {
	private long timeStamp;
	private String message;
	private int status;

	public ErrorDetails(Long timestamp, String message, int status) {
		super();
		this.timeStamp = timestamp;
		this.message = message;
		this.status = status;
	}

	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
