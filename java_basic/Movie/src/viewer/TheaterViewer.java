package viewer;

import java.util.ArrayList;
import java.util.Scanner;

import controller.TheaterController;
import model.TheaterDTO;
import model.UserDTO;
import util.ScannerUtil;

public class TheaterViewer {

    private ShowViewer showViewer;
    private UserDTO logIn;
    private Scanner scanner;
    private TheaterController theaterController;

    private final int RANK_ADMIN = 1;

    // 컨트롤러 초기화를 위한 생성자
    public TheaterViewer() {
        theaterController = new TheaterController();
    }

    // 의존성 주입을 위한 setter
    public void setShowViewer(ShowViewer showViewer) {
        this.showViewer = showViewer;
    }

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    // 관리자용 극장 메뉴 메소드
    public void printAdminMenu() {
        String message = new String("1. 극장 목록 보기 2. 새로운 극장 추가 3. 뒤로 가기");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                add();
            } else if (userChoice == 3) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }
        }
    }

    // 비관리자용 극장 메뉴 메소드
    public void printNonAdminMenu() {
        String message = new String("1. 극장 목록 보기 2. 뒤로 가기");
        while (true) {
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                System.out.println("메인 화면으로 돌아갑니다.");
                break;
            }
        }
    }

    // 극장 전체 목록 출력 메소드
    public void printList() {
        ArrayList<TheaterDTO> list = theaterController.selectAll();

        if (list.isEmpty()) {
            System.out.println("등록된 극장이 존재하지 않습니다.");
        } else {
            for (TheaterDTO t : list) {
                System.out.printf("%d. %s\n", t.getId(), t.getName());
            }

            String temp = new String("상세보기할 극장의 번호나 뒤로 가실려면 0을 입력해주세요.");
            int userChoice = ScannerUtil.nextInt(scanner, temp);

            if (userChoice != 0 && theaterController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, temp);
            }

            if (userChoice != 0) {
                printOne(userChoice);
            }
        }
    }

    // 개별 극장 출력 메소드
    private void printOne(int id) {
        TheaterDTO t = theaterController.selectOne(id);

        System.out.println("------------------------------------");
        System.out.println(t.getName() + " 극장의 정보");
        System.out.println("------------------------------------");
        System.out.println("전화 번호: " + t.getPhoneNumber());
        System.out.println("------------------------------------");
        System.out.println("극장 주소: " + t.getLocation());
        System.out.println("------------------------------------");
        System.out.println(t.getName() + " 극장의 상영 정보");
        showViewer.printListByTheaterId(id);

        String message;
        if (logIn.getRank() == RANK_ADMIN) {
            message = new String("1. 극장 정보 수정 2. 극장 정보 삭제 3. 뒤로 가기");
            int userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);

            if (userChoice == 1) {
                update(id);
            } else if (userChoice == 2) {
                delete(id);
            } else if (userChoice == 3) {
                printList();
            }
        } else {
            message = new String("1. 뒤로 가기");
            ScannerUtil.nextInt(scanner, message, 1, 1);
            printList();
        }
    }

    // 극장 정보 추가 메소드
    private void add() {
        TheaterDTO t = new TheaterDTO();

        String message;

        message = new String("극장의 이름을 입력해주세요.");
        t.setName(ScannerUtil.nextLine(scanner, message));

        message = new String("극장의 전화번호를 입력해주세요.");
        t.setPhoneNumber(ScannerUtil.nextLine(scanner, message));

        message = new String("극장의 주소를 입력해주세요.");
        t.setLocation(ScannerUtil.nextLine(scanner, message));

        theaterController.insert(t);
    }

    // 극장 정보 수정 메소드
    private void update(int id) {
        TheaterDTO t = theaterController.selectOne(id);

        String message;

        message = new String("새로운 전화번호를 입력해주세요.");
        t.setPhoneNumber(ScannerUtil.nextLine(scanner, message));

        message = new String("새로운 주소를 입력해주세요.");
        t.setLocation(ScannerUtil.nextLine(scanner, message));

        theaterController.update(t);
        printOne(id);
    }

    // 극장 정보 삭제 메소드
    private void delete(int id) {
        String message = new String("정말로 삭제하시겠습니까? Y/N");
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            theaterController.delete(id);
            showViewer.deleteByTheaterId(id);
            printList();
        } else {
            printOne(id);
        }
    }

    // 극장 이름 출력 메소드
    public void printName(int id) {
        TheaterDTO t = theaterController.selectOne(id);
        System.out.print(t.getName());
    }

    // 극장 목록을 간략하게 출력하고
    // 관리자가 특정 극장을 선택할 수 있게 하는 메소드
    public int printIdName() {
        int userChoice = 0;

        ArrayList<TheaterDTO> list = theaterController.selectAll();
        if (list.isEmpty()) {
            System.out.println("등록된 극장이 존재하지 않습니다.");
        } else {
            for (TheaterDTO t : list) {
                System.out.printf("%d. %s\n", t.getId(), t.getName());
            }

            String message = new String("극장의 번호나 뒤로 가실려면 0을 입력해주세요.");
            userChoice = ScannerUtil.nextInt(scanner, message);

            while (userChoice != 0 && theaterController.selectOne(userChoice) == null) {
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(scanner, message);
            }
        }

        return userChoice;
    }

}
