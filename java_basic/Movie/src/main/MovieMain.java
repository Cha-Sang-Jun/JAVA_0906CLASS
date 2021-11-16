package main;

import viewer.MovieViewer;
import viewer.RatingViewer;
import viewer.ShowViewer;
import viewer.TheaterViewer;
import viewer.UserViewer;

public class MovieMain {
    public static void main(String[] args) {
        MovieViewer movieViewer = new MovieViewer();
        RatingViewer ratingViewer = new RatingViewer();
        ShowViewer showViewer = new ShowViewer();
        TheaterViewer theaterViewer = new TheaterViewer();
        UserViewer userViewer = new UserViewer();

        // 각 객체의 의존성 주입을 하는 코드
        movieViewer.setRatingViewer(ratingViewer);
        movieViewer.setShowViewer(showViewer);

        ratingViewer.setUserViewer(userViewer);

        showViewer.setMovieViewer(movieViewer);
        showViewer.setTheaterViewer(theaterViewer);

        theaterViewer.setShowViewer(showViewer);

        userViewer.setMovieViewer(movieViewer);
        userViewer.setRatingViewer(ratingViewer);
        userViewer.setShowViewer(showViewer);
        userViewer.setTheaterViewer(theaterViewer);

        // UserViewer 객체의
        // showIndex() 메소드 실행
        userViewer.showIndex();
    }
}
