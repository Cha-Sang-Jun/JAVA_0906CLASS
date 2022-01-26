package com.bitcamp.op.guestbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.guestbook.domain.WriteRequest;
import com.bitcamp.op.guestbook.service.GuestBookEditService;

@Controller
@RequestMapping("/guestbook/edit")
public class GuestBookEditController {

	@Autowired
	private GuestBookEditService editService;
	
	@GetMapping
	public String getEditPage(
			@RequestParam("idx") int idx, Model model) {
		
		model.addAttribute("writeRequest", editService.getGuestBook(idx));
		
		return "guestbook/editForm";
	}
	
	@PostMapping
	public String edit(WriteRequest writeRequest) {
		
		editService.updateGuestBook(writeRequest);
		
		return "redirect:/guestbook/list";
	}
	
}
