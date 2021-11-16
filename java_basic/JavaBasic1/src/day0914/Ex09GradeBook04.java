package day0914;
// 2차원 배열을 사용하여 

import java.util.Scanner;

// 5명의 학생의 입력과 출력을 담당하는 프로그램을 작성하세요.
// 단 무한루프를 사용하여 메뉴를 만들어야 하고 
// 학생의 정보를 출력하는 부분은 메소드로 만들어져야 합니다.

public class Ex09GradeBook04 {
    public static void main(String[] args) {
        // 상수
        // 1. 과목 숫자
        final int SUBJECT_SIZE = 3;
        // 2. 학생 숫자
        final int STUDENT_SIZE = 5;

        // 변수
        // 1. Scanner 변수
        Scanner scanner = new Scanner(System.in);
        // 2. 번호 배열
        int[] idArray = new int[STUDENT_SIZE];
        // 3. 이름 배열
        String[] nameArray = new String[STUDENT_SIZE];
        // 4. 점수를 담당하는 2차원 배열
        int[][] scoreArray = new int[STUDENT_SIZE][SUBJECT_SIZE];
        // 5. 다음에 입력'할' 인덱스를 저장한 int 변수
        int curIndex = 0;
        // 위의 curIndex를 사용하면
        // 한명도 입력이 안된 상태에서 출력을 할 시에는
        // "아직 입력된 학생의 정보가 없습니다" 를 출력하거나
        // 혹은 5명을 초과하여 입력할 시에는
        // "더이상 입력하실 수 없습니다" 라고 출력해 줄수도 있고
        // 출력 시에는 현재 입력된 학생들만 출력이 가능하다.

        while (true) {
            System.out.println("1. 입력 2. 출력 3. 종료");
            System.out.print("> ");
            int userChoice = scanner.nextInt();

            if (userChoice == 1) {
                // 입력 코드 구현

                if (curIndex < STUDENT_SIZE) {
                    // 각 배열의 curIndex번 인덱스에
                    // 정보를 입력한다.

                    // 번호 입력
                    System.out.println("번호를 입력해주세요.");
                    System.out.print("> ");
                    idArray[curIndex] = scanner.nextInt();

                    // 이름 입력
                    System.out.println("이름을 입력해주세요.");
                    System.out.print("> ");
                    scanner.nextLine();
                    nameArray[curIndex] = scanner.nextLine();

                    // 국어 입력
                    System.out.println("국어 점수를 입력해주세요.");
                    System.out.print("> ");
                    scoreArray[curIndex][0] = scanner.nextInt();

                    while (!(scoreArray[curIndex][0] >= 0 && scoreArray[curIndex][0] <= 100)) {
                        System.out.println("잘못 입력하셨습니다.");

                        System.out.println("국어 점수를 입력해주세요.");
                        System.out.print("> ");
                        scoreArray[curIndex][0] = scanner.nextInt();
                    }

                    // 영어 입력
                    System.out.println("영어 점수를 입력해주세요.");
                    System.out.print("> ");
                    scoreArray[curIndex][1] = scanner.nextInt();

                    while (!(scoreArray[curIndex][1] >= 0 && scoreArray[curIndex][1] <= 100)) {
                        System.out.println("잘못 입력하셨습니다.");

                        System.out.println("영어 점수를 입력해주세요.");
                        System.out.print("> ");
                        scoreArray[curIndex][1] = scanner.nextInt();
                    }

                    // 수학 입력
                    System.out.println("수학 점수를 입력해주세요.");
                    System.out.print("> ");
                    scoreArray[curIndex][2] = scanner.nextInt();

                    while (!(scoreArray[curIndex][2] >= 0 && scoreArray[curIndex][2] <= 100)) {
                        System.out.println("잘못 입력하셨습니다.");

                        System.out.println("수학 점수를 입력해주세요.");
                        System.out.print("> ");
                        scoreArray[curIndex][2] = scanner.nextInt();
                    }

                    curIndex++;

                } else {
                    // 더이상 입력할 수 없음을 알린다.
                    System.out.println("5명을 초과한 학생의 정보는 더이상 입력하실 수 없습니다.");
                }

            } else if (userChoice == 2) {
                // 출력 코드 구현
                if (curIndex == 0) {
                    // 아직 입력된 학생이 존재하지 않으므로 경고 메시지만 출력
                    System.out.println("아직 입력된 학생이 존재하지 않습니다.");

                } else {
                    // 0번 인덱스부터 curIndex 보다 작은 인덱스까지 출력
                    for (int i = 0; i < curIndex; i++) {
                        System.out.println("----------------------------");
                        System.out.println(nameArray[i] + " 학생의 정보");
                        System.out.println("----------------------------");

                        // 이번에 출력할 학생의 번호
                        int id = idArray[i];

                        // 이번에 출력할 학생의 이름
                        String name = nameArray[i];

                        // 이번에 출력할 할생의 국어 점수
                        int korean = scoreArray[i][0];

                        // 이번에 출력할 학생의 영어 점수
                        int english = scoreArray[i][1];

                        // 이번에 출력할 학생의 수학 점수
                        int math = scoreArray[i][2];

                        printInfo(id, name, korean, english, math);
                        
                        System.out.println("============================\n");
                    }

                }

            } else if (userChoice == 3) {
                // 종료 코드 구현
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }

        scanner.close();
    }

    public static void printInfo(int id, String name, int korean, int english, int math) {
        final int SUBJECT_SIZE = 3;

        int sum = korean + english + math;
        double average = (double) sum / SUBJECT_SIZE;

        System.out.printf("번호: %d번 이름: %s\n", id, name);
        System.out.printf("국어: %03d점 영어: %03d점 수학: %03d점\n", korean, english, math);
        System.out.printf("총점: %03d점 평균: %06.2f점\n", sum, average);
    }
}
