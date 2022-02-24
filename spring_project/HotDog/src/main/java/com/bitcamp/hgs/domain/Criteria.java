package com.bitcamp.hgs.domain;

import java.util.Arrays;

public class Criteria {

	// 현재 페이지 번호
	private int pageNum;

	// 페이지 표시 개수
	private int amount;

	// 페이지 스킵
	private int skip;

	// 검색 타입
	private String searchType;

	// 검색 키워드
	private String keyword;

	// Place 리스트
	private String[] placeArr;

	// 카테고리 코드
	// private String cateCode;

	// Place 번호
	private int placeIdx;
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
		this.skip = skip;
	}
	
	public Criteria() {
		this(1,10);
	}
	
	public String[] getTypeArr() {
		return searchType == null? new String[] {}:searchType.split("");
	}
	
	public int getPageNum() {
		return pageNum;
	}
	
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		this.skip = (pageNum - 1) * this.amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String[] getPlaceArr() {
		return placeArr;
	}

	public void setPlaceArr(String[] placeArr) {
		this.placeArr = placeArr;
	}

	public int getPlaceIdx() {
		return placeIdx;
	}

	public void setPlaceIdx(int placeIdx) {
		this.placeIdx = placeIdx;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + ", searchType=" + searchType
				+ ", keyword=" + keyword + ", placeArr=" + Arrays.toString(placeArr) + ", placeIdx=" + placeIdx + "]";
	}
	
	

	
}
