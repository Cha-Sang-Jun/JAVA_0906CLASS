package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.RatingController;
import model.RatingDTO;
import model.UserDTO;
import util.ScannerUtil;

public class RatingViewer {
    private UserViewer userViewer;
    private UserDTO logIn;
    private Scanner scanner;
    private RatingController ratingController;

    private final int CATEGORY_ALL = 1;
    private final int RANK_CRITIC = 2;
    private final int RANK_GENERAL = 3;
    private final int RATING_MIN = 1;
    private final int RATING_MAX = 5;

    // 컨트롤러 초기화를 위한 생성자
    public RatingViewer() {
        ratingController = new RatingController();
    }

    // 의존성 주입을 위한 setter
    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    // 파라미터로 들어온 int 값과 일치하는 영화의
    // 평점 리스트를 출력하는 printList(int movieId)
    // 만약 전체 평점 리스트를 출력할 시에는 0이,
    // 전문 평론가는 2가
    // 일반 회원은 3이 파라미터로 들어오게 된다.
    public void printList(int movieId, int category) {
        ArrayList<RatingDTO> list;

        if (category == CATEGORY_ALL) {
            // 만약 전체 평점 보기일 경우,
            // ratingController의 selectAll 을 실행시켜
            // 평론가와 일반회원 모두의 평점을 불러온다.
            list = ratingController.selectAll(movieId);
        } else {
            // 그 외의 경우에는 등급 별 평점 불러오기 기능인
            // selectByRank를 실행시켜
            // 각 등급에 해당하는 평점을 불러온다.
            list = ratingController.selectByRank(userViewer, movieId, category);
        }

        if (list.isEmpty()) {
            System.out.println("등록된 평점이 존재하지 않습니다.");
            String message = new String("1. 뒤로 가기");
            ScannerUtil.nextInt(scanner, message, 1, 1);

            // 실제 사용자 입력은 1을 받았지만
            // 이 메소드를 실행시킨 MovieViewer 클래스에선
            // 사용자가 리스트가 비어있어서 1을 리턴했는지
            // 아니면 전체 평점 보기를 위해 1을 리턴했는지
            // 알 수 없다.
            // 그러므로 아래의 뒤로 가기 값인 5를 리턴하여
            // MovieViewer에서 아래 코드와 같이 처리를 할 수 있도록 만들어준다.
        } else {
            // 파라미터 category의 값에 따라
            // 전체, 평론가, 일반의 값을 가질
            // String 객체
            String temp = new String();
            if (category == CATEGORY_ALL) {
                temp = new String("전체");
            } else if (category == RANK_CRITIC) {
                temp = new String("평론가");
            } else if (category == RANK_GENERAL) {
                temp = new String("일반 회원");
            }
            System.out.printf("%s 평점: %.1f점\n", temp, ratingController.calculateAverage(list));
            for (RatingDTO r : list) {
                printOne(r);
            }
        }

    }

    // 파라미터로 들어온 RatingDTO 객체를
    // 형식에 맞추어 출력하는
    // printOne(RatingDTO r)
    private void printOne(RatingDTO r) {
        // 만약 RatingDTO 객체의 review 필드가
        // 빈 스트링일 경우, 일반 관객의 평점이므로
        // 닉네임 - 평점 의 형식으로 출력한다.
        if (r.getReview().isEmpty()) {
            // 해당 회원의 닉네임은 UserViewer의 닉네임을 출력하는 메소드인
            // printNickname(writerId) 를 사용한다.
            userViewer.printNickname(r.getWriterId());

            System.out.printf(" - %d\n", r.getRating());
        } else {
            // review 필드가 빈 스트링이 아닌 경우에는
            // 평론가의 평점이므로
            // 닉네임: "평론" - 평점 의 형식으로 출력한다.
            userViewer.printNickname(r.getWriterId());
            System.out.printf(": \"%s\" - %d\n", r.getReview(), r.getRating());
        }
    }

    // 평점 입력 메소드
    public void add(int movieId) {
        RatingDTO r = new RatingDTO();

        r.setWriterId(logIn.getId());
        r.setMovieId(movieId);

        String message;

        message = new String("해당 영화의 평점을 입력해주세요.");
        r.setRating(ScannerUtil.nextInt(scanner, message, RATING_MIN, RATING_MAX));

        // 회원의 등급이 평론가일경우,
        // 평론을 추가적으로 입력 받는다.
        if (logIn.getRank() == RANK_CRITIC) {
            message = new String("해당 영화의 평론을 입력해주세요.");
            r.setReview(ScannerUtil.nextLine(scanner, message));
        }

        ratingController.insert(r);
    }

    // RatingController 필드의 deleteByUserId()를
    // 대신 실행할 메소드
    public void deleteByWriterId(int userId) {
        ratingController.deleteByUserId(userId);
    }

    // RatingController 필드의 deleteByMovieId()를
    // 대신 실행할 메소드
    public void deleteByMovieId(int movieId) {
        ratingController.deleteByMovieId(movieId);
    }

}
