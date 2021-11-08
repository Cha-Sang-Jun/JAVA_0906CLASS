package dept;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DeptMain {
	public static void main(String[] args) {

		// DeptDao deptDao = new DeptDao();
		
		// 싱글톤 패턴 
		DeptDao deptDao = DeptDao.getInstance();
		
		// 대표적인 싱글톤 패턴
		// Calendar c = Calendar.getInstance();
		
		Connection conn = null;
		List<Dept> list = null;

		try {
			conn = ConnectionProvider.getConnection();
			
			// 오토커밋 꺼두기
			conn.setAutoCommit(false); // AutoCommit의 기본 값은 true
			
			// 부서 리스트를 확인
			list = deptDao.selectAllList(conn);

			System.out.println("부서리스트");
			System.out.println("--------------------------------------");
			for (Dept dept : list) {
				System.out.println(dept);
			}

			System.out.println("-------------------------------------");

			// 부서 정보 검색 : 부서 번호
			Dept dept = deptDao.selectByDeptno(conn, 10);
			System.out.println("10번 부서 : " + dept);

			// 부서 정보를 입력
			Dept newDept = new Dept(50, "DEV", "SEOUL");

			int insertCnt = deptDao.insertDept(conn, newDept);
			if (insertCnt > 0) {
				System.out.println("부서정보가 입력되었습니다.");
			} else {
				System.out.println("입력실패!");
			}

			System.out.println("입력결과 :" + deptDao.selectByDeptno(conn, 50));

			System.out.println("---------------------------------");

			// 부서 정보를 수정
			Dept editDept = new Dept(50, "Design", "PUSAN");
			int editCnt = deptDao.editDept(conn, editDept);
			if (editCnt > 0) {
				System.out.println("정보가 수정되었습니다.");
			} else {
				System.out.println("수정 실패 또는 조건에 맞는 데이터가 존재하지 않습니다.");
			}
			System.out.println("수정 결과 :" + deptDao.selectByDeptno(conn, 50));

			System.out.println("-------------------------------------");
			
			// 부서 삭제 : deptno 기준으로 삭제
			int delCnt = deptDao.deleteDept(conn, 50);
			System.out.println("정보가 삭제되었습니다.");
			System.out.println("삭제결과 : " + deptDao.selectByDeptno(conn, 50));

		} catch (SQLException e) {
			
			try {
				conn.rollback();	
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
		}

	}
}
