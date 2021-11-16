package controller;
// 회원가입 프로그램  
// 회원가입 로그인 게시판 작성 및 수정 합치기

import java.util.ArrayList; 

import model.MemberDTO;

public class MemberController {
	private ArrayList<MemberDTO> list;
	private int nextId;

	public MemberController() {
		list = new ArrayList<>();
		nextId = 1;
		
		for(int i =1; i <= 3; i++) {
			MemberDTO m = new MemberDTO();
			
			m.setUsername("a" + i);
			m.setPassword("a");
			m.setNickname("작성자" + i);
			
			insert(m);
		}
	}

	// deepCopy(MemberDTO m)
	public MemberDTO deepCopy(MemberDTO m) {
		MemberDTO temp = new MemberDTO();

		temp.setId(m.getId());
		temp.setUsername(new String(m.getUsername()));
		temp.setNickname(new String(m.getNickname()));

		return temp;
	}

	// insert(MemberDTO m)
	public void insert(MemberDTO m) {
		m.setId(nextId++);

		list.add(m);
	}

	// selectOne(id)
	public MemberDTO selectOne(int id) {
		for (MemberDTO m : list) {
			if (m.getId() == id) {
				return deepCopy(m);
			}
		}

		return null;
	}

	// update(MemberDTO m)
	public void update(MemberDTO m) {
		int index = list.indexOf(m);
		list.set(index, m);
	}

	// delete(id)
	public void delete(int id) {
		MemberDTO m = new MemberDTO();
		m.setId(id);

		list.remove(m);  // remove(id) 로 하면 안됨. 회원번호 id와 일치하는 인덱스를 삭제하는 것이 아니기 떄문
	}

	// validateUsername(String username)
	public boolean validateUsername(String username) {
		if(username.equalsIgnoreCase("x")) {
			return true;
		}
		
		for (MemberDTO m : list) {
			if (m.getUsername().equalsIgnoreCase(username)) {
				return true;
			}
		}

		return false;
	}

	// auth(String username, String password) // 로그인 된사람이 누구인지 리턴해야하기 떄문에
	public MemberDTO auth(String username, String password) {
		for (MemberDTO m : list) {
			if (m.getUsername().equalsIgnoreCase(username) && m.getPassword().equals(password)) {
				return deepCopy(m);
			}
		}
		return null;
	}
}
