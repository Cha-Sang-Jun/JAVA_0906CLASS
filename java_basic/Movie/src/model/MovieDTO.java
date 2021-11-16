package model;

public class MovieDTO {
    private int id;
    private String title;
    private String summary;
    private int filmRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getFilmRate() {
        return filmRate;
    }

    public void setFilmRate(int filmRate) {
        this.filmRate = filmRate;
    }

    public boolean equals(Object o) {
        if (o instanceof MovieDTO) {
            MovieDTO m = (MovieDTO) o;
            return id == m.id;
        }

        return false;
    }

    // 파라미터 없이 각 필드를 0과 "" 으로 초기화하는
    // 생성자
    public MovieDTO() {
        id = 0;
        title = new String();
        summary = new String();
        filmRate = 0;
    }

    // 파라미터로 들어온 객체의 필드 값을
    // 새로운 객체에 복사하는 생성자
    public MovieDTO(MovieDTO m) {
        id = m.id;
        title = new String(m.title);
        summary = new String(m.summary);
        filmRate = m.filmRate;
    }

}
