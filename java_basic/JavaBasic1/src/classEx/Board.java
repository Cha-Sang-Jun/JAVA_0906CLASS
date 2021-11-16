package classEx;
// 게시판 담당 클래스
public class Board {
	// 필드
	// 글번호
	private int id;	
	// 작성자
	private String writer;
	// 제목
	private String title;
	// 내용
	private String content;
	
	// 메소드
	
	// 필드에 대한 getter/setter 메소드
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	
	
	public boolean equals(Object o) {
		if(o instanceof Board) {
			Board b = (Board)o;
			if(id == b.id) {
				return true;
			}
		}
		
		return false;
	}

	public void printOne() {
		System.out.println("-----------------------------------");
		System.out.println(title);
		System.out.println("-----------------------------------");
		System.out.printf("글번호: %d 작성자: %s\n", id, writer);
		System.out.println("-----------------------------------");
		System.out.println(content);
		System.out.println("==================================\n");
	}
}
