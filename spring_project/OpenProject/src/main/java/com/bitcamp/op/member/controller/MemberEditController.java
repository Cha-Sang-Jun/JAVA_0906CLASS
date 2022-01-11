package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitcamp.op.member.domain.MemberEditRequest;
import com.bitcamp.op.member.service.MemberEditService;

@Controller
public class MemberEditController {

	@Autowired
	private MemberEditService editService;
	
	@GetMapping
	public String getEditForm(MemberEditRequest editRequest, HttpSession session,
			HttpServletResponse response, Model model) {
		
		return "member/manager/editform";
	}
	
//	@PostMapping
//	public String edit(MemberEditRequest editRequest, HttpSession session,
//			HttpServletResponse response) {
//		
//		return editService.edit(editRequest, session, response);
//	}
	
	@PostMapping
	public int edit(HttpServletRequest request, HttpServletResponse response) {
		
		return editService.edit(request, response);
	}
}
