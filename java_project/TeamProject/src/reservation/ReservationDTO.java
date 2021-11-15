package reservation;

public class ReservationDTO {

	// 예약 테이블 변수
	private int rid; // 예약번호(PK)
	private String rname; // 예약자 이름
	private String rphonenumber; // 예약자 연락처
	private int rcount; // 예약인원
	private String rdate; // 예약 날짜 및 시간
	private int tid; // 예약 테이블 번호

	// 모든 정보를 저장하는 생성자와 예약번호는 받지 않는 생성자를 정의
	public ReservationDTO(int rid, String rdate, String rname, String rphonenumber, int rcount,int tid) {
		this.rid = rid;
		this.rname = rname;
		this.rphonenumber = rphonenumber;
		this.rcount = rcount;
		this.rdate = rdate;
		this.tid = tid;
	}
	
	public ReservationDTO(String rdate, String rname, String rphonenumber, int rcount,int tid) {
		this.rname = rname;
		this.rdate = rdate;
		this.rphonenumber = rphonenumber;
		this.rcount = rcount;
		this.tid = tid;
	}

	public ReservationDTO() {
	}
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRphonenumber() {
		return rphonenumber;
	}

	public void setRphonenumber(String rphonenumber) {
		this.rphonenumber = rphonenumber;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "  " +rid + " \t" + rname + "\t" + rphonenumber + "\t"
				+ "  " + rcount + "\t" + rdate + "\t" + "  " + tid;
	}

	public boolean equals(Object o) {
		if (o instanceof ReservationDTO) {
			ReservationDTO r = (ReservationDTO) o;
			if (rid == r.rid) {
				return true;
			}
		}

		return false;
	}

}
