package exam2;

public class NoteDTO {
	
	private int id;
	private String name;
	private String title;
	private String date;
	private String content;
	
	
	public NoteDTO(String name, String title, String date, String content) {
		super();
		this.name = title + date;
		this.title = title;
		this.date = date;
		this.content = content;
	}
	
	public NoteDTO() {}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	public boolean equals(Object o) {
		if(o instanceof NoteDTO) {
			NoteDTO n = (NoteDTO)o;
			if(name == n.name) {
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
