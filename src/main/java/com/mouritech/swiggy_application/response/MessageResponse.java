package com.mouritech.swiggy_application.response;

public class MessageResponse {
	private String message;
	private String status;

	public MessageResponse(String status, String message) {

		this.status = status;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
