package com.app.dto;

public class EmailResponse {
	private String email;
	private Long responseTimeMs;
	public EmailResponse(String email, Long responseTimeMs) {
		super();
		this.email = email;
		this.responseTimeMs = responseTimeMs;
	}
	public String getEmail() {
		return email;
	}
	public Long getRespomseTimeMs() {
		return responseTimeMs;
	}
	
	
	

}
