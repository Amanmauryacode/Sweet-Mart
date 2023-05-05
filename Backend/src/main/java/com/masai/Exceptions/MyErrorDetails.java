package com.masai.Exceptions;

import java.time.LocalDateTime;

public class MyErrorDetails {
	private LocalDateTime time;
	private String messags;
	private String details;
	
	public MyErrorDetails() {
		
	}

	public MyErrorDetails(LocalDateTime time, String messags, String details) {
		super();
		this.time = time;
		this.messags = messags;
		this.details = details;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getMessags() {
		return messags;
	}

	public void setMessags(String messags) {
		this.messags = messags;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
