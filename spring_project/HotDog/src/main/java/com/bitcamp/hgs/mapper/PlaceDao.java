package com.bitcamp.hgs.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bitcamp.hgs.domain.Criteria;
import com.bitcamp.hgs.place.domain.Places;

@Repository
public interface PlaceDao {

	// Place 검색
	public List<Places> getPlacesList(Criteria cri);
	
	// Place 전체 수
	public int placesGetTotal(Criteria cri);
}
