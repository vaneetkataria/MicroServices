package com.katariasoft.microservices.movieservice.web.user.config;

public class Contact {

	private String number;
	private String mail;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Contact [number=" + number + ", mail=" + mail + "]";
	}

}
