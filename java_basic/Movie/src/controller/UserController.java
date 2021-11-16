package controller;

import java.util.ArrayList;

import model.UserDTO;

public class UserController {
    private ArrayList<UserDTO> list;
    private int nextId;
    private final int RANK_ADMIN = 1;
    private final int RANK_CRITIC = 2;
    private final int RANK_GENERAL = 3;

    public UserController() {
        list = new ArrayList<>();
        nextId = 1;

        // 테스트로 사용할
        // 임시 객체를 만들어 list에 추가하되
        // 관리자 계정과 비평가 계정은
        // insert() 메소드를 사용하면
        // rank의 값이 일반 회원으로 입력되므로
        // 직접 여기서 lsit의 add() 메소드를 사용한다.

        // 관리자를 2명 추가하는 for 문
        for (int i = 1; i <= 2; i++) {
            UserDTO u = new UserDTO();
            u.setId(nextId++);
            u.setUsername("a" + i);
            u.setPassword("1");
            u.setNickname("관리자" + i);
            u.setRank(RANK_ADMIN);

            list.add(u);
        }

        // 비평가를 3명 추가하는 for 문
        for (int i = 1; i <= 3; i++) {
            UserDTO u = new UserDTO();
            u.setId(nextId++);
            u.setUsername("c" + i);
            u.setPassword("1");
            u.setNickname("비평가" + i);
            u.setRank(RANK_CRITIC);

            list.add(u);
        }

        // 일반회원 4명을 추가하는 for 문
        for (int i = 1; i <= 4; i++) {
            UserDTO u = new UserDTO();
            // 일반회원은 아래에 insert() 메소드를 사용하더라도 무방하다.
            u.setUsername("g" + i);
            u.setPassword("1");
            u.setNickname("일반회원" + i);

            insert(u);
        }

    }

    // 파라미터로 들어온 UserDTO 객체에
    // 회원번호와 일반회원 등급 값을 저장한 후
    // list에 추가하는 insert(UserDTO u)
    public void insert(UserDTO u) {
        u.setId(nextId++);
        // 새로 가입하는 회원은 무조건 일반회원으로 가입되어야 하므로
        // rank 값을 상수 RANK_GENERAL 로 저장한다.
        u.setRank(RANK_GENERAL);
        list.add(u);
    }

    // 파라미터로 들어온 int 값과 일치하는
    // 회원번호를 가진 회원을 리턴하는
    // selectOne(int id)
    public UserDTO selectOne(int id) {
        for (UserDTO u : list) {
            if (u.getId() == id) {
                return new UserDTO(u);
            }
        }

        return null;
    }

    // 파라미터로 들어온 UserDTO 객체의 정보로
    // 기존 정보를 수정하는
    // update(UserDTO u)
    public void update(UserDTO u) {
        // 현재 리스트에서 해당 객체의 인덱스를 불러온다.
        int index = list.indexOf(u);
        // 위의 int 변수 index 위치를 파라미터로 들어온
        // u로 바꾼다.
        list.set(index, u);
    }

    // 파라미터로 들어온 int 값과 일치하는
    // 회원번호를 가진 회원을 삭제하는
    // delete(int id)
    public void delete(int id) {
        // 파라미터로 들어온 회원번호 값을 잠시
        // UserDTO 객체의 형태로 저장하기 위해
        // 새로운 UserDTO 객체를 만들고
        // 파라미터로 들어온 int 값을
        // 회원번호에 저장한다.
        UserDTO u = new UserDTO();
        u.setId(id);

        // UserDTO 클래스 안에 equals() 메소드는
        // 두 객체의 id값이 같으면 true가 리턴되므로
        // ArrayList 클래스의 remove 메소드에
        // 위에서 만든 임시객체 u를 파라미터로 넘기면
        // 해당 리스트에서 자동으로 equals()가 true가 나오는
        // 첫번째 객체를 내부에서 삭제한다.
        list.remove(u);
    }

    // 대소문자 구별없이
    // 파라미터로 들어온 String 값과 일치하는
    // username을 가진 회원이 존재하거나
    // String 값이 "X"와 같으면 true,
    // 그외는 false를 리턴하는
    // validate(String username)

    public boolean validate(String username) {
        if (username.equalsIgnoreCase("X")) {
            return true;
        }

        for (UserDTO u : list) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    // 파라미터로 들어온 String 값들을
    // 각각 username과 password로 가지고 있는
    // UserDTO 객체를 리턴하는 auth(String username, String password)
    public UserDTO auth(String username, String password) {
        for (UserDTO u : list) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                return new UserDTO(u);
            }
        }

        return null;
    }
}
