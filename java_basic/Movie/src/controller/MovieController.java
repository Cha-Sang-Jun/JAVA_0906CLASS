package controller;

import java.util.ArrayList;

import model.MovieDTO;

public class MovieController {
    private ArrayList<MovieDTO> list;
    private int nextId;

    public MovieController() {
        list = new ArrayList<>();
        nextId = 1;

        // 아래에 insert() 메소드를 사용하여
        // 테스트 객체를 추가한다.
        for (int i = 1; i <= 3; i++) {
            MovieDTO m = new MovieDTO();
            m.setTitle("영화" + i);
            m.setSummary("줄거리" + i);
            m.setFilmRate(i * 6);
            insert(m);
        }
    }

    // 파라미터로 들어온 MovieDTO에
    // 필요한 정보를 추가한 후
    // list에 add() 하는
    // insert(MovieDTO)
    public void insert(MovieDTO m) {
        m.setId(nextId++);

        list.add(m);
    }

    // 모든 영화의 리스트를
    // 리턴해주는 selectAll()
    public ArrayList<MovieDTO> selectAll() {
        ArrayList<MovieDTO> temp = new ArrayList<>();

        for (MovieDTO m : list) {
            temp.add(new MovieDTO(m));
        }

        return temp;
    }

    // 파라미터로 들어온 int 값과
    // 일치하는 영화 번호를 가진 객체를 리턴하는
    // selectOne(int id)
    public MovieDTO selectOne(int id) {
        for (MovieDTO m : list) {
            if (m.getId() == id) {
                return new MovieDTO(m);
            }
        }

        return null;
    }

    // 파라미터로 들어온 MovieDTO 객체의 정보로
    // 기존 정보를 수정하는
    // update(MovieDTO m)
    public void update(MovieDTO m) {
        int index = list.indexOf(m);
        list.set(index, m);
    }

    // 파라미터로 들어온 int 값과 일치하는
    // 영화번호를 가진 객체를 list에서 삭제하는
    // delete(int id)
    public void delete(int id) {
        MovieDTO m = new MovieDTO();
        m.setId(id);

        list.remove(m);
    }

}
