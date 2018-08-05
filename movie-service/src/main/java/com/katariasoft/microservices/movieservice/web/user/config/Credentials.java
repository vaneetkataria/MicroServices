package com.katariasoft.microservices.movieservice.web.user.config;

public class Credentials {

	private String userName;
	private String passWord;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Credenetials [userName=" + userName + ", passWord=" + passWord + "]";
	}

}
