package com.bitcamp.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.op.guestbook.service.ReplyUpdateService;

@Controller
public class GuestBookReplyUpdateController {

	@Autowired
	private ReplyUpdateService updateService;
	
	@RequestMapping("/guestbook/reply/update")
	@ResponseBody
	public String updateReply(@RequestParam("idx") int idx) {
		return String.valueOf(updateService.updateReply(idx));
	}
}
