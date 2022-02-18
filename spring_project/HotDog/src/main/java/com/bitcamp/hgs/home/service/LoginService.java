package com.bitcamp.hgs.home.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.home.domain.LoginFormInfo;
import com.bitcamp.hgs.member.dao.MemberDao;
import com.bitcamp.hgs.member.domain.Logger;

@Service
public class LoginService {
	
	SqlSessionTemplate template;
	BCryptPasswordEncoder encoder;
	
	LoginService (SqlSessionTemplate template, BCryptPasswordEncoder encoder){
		this.template = template;
		this.encoder = encoder;
	}
	
	public int checkMember(LoginFormInfo loginFormInfo, HttpSession session, HttpServletResponse res) {
		System.out.println("서비스 진입");
		int result = 0;
		
		try {
			// 1. 유저 이메일 확인
			Logger logger = template.getMapper(MemberDao.class).selectMember(loginFormInfo.getEmail(), encoder.encode(loginFormInfo.getPassword()));
			System.out.println("logger : " +logger);
			// 맞을 시, 세션에 logger 정보 등록
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return result;
	}
	
	
	
	
}
