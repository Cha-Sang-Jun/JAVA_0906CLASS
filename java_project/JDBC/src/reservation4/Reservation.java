package reservation4;

public class Reservation {

	private int rid;
	private String rdate;
	private String rname;
	private String rphone;
	private int rnum;
	private int tid;
	
	
	public Reservation() {}
	
	public Reservation(int rid, String rdate, String rname, String rphone, int rnum, int tid) {
		this.rid = rid;
		this.rdate = rdate;
		this.rname = rname;
		this.rphone = rphone;
		this.rnum = rnum;
		this.tid = tid;
	}
	
	public Reservation(String rdate, String rname, String rphone, int rnum, int tid) {
		this.rdate = rdate;
		this.rname = rname;
		this.rphone = rphone;
		this.rnum = rnum;
		this.tid = tid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRphone() {
		return rphone;
	}

	public void setRphone(String rphone) {
		this.rphone = rphone;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "Reservation [rid=" + rid + ", rdate=" + rdate + ", rname=" + rname + ", rphone=" + rphone + ", rnum="
				+ rnum + ", tid=" + tid + "]";
	}
	
	
	


	
	
	
	
	
}
