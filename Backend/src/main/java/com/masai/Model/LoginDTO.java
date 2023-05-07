package com.masai.Model;

import lombok.Data;

@Data
public class LoginDTO {

	private String mobileNo;
	private String password;
	//private String role;
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
