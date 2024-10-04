package Project_3;

import java.util.Scanner;

class Dictionary {
	
    private static String[] kor = { "사랑", "아기", "돈", "미래", "희망" };
    private static String[] eng = { "love", "baby", "money", "future", "hope" };

    // 한글 단어를 영어로 변환
    public static String kor2Eng(String word) {
        for (int i = 0; i < kor.length; i++) {
            if (kor[i].equals(word)) {  // 입력된 단어가 배열에 있는지 확인
                return eng[i];  // 해당하는 영어 단어 반환
            }
        }
        return "단어가 없습니다.";  // 단어가 없을 경우 메시지 반환
    }
}

public class Main_Dictionary{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램입니다.");

        while (true) {
            System.out.print("한글 단어? ");
            String word = scanner.next();

            if (word.equals("그만")) {  
                break;
            }

            System.out.println(word + "은(는) " + Dictionary.kor2Eng(word));
        }

        scanner.close();
    }
}
