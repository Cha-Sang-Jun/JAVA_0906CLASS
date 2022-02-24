package com.bitcamp.hgs.home.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.home.domain.LoginFormInfo;
import com.bitcamp.hgs.member.dao.MemberDao;
import com.bitcamp.hgs.member.domain.Logger;
import com.bitcamp.hgs.member.domain.Member;
import com.bitcamp.hgs.member.exception.NoMatchPasswordException;
import com.bitcamp.hgs.member.exception.NoMemberException;

@Service
public class LoginService {
	
	SqlSessionTemplate template;
	BCryptPasswordEncoder encoder;
	
	LoginService (SqlSessionTemplate template, BCryptPasswordEncoder encoder){
		this.template = template;
		this.encoder = encoder;
	}
	
	
	public String checkMember(LoginFormInfo loginFormInfo, HttpSession session, HttpServletResponse res) {
		String viewName = "redirect:/";
		Member member = template.getMapper(MemberDao.class).selectMember(loginFormInfo.getEmail());
		
		// 등록된 유저가 없을 때
		if(member == null) 	System.out.println("등록된 유저가 없습니다.");
		
		// 패스워드가 일치하는지 확인 후 맞을 시, 세션에 유저 정보 등록 및 메인페이지로 가는 주소 삽입
		else {
			if(encoder.matches(loginFormInfo.getPassword(), member.getPassword())) {
				session.setAttribute("logger", member.getLoggerInfo());
				viewName += "home";
			} else System.out.println("패스워드가 일치하지 않습니다.");
				
			// saveEmail버튼이 체크 되어있다면, 쿠키를 이용하여 저장
			if(loginFormInfo.getSaveEmail() != null && loginFormInfo.getSaveEmail().equals("on")) {
				Cookie cookie = new Cookie("saveEmail", loginFormInfo.getSaveEmail());
				res.addCookie(cookie);
			}
		}
		
		return viewName;
	}


	// sns login
	public String loginOauth(Member member, HttpSession session) {
		session.setAttribute("logger", member.getLoggerInfo());
		return "redirect:/home";
	}


	
	
	
	
}
