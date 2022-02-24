//package com.bitcamp.hgs.place.service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bitcamp.hgs.place.dao.PlaceDao;
//import com.bitcamp.hgs.place.domain.ListPageView;
//import com.bitcamp.hgs.place.domain.Places;
//import com.bitcamp.hgs.place.domain.SearchParams;
//
//@Service
//public class PlaceListService {
//
//	private PlaceDao dao;
//
//	@Autowired
//	private SqlSessionTemplate template;
//
//	// 페이지 당 표현할 추천 게시물 개수
//	private final int COUNT_PER_PAGE = 6;
//
//	// 페이징 번호 노출 개수
//	private final int COUNT_PER_PAGING_NUM = 5;
//
////	public PlaceListView getPage(int currentPage) {
////
////		dao = template.getMapper(PlaceDao.class);
////
////		// 전체 회원 수
////		int totalCount = dao.selectTotalCount();
////
////		int index = (currentPage - 1) * COUNT_PER_PAGE;
////		// 화면에 노출할 메시지
////		List<Places> list = dao.selectList(index, COUNT_PER_PAGE);
////		System.out.println(list);
////
////		return new PlaceListView(currentPage, COUNT_PER_PAGE, COUNT_PER_PAGING_NUM, list, totalCount);
////
////	}
//	
//	public ListPageView getPage(SearchParams params) {
//		
//		ListPageView view = null;
//		dao = template.getMapper(PlaceDao.class);
//		
//		if(params.getKeyword() == null || params.getKeyword().trim().isEmpty()) {
//			params.setSearchType(null);
//		}
//		
//		Map<String, String> searchMap = new HashMap();
//		searchMap.put("serachType", params.getSearchType());
//		searchMap.put("keyword", params.getKeyword());
//		
//		int totalCount = dao.selectTotalCount(searchMap);
//		
//		int currentPage = params.getP() == 0? 1 : params.getP();
//		
//		int index = (currentPage - 1) * COUNT_PER_PAGE;
//		
//		params.setIndex(index);
//		params.setCount(COUNT_PER_PAGE);
//		
//		List<Places> list = dao.selectList(params);
//		
//		view = new ListPageView(totalCount, currentPage, COUNT_PER_PAGE, list);
//		
//		System.out.println(list);
//		return view;
//	}
//}
