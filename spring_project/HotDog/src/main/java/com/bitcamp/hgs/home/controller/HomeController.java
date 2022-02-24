//package com.bitcamp.hgs.home.controller;
//
//
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.bitcamp.hgs.home.domain.LoginFormInfo;
//import com.bitcamp.hgs.home.service.LoginService;
//import com.bitcamp.hgs.member.service.BreedService;
//
//
//@Controller
//public class HomeController {
//
//	BreedService breedService;
//	LoginService loginService;
//	
//	HomeController (BreedService breedService, LoginService loginService){
//		this.breedService = breedService;
//		this.loginService = loginService;
//	}
//	
//	
//	// 로그인 확인 
//	@PostMapping
//	public String login(LoginFormInfo loginFormInfo, HttpSession session, HttpServletResponse res) {
//		return loginService.checkMember(loginFormInfo, session, res);
//	}
//	
//	
//	@GetMapping("/home")
//	public String home() {
//		return "home/home";
//	}
//	
//	
//	// 회원가입
//	@GetMapping("/join")
//	public String join( Model model ) {
//		model.addAttribute("breedList", breedService.getDogTypeList());
//		return "home/join";
//	}
//	
//	
//	// 회원가입 형식 선택 페이지
//	@GetMapping("/joinType")
//	public String joinType() {
//		return "home/joinType";
//	}
//
//
//	
//}
//
