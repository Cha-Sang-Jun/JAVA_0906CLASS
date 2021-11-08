package emp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpMain {
	
	public static void main(String[] args) {
		
		EmpDao empDao = EmpDao.getInstance();
		
		Connection conn = null;
		List<Emp> list = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			// 1. EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
			list = empDao.selectAllList(conn);
			
			System.out.println("사원리스트");
			System.out.println("------------------------------------");
			for(Emp emp : list) {
				System.out.println(emp);
			}

			System.out.println("------------------------------------");
			
			// 2. EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
			Emp newEmp = new Emp(7831, "SON", "ANALYST", 7789, "81/10/21", 4500, 500, 80);
			
			int insertCnt = empDao.insertEmp(conn, newEmp);
			if (insertCnt > 0) {
				System.out.println("사원정보가 입력되었습니다.");
			} else {
			System.out.println("입력실패!");
			}
			
//			System.out.println("입력결과: " + empDao.);
			
			System.out.println("----------------------------------------------");
			
			// 3. EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
			

			// 4. EMP 테이블에 서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
			Emp emp = empDao.selectByEname(conn, "SCOTT");
			System.out.println("SCOTT의 정보: " + emp);
			
			// 5. 모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자.
			
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
