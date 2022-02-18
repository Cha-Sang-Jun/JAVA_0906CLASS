package com.bitcamp.hgs.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.hgs.member.domain.RegMember;
import com.bitcamp.hgs.member.service.MemberService;

@RestController
@RequestMapping("/join")
public class MemberRestController {
	
	MemberService service;
	
	MemberRestController(MemberService service){
		this.service = service;
	}
	
	
	@PostMapping
	public void joinMember(RegMember regMember, HttpServletRequest request, Model model) throws IllegalStateException, IOException {
		System.out.println(regMember);
		
		service.insertMember(regMember, request);
	}
	
	
}
