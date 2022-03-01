package com.bitcamp.hgs.home.dao;

import java.util.List;

import com.bitcamp.hgs.home.domain.HomePlace;
import com.bitcamp.hgs.home.domain.HomePlaceScrap;
import com.bitcamp.hgs.home.domain.HomePlaces;
import com.bitcamp.hgs.home.domain.HomeSelectPlace;

public interface HomePlacesDao {

	public List<HomePlaceScrap> selectScraps(int memberIdx);

	public List<HomePlace> selectPlaces(String address);

	public List<HomePlaces> selectAllPlaces(int memberIdx);

	public List<HomeSelectPlace> selectHomePlaceList(String q);

}
