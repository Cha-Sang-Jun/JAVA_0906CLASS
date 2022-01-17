package com.bitcamp.mvc.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class GuestMessage {

	@JsonIgnore   // 생략하고 싶은 데이터는 어노테이션으로 생략처리 가능
	private int idx;
	private String message;
	private Date date;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonFormat(shape = Shape.STRING)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public GuestMessage() {}
	
	public GuestMessage(int idx, String message, Date date) {
		this.idx = idx;
		this.message = message;
		this.date = date;
	}
	
	
}
