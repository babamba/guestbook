package com.bit2016.guestbook.vo;

import java.sql.Date;

public class GuestBookVo {
	private Long no;
	private String name;
	private String content;
	private String password;
	private String date;
	
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "GuestBookVo [no=" + no + ", name=" + name + ", content="
				+ content + ", password=" + password + ", date=" + date + "]";
	}

	
}
