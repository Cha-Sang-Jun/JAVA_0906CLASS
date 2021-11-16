package model;

public class ShowDTO {
    private int id;
    private int movieId;
    private int theaterId;
    private String showTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public boolean equals(Object o) {
        if (o instanceof ShowDTO) {
            ShowDTO s = (ShowDTO) o;
            return id == s.id;
        }

        return false;
    }

    // 파라미터 없이 각 필드를 0과 "" 으로 초기화하는
    // 생성자
    public ShowDTO() {
        id = 0;
        movieId = 0;
        theaterId = 0;
        showTime = new String();
    }

    // 파라미터로 들어온 객체의 필드 값을
    // 새로운 객체에 복사하는 생성자
    public ShowDTO(ShowDTO s) {
        id = s.id;
        movieId = s.movieId;
        theaterId = s.theaterId;
        showTime = new String(s.showTime);
    }
}
