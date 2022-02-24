package com.bitcamp.hgs.place.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.bitcamp.hgs.place.domain.Places;
import com.bitcamp.hgs.place.domain.SearchParams;

public interface PlaceDao {
	
	// 전체 추천장소 게시물의 수
	@Select("select count(*) from hgs.places")
	public int selectTotalCount(Map<String, String> params);
	
	// 추천장소 게시물 리스트(전체)
	public List<Places> selectList(SearchParams params);
	
	// 추천장소 게시물 상세보기
	public Places selectByIdx(int idx);
	
	// 추천장소 인덱스에 연결된 주소 가져오기
	public Places selectAddressByIdx(int idx);
}
