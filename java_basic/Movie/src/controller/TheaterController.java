package controller;

import java.util.ArrayList;

import model.TheaterDTO;

public class TheaterController {
    private ArrayList<TheaterDTO> list;
    private int nextId;

    public TheaterController() {
        list = new ArrayList<>();
        nextId = 1;

        // 테스트 데이터 생성
        for (int i = 1; i <= 4; i++) {
            TheaterDTO t = new TheaterDTO();
            t.setName("극장" + i);
            t.setLocation(i + "동 " + i + " 번지");
            t.setPhoneNumber("02" + i + "-" + i);

            insert(t);
        }
    }

    // 극장 목록을 리턴하는 selectAll()
    public ArrayList<TheaterDTO> selectAll() {
        ArrayList<TheaterDTO> temp = new ArrayList<>();
        for (TheaterDTO t : list) {
            temp.add(new TheaterDTO(t));
        }

        return temp;
    }

    // 특정 극장 정보를 리턴하는 selectOne(int id)
    public TheaterDTO selectOne(int id) {
        for (TheaterDTO t : list) {
            if (t.getId() == id) {
                return t;
            }
        }

        return null;
    }

    // 극장 정보를 추가하는 insert(TheaterDTO t)
    public void insert(TheaterDTO t) {
        t.setId(nextId++);

        list.add(t);
    }

    // 극장 정보를 수정하는 update(TheaterDTO t)
    public void update(TheaterDTO t) {
        int index = list.indexOf(t);

        list.set(index, t);
    }

    // 극장 정보를 삭제하는 delete(int id)
    public void delete(int id) {
        TheaterDTO t = new TheaterDTO();
        t.setId(id);

        list.remove(t);
    }
}
