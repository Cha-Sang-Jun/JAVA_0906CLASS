package controller;

import java.util.ArrayList;
import model.StudentDTO;

public class StudentController {
	// 원래대로라면 데이터베이스가 따로 존재하므로
	// 이 안에서는 데이트베이스와 통신하여
	// CRUD(Create, Retrieve, Update, Delete) 하는 기능만 들어가면 되지만
	// 우리는 데이터베이스가 따로 없으므로 이 안에 유사 데이터베이스 역할을 대신할
	// ArrayList 객체를 갖도록 한다.

	private ArrayList<StudentDTO> list;
	private int nextId;

	public void makeConnection() {
		list = new ArrayList<>();
		nextId = 1;
	}

	// 1. 사용자로부터 입력받은 값을
	// 모델 객체로 전달 받아서 리스트에 추가하는
	// insert() 메소드
	public void insert(StudentDTO s) {
		s.setId(nextId++); // 회원번호는 사용자가 만드는 것이 아닌 내부에서 자동으로 지정되게

		list.add(s);
	}

	// 2. 학생 전체 목록을
	// ArrayList 객체로 담아서 보내주는 seletAll() 메소드
	public ArrayList<StudentDTO> selectALL() { // 원본만 그대로 보내려면 return list; (얇은 복사)
		// 얕은 복사(Shallow copy) vs 깊은 복사(Deep copy)
		// 얇은 복사란, 객체를 파라미터로 전달할 때 복사된 주소값을 그대로 넘겨주는 방법이다.
		// 이 방법의 경우, 간단하지만 복사본과 원본이 주소값을 공유하므로
		// 복사본에 수정을 가하면 원본도 수정이 된다 라는 단점이 있다.

		// 깊은 복사란, 객체를 전달할 때 별개의 공간을 새로 만들어서
		// 원본의 값만 복사하여 별개 공간에 저장하고 넘겨주는 방법이다.
		// 이 방법의 경우, 코드가 복잡해지지만 복사본과 원본의 주소값이 다르므로
		// 복사본의 수정이 원본에 반영되지 않는다라는 장점이 있다.

		ArrayList<StudentDTO> temp = new ArrayList<>(); // 원본을 그대로 보내지 않을때(깊은 복사)
		for (StudentDTO s : list) {
			StudentDTO tempS = new StudentDTO();
			tempS.setId(s.getId());
			tempS.setName(new String(s.getName()));
			tempS.setKorean(s.getKorean());
			tempS.setEnglish(s.getEnglish());
			tempS.setMath(s.getMath());
			temp.add(tempS);

		}
		return temp;
	}

	// 3. 사용자가 선택한 번호의 학생을 리턴하는
	// selectOne()
	public StudentDTO selectOne(int id) {
		for (StudentDTO s : list) {
			if (id == s.getId()) {
				StudentDTO temp = new StudentDTO();
				temp.setId(s.getId());
				temp.setName(new String(s.getName()));
				temp.setKorean(s.getKorean());
				temp.setEnglish(s.getEnglish());
				temp.setMath(s.getMath());

				return temp;
			}
		}
		return null;
	}
	
	// 4. 사용자가 수정한 정보를 담은
	//    StudetDTO 객체를 list에 반영하는
	//    update()
	public void update(StudentDTO s) {
		int index = list.indexOf(s);
		list.set(index, s); // s가 존재하는 index를 찾아서 그 index에 s 를 새로 집어넣어준다
	}
	
	// 5. 사용자가 삭제할 번호를 보내주면 list에서 실제로 삭제하는
	//    delete()
	public void delete(int id) {
		StudentDTO s = new StudentDTO();
		s.setId(id);
		list.remove(s);
	}

}
