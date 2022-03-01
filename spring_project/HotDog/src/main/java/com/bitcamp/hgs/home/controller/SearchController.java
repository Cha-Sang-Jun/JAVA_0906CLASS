package com.bitcamp.hgs.home.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.hgs.home.domain.AllTableList;
import com.bitcamp.hgs.home.domain.HomeSelectPlace;
import com.bitcamp.hgs.home.service.SearchService;

@RestController
@RequestMapping("/search")
public class SearchController {
	
	SearchService searchService;
	
	SearchController(SearchService searchService){
		this.searchService = searchService;
	}
	
	
	// 홈 검색 Bar
	@GetMapping
	public void aa(@RequestParam("q") String q) {
		System.out.println(q);
		
		// 파라미터로 받은 값으로 검색
		// 병원, 카페, 공원, 게시글 기준으로 잡았다.
		AllTableList allPlaces = searchService.selectAllTable(q);
		
	}
}
