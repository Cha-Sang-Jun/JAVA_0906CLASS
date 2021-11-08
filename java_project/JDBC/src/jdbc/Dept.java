package jdbc;

// 출력하는 부분과 db를 처리하는 부분을 분리

public class Dept {

	private int deptno;  // DB에서 데이터를 읽어와서 담는다. -> 값이 변하면 안되므로 PRIVATE 처리를 해준다.
	private String dname;
	private String loc;
	
	// 생성자 초기화
	public Dept(int deptno, String dname, String loc) {
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	// 기본 생성자 : Beans 클래스 생성시 반드시 기본 생성자가 있어야 한다.
	// Beans : 시스템에서 객체를 자동으로 만들어주는 클래스. 생성자가 있을 경우 자동으로 만들어주지 못하기 때문에 기본생성자 생성 필요.
	public Dept() {}
	
	
	// VO : 읽기전용, getter 메소드만 존재 -> DB에서 값을 읽어와서 출력만 해줄때, 값이 변경되는걸 원치 않을때
	// DTO : 읽고 쓰기 가능, getter / setter 메소드
	// getter / setter 메소드 생성
	
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
		return deptno + "\t" + dname + "\t" + loc;
	}
	
	
	
	
}
