package com.bitcamp.hgs.place.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bitcamp.hgs.domain.Criteria;
import com.bitcamp.hgs.place.domain.Places;

@Service
public interface PlaceService {
	
	// Place 검색
	public List<Places> getPlacesList(Criteria cri);
	
	// Place의 수
	public int placesGetTotal(Criteria cri);
	

}
