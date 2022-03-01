package com.bitcamp.hgs.member.service;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.member.dao.MemberDao;
import com.bitcamp.hgs.member.domain.Logger;
import com.bitcamp.hgs.member.domain.LoginInfo;
import com.bitcamp.hgs.member.domain.Member;

@Service
public class MypageService {

	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Member getMember(HttpSession session) {
		
		int memberIdx = ((LoginInfo) session.getAttribute("loginInfo")).getMemberIdx();
		
		Member member = null;
		
		dao = template.getMapper(MemberDao.class);
		
		member = dao.selectByIdx(memberIdx);
		
		System.out.println("mypage :" + dao.selectByIdx(memberIdx));
		
		return member;
	}
}
