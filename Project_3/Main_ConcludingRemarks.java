package Project_3;

import java.util.Scanner;

class playerinput {
    private String name;  // 플레이어 이름

    // 생성자: 플레이어 이름을 저장
    public playerinput(String name) {
        this.name = name;
    }

    // 플레이어 이름 반환
    public String getName() {
        return name;
    }

    // 플레이어가 단어를 입력하는 메서드
    public String sayWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(name + ">> ");
        return scanner.next();
    }
}

class WordGameApp {
    private playerinput[] players;  // 게임에 참여하는 플레이어 배열
    private String currentWord = "아버지";  // 첫 번째 단어
    private int playerCount;  // 플레이어 수
    private Scanner scanner = new Scanner(System.in);

    // 게임을 시작하는 메서드
    public void run() {
        System.out.println("끝말잇기 게임을 시작합니다...");
        System.out.print("게임에 참가하는 인원은 몇명입니까? ");
        playerCount = scanner.nextInt();
        players = new playerinput[playerCount];

        // 각 플레이어의 이름을 입력받아 playerinput 객체 생성
        for (int i = 0; i < playerCount; i++) {
            System.out.print("참가자의 이름을 입력하세요 >> ");
            String name = scanner.next();
            players[i] = new playerinput(name);
        }

        // 게임 진행
        int currentPlayerIndex = 0;  // 현재 차례인 플레이어 인덱스
        System.out.println("시작 단어는 '아버지'입니다.");
        while (true) {
            String lastWord = currentWord;  // 현재 단어를 기억
            playerinput currentPlayer = players[currentPlayerIndex];  // 현재 플레이어

            // 현재 플레이어가 단어 입력
            String newWord = currentPlayer.sayWord();

            // 단어가 규칙에 맞는지 확인
            if (!checkSuccess(lastWord, newWord)) {
                System.out.println(currentPlayer.getName() + "이 졌습니다.");
                break;
            }

            // 현재 단어 업데이트
            currentWord = newWord;

            // 다음 플레이어로 차례 넘기기
            currentPlayerIndex = (currentPlayerIndex + 1) % playerCount;
        }
    }

    // 이전 단어의 마지막 글자와 새 단어의 첫 글자를 비교하는 메서드
    private boolean checkSuccess(String lastWord, String newWord) {
        // 이전 단어의 마지막 글자와 새 단어의 첫 글자 비교
        char lastChar = lastWord.charAt(lastWord.length() - 1);  // 이전 단어의 마지막 글자
        char firstChar = newWord.charAt(0);  // 새 단어의 첫 글자
        return lastChar == firstChar;  // 글자가 일치하면 true, 아니면 false
    }
}

public class Main_ConcludingRemarks {
    public static void main(String[] args) {
        WordGameApp game = new WordGameApp();
        game.run();  // 게임 시작
    }
}
