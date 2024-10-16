package Project_4;

import java.util.Scanner;
import java.util.Random;

// Player 추상 클래스
abstract class Player {
    protected String bet; // 가위, 바위, 보 중 하나의 값
    protected String name; // 플레이어의 이름
    protected String lastBet = null; // 마지막에 선택한 값 저장
    
    public Player(String name) {
        this.name = name;
    }

    public String getBet() {
        return bet;
    }

    public String getName() {
        return name;
    }

    public String getLastBet() {
        return lastBet;
    }

    public abstract String next(); // 각 플레이어마다 다른 방식으로 구현
}

// Human 클래스 (Player 상속)
class Human extends Player {
    private Scanner scanner;

    public Human(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public String next() {
        System.out.print("가위, 바위, 보! >> ");
        lastBet = scanner.next();
        return lastBet;
    }
}

// Computer 클래스 (Player 상속)
class Computer extends Player {
    private Random random;
    private String[] options = { "가위", "바위", "보" };

    public Computer(String name) {
        super(name);
        random = new Random();
    }

    @Override
    public String next() {
        lastBet = options[random.nextInt(3)];
        return lastBet;
    }
}

// Game 클래스
class Game {
    private Player[] players; // 플레이어 배열
    private Player owner; // 현재 오너 (이긴 사람)

    public Game() {
        players = new Player[2];
        Scanner scanner = new Scanner(System.in);
        players[0] = new Human("사람", scanner); // 첫 번째 플레이어는 사람
        players[1] = new Computer("컴퓨터"); // 두 번째 플레이어는 컴퓨터
    }

    public void run() {
        System.out.println("묵찌빠 게임을 시작합니다.");

        // 처음 가위바위보로 오너를 결정
        String result;
        while (true) {
            String humanChoice = players[0].next();
            String computerChoice = players[1].next();
            result = decideWinner(humanChoice, computerChoice);

            System.out.println(players[0].getName() + ">> " + humanChoice + ", " + players[1].getName() + ">> " + computerChoice);
            System.out.println(result);

            if (!result.equals("비겼습니다.")) {
                owner = result.equals("사람이 이겼습니다!") ? players[0] : players[1];
                System.out.println(owner.getName() + "이 오너가 되었습니다.");
                break;
            }
        }

        // 묵찌빠 게임 진행
        while (true) {
            String humanChoice = players[0].next();
            String computerChoice = players[1].next();
            
            System.out.println(owner.getName() + "이 오너입니다.");
            System.out.println(players[0].getName() + ">> " + humanChoice + ", " + players[1].getName() + ">> " + computerChoice);

            // 오너와 상대방의 선택이 같으면 오너가 승리
            if (humanChoice.equals(computerChoice)) {
                System.out.println(owner.getName() + "이 최종 승리했습니다!");
                break;
            }

            // 가위바위보 승리 규칙을 통해 오너를 바꿈
            result = decideWinner(humanChoice, computerChoice);
            if (!result.equals("비겼습니다.")) {
                owner = result.equals("사람이 이겼습니다!") ? players[0] : players[1];
            }
        }
    }

    // 승자를 결정하는 메서드
    private String decideWinner(String humanChoice, String computerChoice) {
        if (humanChoice.equals(computerChoice)) {
            return "비겼습니다.";
        }

        if ((humanChoice.equals("가위") && computerChoice.equals("보")) ||
            (humanChoice.equals("바위") && computerChoice.equals("가위")) ||
            (humanChoice.equals("보") && computerChoice.equals("바위"))) {
            return "사람이 이겼습니다!";
        } else {
            return "컴퓨터가 이겼습니다!";
        }
    }
}

// MGPApp 클래스 (메인 실행 클래스)
public class MGPApp {
    public static void main(String[] args) {
        new Game().run(); // 게임 실행
    }
}
