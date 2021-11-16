package controller;

import java.util.ArrayList;

import model.ShowDTO;

public class ShowController {
    private ArrayList<ShowDTO> list;
    private int nextId;

    public ShowController() {
        list = new ArrayList<>();
        nextId = 1;

        // 테스트 데이터 생성
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 4; j++) {
                ShowDTO s = new ShowDTO();
                s.setMovieId(i);
                s.setTheaterId(j);

                // 상영시간이
                // "11:00~13:00", "13:00~15:00", "15:00~17:00" 이 되도록 String 값 생성
                String startTime = new String((9 + i * 2) + ":00 ~ " + (9 + (i + 1) * 2) + ":00");
                s.setShowTime(startTime);

                insert(s);
            }
        }
    }

    // 모든 상영정보 목록을 리턴하는 selectAll()
    public ArrayList<ShowDTO> selectAll() {
        ArrayList<ShowDTO> temp = new ArrayList<>();

        for (ShowDTO s : list) {
            temp.add(new ShowDTO(s));
        }

        return temp;
    }

    // 해당 극장의 상영정보 목록을 리턴하는 selectByTheaterId(int theaterId)
    public ArrayList<ShowDTO> selectByTheaterId(int theaterId) {
        ArrayList<ShowDTO> temp = new ArrayList<>();

        for (ShowDTO s : list) {
            if (s.getTheaterId() == theaterId) {
                temp.add(new ShowDTO(s));
            }
        }

        return temp;
    }

    // 특정 상영정보를 리턴하는 selectOne(int id)
    public ShowDTO selectOne(int id) {
        for (ShowDTO s : list) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    // 상영정보를 추가하는 insert(ShowDTO s)
    public void insert(ShowDTO s) {
        s.setId(nextId++);

        list.add(s);
    }

    // 상영정보를 수정하는 update(ShowDTO s)
    public void update(ShowDTO s) {
        int index = list.indexOf(s);

        list.set(index, s);
    }

    // 상영정보를 삭제하는 delete(int id)
    public void delete(int id) {
        ShowDTO s = new ShowDTO();
        s.setId(id);

        list.remove(s);
    }

    // 영화 삭제시 해당 영화의 모든 상영 정보를 삭제하는
    // deleteByMovieId(int movieId)
    public void deleteByMovieId(int movieId) {
        for (int i = 0; i < list.size(); i++) {
            ShowDTO s = list.get(i);
            if (s.getMovieId() == movieId) {
                list.remove(i);
                i = -1;
            }
        }
    }

    public void deleteByTheaterId(int theaterId) {
        for (int i = 0; i < list.size(); i++) {
            ShowDTO s = list.get(i);
            if (s.getTheaterId() == theaterId) {
                list.remove(i);
                i = -1;
            }
        }
    }
}
