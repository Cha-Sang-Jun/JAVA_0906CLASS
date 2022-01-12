package com.bitcamp.op.member.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op.member.domain.SearchParams;
import com.bitcamp.op.member.service.MemberListService;

// 22.01.12 list.jsp 에 검색기능 추가, 페이지번호 SearchParams에서 받는 걸로 변경
@Controller
public class MemberListController {

	@Autowired
	private MemberListService listService;
	
	@RequestMapping("/member/manager/list")
	public void getListPage( /* @RequestParam(value = "p", defaultValue = "1") int pageNumber, */
			SearchParams params,
			Model model) throws SQLException {
		
		System.out.println(params);
		
		model.addAttribute("listView", listService.getPageView(params));
	}

}
