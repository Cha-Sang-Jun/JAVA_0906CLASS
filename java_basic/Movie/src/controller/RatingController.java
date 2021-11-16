package controller;

import java.util.ArrayList;
import java.util.Random;

import model.RatingDTO;
import viewer.UserViewer;

public class RatingController {
    private ArrayList<RatingDTO> list;
    private int nextId;
    private final int RATING_MAX = 5;

    public RatingController() {
        list = new ArrayList<>();
        nextId = 1;

        // 테스트 데이터 생성

        // 랜덤 평점을 저장하기 위한 Random 객체
        Random random = new Random();

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                // 회원번호 3번부터 관리자가 아니므로
                // writerId는 3으로 지정
                int writerId = i + 3;

                RatingDTO r = new RatingDTO();
                r.setWriterId(writerId);
                r.setMovieId(j);
                r.setRating(random.nextInt(RATING_MAX) + 1);

                // 회원번호 3~5는 평론가이므로
                // writerId 가 3~5일때에만
                // 평론을 저장한다.
                if (writerId >= 3 && writerId <= 5) {
                    r.setReview("평론 " + i);
                }

                insert(r);
            }
        }
    }

    // 해당 영화의 평론을 모두 불러오는 selectAll(int movieId)
    public ArrayList<RatingDTO> selectAll(int movieId) {
        ArrayList<RatingDTO> temp = new ArrayList<>();

        for (RatingDTO r : list) {
            if (r.getMovieId() == movieId) {
                temp.add(new RatingDTO(r));
            }
        }

        return temp;
    }

    // 해당 영화의 평론 리스트를 파라미터로 받아서
    // 평점을 계산하는 calculateAverage(ArrayList<RatingDTO> temp)
    public double calculateAverage(ArrayList<RatingDTO> temp) {
        int sum = 0;
        for (RatingDTO r : temp) {
            sum += r.getRating();
        }

        return (double) sum / temp.size();
    }

    // 해당 영화의 특정 등급의 회원 평점 리스트를 리턴하는
    // selectByRank(int rank)
    public ArrayList<RatingDTO> selectByRank(UserViewer userViewer, int movieId, int rank) {
        ArrayList<RatingDTO> temp = new ArrayList<>();

        for (RatingDTO r : list) {
            // userViewer의 selectRankById 메소드 실행 결과와
            // 파라미터 rank의 값이 같을 경우
            // temp에 r을 추가한다.
            if (userViewer.selectRankById(r.getWriterId()) == rank && r.getMovieId() == movieId) {
                temp.add(new RatingDTO(r));
            }
        }

        return temp;
    }

    // 새로운 평점을 등록하는 insert(RatingDTO r)
    public void insert(RatingDTO r) {
        r.setId(nextId++);

        list.add(r);
    }

    // 회원이 탈퇴시 등록했던 평점을 모두 삭제하는
    // deleteByUserId(int userId)
    public void deleteByUserId(int userId) {
        for (int i = 0; i < list.size(); i++) {
            RatingDTO r = list.get(i);
            if (r.getWriterId() == userId) {
                list.remove(i);
                i = -1;
            }
        }
    }

    // 영화 삭제시 등록된 평점을 모두 삭제하는
    // deleteByMovieId(int movieId)
    public void deleteByMovieId(int movieId) {
        for (int i = 0; i < list.size(); i++) {
            RatingDTO r = list.get(i);
            if (r.getMovieId() == movieId) {
                list.remove(i);
                i = -1;
            }
        }
    }

}
