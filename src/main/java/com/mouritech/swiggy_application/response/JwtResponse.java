package com.mouritech.swiggy_application.response;

public class JwtResponse {
	private String token;
	private String status;

	private String message;

	public JwtResponse(String accessToken, String username, String email) {
		this.token = accessToken;
		this.status = username;
		this.message = email;

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
