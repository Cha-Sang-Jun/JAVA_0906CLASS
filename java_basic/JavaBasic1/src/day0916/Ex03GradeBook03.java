package day0916;
// 동적 할당을 사용한 학생 관리프로그램2

// 전역 변수를 적용시킨 버젼

import java.util.Scanner; 

import util.ArrayUtil;
import util.ScannerUtil;

public class Ex03GradeBook03 {
    // 전역 상수
    static final int MAX_STUDENT = 5;
    static final int SUBJECT_SIZE = 3;
    static final int SCORE_MIN = 0;
    static final int SCORE_MAX = 100;

    // 전역 변수
    static Scanner scanner = new Scanner(System.in);
    static int[] idArray = new int[0];
    static String[] nameArray = new String[0];
    static int[] koreanArray = new int[0];
    static int[] englishArray = new int[0];
    static int[] mathArray = new int[0];

    // 1. 입력을 담당하는 insert() 메소드
    public static void insert() {
        if (ArrayUtil.size(idArray) < MAX_STUDENT) {
            String message;

            message = "번호를 입력해주세요.";
            int id = ScannerUtil.nextInt(scanner, message);
            idArray = ArrayUtil.add(idArray, id);

            message = "이름을 입력해주세요.";
            String name = ScannerUtil.nextLine(scanner, message);
            nameArray = ArrayUtil.add(nameArray, name);

            message = "국어 점수를 입력해주세요.";
            int korean = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
            koreanArray = ArrayUtil.add(koreanArray, korean);

            message = "영어 점수를 입력해주세요.";
            int english = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
            englishArray = ArrayUtil.add(englishArray, english);

            message = "수학 점수를 입력해주세요.";
            int math = ScannerUtil.nextInt(scanner, message, SCORE_MIN, SCORE_MAX);
            mathArray = ArrayUtil.add(mathArray, math);
        } else {
            System.out.println("==============================\n");
            System.out.println("더 이상 입력하실 수 없습니다.");
            System.out.println("\n==============================\n");
        }

    }

    // 2. 목록 출력을 담당하는 printAll() 메소드
    public static void printAll() {
        if (ArrayUtil.isEmpty(idArray)) {
            System.out.println("--------------------------------\n");
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
            System.out.println("\n--------------------------------");
        } else {
            for (int i = 0; i < ArrayUtil.size(idArray); i++) {
                System.out.println("-----------------------------\n");
                printOne(i);
                System.out.println("\n-----------------------------");
            }
        }
    }

    // 3. 개별 정보 출력을 담당하는 printOne() 메소드
    public static void printOne(int index) {
        int id = ArrayUtil.get(idArray, index);
        String name = ArrayUtil.get(nameArray, index);
        int korean = ArrayUtil.get(koreanArray, index);
        int english = ArrayUtil.get(englishArray, index);
        int math = ArrayUtil.get(mathArray, index);

        int sum = korean + english + math;
        double average = (double) sum / SUBJECT_SIZE;

        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
    }

    // 4. 메뉴 출력을 담당하는 showMenu() 메소드
    public static void showMenu() {
        while (true) {
            String message = "1. 입력 2. 출력 3. 종료";
            int userChoice = ScannerUtil.nextInt(scanner, message);

            if (userChoice == 1) {
                // 입력을 담당하는 메소드 호출
                insert();
            } else if (userChoice == 2) {
                // 목록 출력을 담당하는 메소드 호출
                printAll();
            } else if (userChoice == 3) {
                // 종료 코드 실행
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    // 5. 메인 메소드
    public static void main(String[] args) {
        // 메뉴 메소드 호출
        showMenu();

        // 메뉴 메소드 종료 시, Scanner 클래스 변수를 닫아준다.
        scanner.close();
    }
}
