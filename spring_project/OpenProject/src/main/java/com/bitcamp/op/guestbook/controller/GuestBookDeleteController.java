package com.bitcamp.op.guestbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.guestbook.service.GuestBookDeleteService;

@Controller
public class GuestBookDeleteController {
	
	@Autowired
	private GuestBookDeleteService deleteService;

	@RequestMapping("/guestbook/delete")
	public String deleteGuestBook(
			@RequestParam("idx") int idx) {
		
		deleteService.deleteGuestbook(idx);
		
		return "redirect:/guestbook/list";
		
	}
}
