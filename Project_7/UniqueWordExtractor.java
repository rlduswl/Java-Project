package Project_7;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueWordExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 문자열 입력 받기
            System.out.println("문자열을 입력하세요 (종료하려면 '그만' 입력):");
            String sentence = scanner.nextLine();

            // 종료 조건
            if (sentence.equals("그만")) {
                break;
            }

            // 단어 분리 및 중복 제거
            String[] words = sentence.split(" "); 
            LinkedHashSet<String> uniqueWords = new LinkedHashSet<>();

            for (String word : words) {
                uniqueWords.add(word); 
            }


            for (String word : uniqueWords) {
                System.out.print(word + " ");
            }
            System.out.println(); 
        }
    }
}
