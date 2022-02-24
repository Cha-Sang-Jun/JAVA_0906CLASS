package com.bitcamp.hgs.place.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitcamp.hgs.domain.Criteria;
import com.bitcamp.hgs.place.domain.ListPageView;
import com.bitcamp.hgs.place.domain.Places;
import com.bitcamp.hgs.place.service.PlaceService;

@Controller
public class PlaceController {

	private static final Logger logger = LoggerFactory.getLogger(PlaceController.class);
	
	@Autowired
	private PlaceService placeService;
	
	// 메인 페이지 이동
//	@RequestMapping(value="/home", method = RequestMethod.GET)
//	public void mainPageGET(Model model) {
//		logger.info("메인페이지 진입");
//	}
	
	@GetMapping("/home")
	public String home() {
		return "home/home";
	}
	
	// 이미지 출력
//	@GetMapping("/display")
//	public ResponseEntity<byte[]> getImage(String fileName) {
//		
//		logger.info("getImage()......." + fileName); 
//	}
	
	// Place 검색
	@GetMapping("search")
	public String searchPlacesGET(Criteria cri, Model model) {
		
		logger.info("cri: " + cri);
		
		List<Places> list = placeService.getPlacesList(cri);
		logger.info("pre list : " + list);
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
			logger.info("list: " + list);
			
		} else {
			model.addAttribute("listcheck", "empty");
			
			return "search";
		}
		
		model.addAttribute("pageMaker", new ListPageView(cri, placeService.placesGetTotal(cri)));
		
		return "search";
	}
}
