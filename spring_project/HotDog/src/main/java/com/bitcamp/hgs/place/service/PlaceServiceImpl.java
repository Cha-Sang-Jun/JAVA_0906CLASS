package com.bitcamp.hgs.place.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.domain.Criteria;
import com.bitcamp.hgs.mapper.PlaceDao;
import com.bitcamp.hgs.place.domain.Places;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class PlaceServiceImpl implements PlaceService {
	
	@Autowired(required=false)
	private PlaceDao placeDao;
	
	// Place 검색
	@Override
	public List<Places> getPlacesList(Criteria cri){
		log.info("getPlacesList().......");
		
		return placeDao.getPlacesList(cri);
	}

	// Place의 수
	@Override
	public int placesGetTotal(Criteria cri) {
		log.info("placesGetTotal().......");
		
		return placeDao.placesGetTotal(cri);
	}
}
