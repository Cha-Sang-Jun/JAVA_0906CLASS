package model;

public class RatingDTO {
    private int id;
    private int writerId;
    private int movieId;
    private int rating;
    private String review;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWriterId() {
        return writerId;
    }

    public void setWriterId(int writerId) {
        this.writerId = writerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public boolean equals(Object o) {
        if (o instanceof RatingDTO) {
            RatingDTO r = (RatingDTO) o;
            return id == r.id;
        }

        return false;
    }

    // 파라미터 없이 각 필드를 0과 "" 으로 초기화하는
    // 생성자
    public RatingDTO() {
        id = 0;
        writerId = 0;
        movieId = 0;
        rating = 0;
        review = new String();
    }

    // 파라미터로 들어온 객체의 필드 값을
    // 새로운 객체에 복사하는 생성자
    public RatingDTO(RatingDTO r) {
        id = r.id;
        writerId = r.writerId;
        movieId = r.movieId;
        rating = r.rating;
        review = new String(r.review);
    }
}
