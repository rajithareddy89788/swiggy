package com.mouritech.swiggy_application.response;

public class MessageResponse2 {
	private String message;
	private int status;

	public MessageResponse2(int status, String message) {

		this.status = status;
		this.message = message;
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
