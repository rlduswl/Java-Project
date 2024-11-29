package Project_7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhoneBookSaver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder phoneBook = new StringBuilder(); // 데이터를 임시 저장할 StringBuilder

        System.out.println("전화번호 입력 프로그램입니다.");
        System.out.println("이름과 전화번호를 입력하세요");

        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine();

            // 종료 조건
            if (input.equals("그만")) {
                break;
            }

            // 입력된 내용을 저장
            phoneBook.append(input).append("\n");
        }

        // 파일에 저장
        try {
            // 파일 경로 설정
            String filePath = "c:\\temp\\phone.txt";

            // FileWriter를 사용해 파일에 쓰기
            FileWriter writer = new FileWriter(filePath);
            writer.write(phoneBook.toString()); // StringBuilder 내용을 파일에 기록
            writer.close();

            System.out.println(filePath + "에 저장하였습니다.");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }

        scanner.close();
    }
}
