package com.bitcamp.hgs.home.controller;


import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitcamp.hgs.home.domain.LoginFormInfo;
import com.bitcamp.hgs.home.domain.HomeBoard;
import com.bitcamp.hgs.home.domain.HomePlaceScrap;
import com.bitcamp.hgs.home.domain.HomePlaces;
import com.bitcamp.hgs.home.service.LoginService;
import com.bitcamp.hgs.home.service.HomeBoardService;
import com.bitcamp.hgs.home.service.HomePlaceService;
import com.bitcamp.hgs.member.domain.Logger;
import com.bitcamp.hgs.member.service.BreedService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Controller
public class HomeController {

	BreedService breedService;
	LoginService loginService;
	HomePlaceService homePlaceService;
	HomeBoardService homeBoardService;
	
	HomeController (BreedService breedService, LoginService loginService, HomePlaceService homePlaceService, HomeBoardService homeBoardService){
		this.breedService = breedService;
		this.loginService = loginService;
		this.homePlaceService = homePlaceService;
		this.homeBoardService = homeBoardService;
	}
	
	
	// 로그인 확인 
	@PostMapping("/login")
	public String login(LoginFormInfo loginFormInfo, HttpSession session, HttpServletResponse res) {
		return loginService.checkMember(loginFormInfo, session, res);
	}
	
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		Logger logger = (Logger)session.getAttribute("logger");
		// 로거의 스크랩 정보를 가져와 모델이 넣기 
		List<HomePlaceScrap> scraps = homePlaceService.selectScraps(logger.getMemberIdx());
		
		if( scraps != null ) {
			Gson gson = new GsonBuilder().create();
			String scrapsJson = gson.toJson(scraps);
			System.out.println("scrapsJson = " + scrapsJson);
			model.addAttribute("scraps", scrapsJson);
		} 
		
		/* 	로거의 해시태그 값을 기준	*/
		List<HomeBoard> boardList = homeBoardService.selectBoardList(logger.getHashtags());
		model.addAttribute("HomeBoard", boardList);
		
		
		/*  유저 근처의 장소들 랜덤으로 갖고오기*/
		List<HomePlaces> place = homePlaceService.selectPlaces(logger.getMemberIdx());
		model.addAttribute("HomePlace", place);
		return "home/home";
	}
	
	
	// 회원가입
	@GetMapping("/join")
	public String join( Model model ) {
		model.addAttribute("breedList", breedService.getDogTypeList());
		return "home/join";
	}
	
	
	// 회원가입 형식 선택 페이지
	@GetMapping("/joinType")
	public String joinType() {
		return "home/joinType";
	}


	
}

