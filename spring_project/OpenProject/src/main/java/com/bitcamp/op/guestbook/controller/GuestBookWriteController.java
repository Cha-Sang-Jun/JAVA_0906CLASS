package com.bitcamp.op.guestbook.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op.guestbook.domain.WriteRequest;
import com.bitcamp.op.guestbook.service.GuesteBookWriteService;

@Controller
@RequestMapping("/guestbook/write")
public class GuestBookWriteController {

	@Autowired
	private GuesteBookWriteService writeService;
	
	@GetMapping
	public String getWriteForm() {
		return "guestbook/writeform";
	}
	
	@PostMapping
	public void writeArticle(WriteRequest writeRequest, Model model, HttpServletRequest request) {
		
		model.addAttribute("result", writeService.writeArticle(writeRequest, request));
		
	}
}
