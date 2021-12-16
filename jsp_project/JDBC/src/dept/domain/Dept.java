package dept.domain;

// DB - dept 테이블의 행 데이터를 표현하는 클래스
// Beans : JSP빈즈는 JSP와 연동하려고 만들어진 컴포넌트 클래스이다. 빈즈는 컨테이너에 위치하며,
//         JSP에 데이터베이스 연동 등 프로그램적 요소를 모듈화 할 수 있도록 도와주는 역할을 한다.
public class Dept {
	
	private int deptno;    // 부서번호
	private String dname;  // 부서 이름
	private String loc;    // 부서 위치
	
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	
	// 디폴트 생성자
	public Dept() {}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", loc=" + loc + "]";
	}
	
	
}
