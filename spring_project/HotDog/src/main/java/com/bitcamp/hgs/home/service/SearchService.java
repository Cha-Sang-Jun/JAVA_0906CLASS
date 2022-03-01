package com.bitcamp.hgs.home.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.home.dao.HomeBoardDao;
import com.bitcamp.hgs.home.dao.HomePlacesDao;
import com.bitcamp.hgs.home.domain.AllTableList;
import com.bitcamp.hgs.home.domain.HomeBoard;
import com.bitcamp.hgs.home.domain.HomeSelectCafe;
import com.bitcamp.hgs.home.domain.HomeSelectHospital;
import com.bitcamp.hgs.home.domain.HomeSelectPark;
import com.bitcamp.hgs.home.domain.HomeSelectPlace;

@Service
public class SearchService {

	SqlSessionTemplate template;

	SearchService(SqlSessionTemplate template){
		this.template = template;
	}
	
	// d
	public AllTableList selectAllTable(String q) {
		System.out.println("어왓니?");
		List<HomeBoard> homeBoard = template.getMapper(HomeBoardDao.class).selectSearchBoardList(q);
		
		List<HomeSelectPlace> homeSelectPlace = template.getMapper(HomePlacesDao.class).selectHomePlaceList(q);
		
		List<HomeSelectCafe> homeCafe = new ArrayList<HomeSelectCafe>();
		List<HomeSelectPark> homePark = new ArrayList<HomeSelectPark>();
		List<HomeSelectHospital> homeHospital = new ArrayList<HomeSelectHospital>();
		
		for (int i = 0; i < homeSelectPlace.size(); i++) {
			HomeSelectPlace hsp = homeSelectPlace.get(i);
			String category = hsp.getSubjectCategory();
			if(category.equals("카페")) 	homeCafe.add((HomeSelectCafe)hsp);
			else if(category.equals("동물병원")) 	homeHospital.add((HomeSelectHospital)hsp);
			else if(category.equals("공원")) homePark.add((HomeSelectPark)hsp);
		}
		
		AllTableList allTable = new AllTableList();
		allTable.setHomeBoard(homeBoard);
		allTable.setHomeCafe(homeCafe);
		allTable.setHomeHospital(homeHospital);
		allTable.setHomePark(homePark);
		return allTable;
	}
	
	
}
