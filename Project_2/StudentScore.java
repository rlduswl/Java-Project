package Project_2;

import java.util.InputMismatchException;

import java.util.Scanner;

public class StudentScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] studentIds = new int[10];  
        int[] studentScores = new int[10];  
        
        System.out.println("10명 학생의 학번과 점수 입력 ");
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print((i + 1) + ">> ");
                studentIds[i] = scanner.nextInt();
                studentScores[i] = scanner.nextInt();
            }

            while (true) {
                try {
                    System.out.print("학번으로 검색 : 1 | 점수로 검색 : 2 | 끝내려면 3 >> ");
                    int option = scanner.nextInt();
                    
                    if (option == 1) {
                        System.out.print("학번 >> ");
                        int searchId = scanner.nextInt();
                        
                        boolean found = false;
                        for (int i = 0; i < 10; i++) {
                            if (studentIds[i] == searchId) {
                                System.out.println("학번 " + searchId + "의 점수는: " + studentScores[i]);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println(searchId + "인 학생은 없습니다.");
                        }
                        
                    } else if (option == 2) { 
                        System.out.print("점수 >>  ");
                        int searchScore = scanner.nextInt();
                        
                        boolean found = false;
                        StringBuilder ids = new StringBuilder();
                        for (int i = 0; i < 10; i++) {
                            if (studentScores[i] == searchScore) {
                                ids.append(studentIds[i]).append(" ");
                                found = true;
                            }
                        }
                        if (found) {
                            System.out.println("점수가 " + searchScore + "인 학생은 " + ids.toString() + "입니다.");
                        } else {
                            System.out.println("점수가 " + searchScore + "인 학생은 없습니다.");
                        }
                        
                    } else if (option == 3) {
                        System.out.println("프로그램을 종료합니다.");
                        break;
                    } else {
                        System.out.println("잘못된 선택입니다. 다시 선택하세요.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("경고!! 정수를 입력해야 합니다.");
                    scanner.nextLine(); 
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("경고!! 학번과 점수는 정수여야 합니다.");
        } finally {
            scanner.close();
        }
    }
}
