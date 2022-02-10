package com.example.demo.member.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.member.domain.Member;
import com.example.demo.member.mapper.MemberDao;

@Controller
public class IndexController {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;

	@RequestMapping("/")
	public String getIndex() {
		return "index";   // template 안의 index.html을 찾아들어감
		// return "INDEX Page";
	}
	
	@RequestMapping("/members")
	@ResponseBody
	public List<Member> getList(){
		 
		return template.getMapper(MemberDao.class).selectList(null);
		
	}
}
