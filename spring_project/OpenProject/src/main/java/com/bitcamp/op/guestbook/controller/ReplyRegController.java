package com.bitcamp.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.op.guestbook.domain.ReplyRegRequest;
import com.bitcamp.op.guestbook.service.ReplyRegService;

@Controller
public class ReplyRegController {

	// 2번 -> ReplyRegRequest 를 받는 Controller
	@Autowired
	private ReplyRegService regService;
	
	@PostMapping("/guestbook/reply/write")// GET 방식X, POST 방식으로만 넘어오게
	@ResponseBody
	public String regReply(ReplyRegRequest regRequest) {
		
		regService.insertReply(regRequest);
		
		System.out.println("입력된 idx : " + regRequest.getIdx());
		
		return String.valueOf(regRequest.getIdx());
	}
}
