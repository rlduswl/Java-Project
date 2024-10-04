package Project_3;

import java.util.Scanner;

class Player {
    private String name;
    private int guess;
    private int score;  // 승점

    public Player(String name) {
        this.name = name;
        this.score = 0;  
    }

    public void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.print(name + ">> ");
        guess = scanner.nextInt();
    }

    public int getGuess() {
        return guess;
    }

    public String getName() {
        return name;
    }

    // 승점을 1점 증가
    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}

class GuessGame {
    private Player[] players;
    private int hiddenNumber; // 랜덤 숫자

    public GuessGame(String[] playerNames) {
        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
    }

    private void generateHiddenNumber() {
        hiddenNumber = (int) (Math.random() * 100) + 1; 
    }

    public void startGame() {
        generateHiddenNumber();
        System.out.println(" **** 예측 게임을 시작합니다 **** ");

        for (Player player : players) {
            player.guessNumber();
        }

        // 가장 가까운 숫자를 찾기
        Player winner = findWinner();

        System.out.println("정답은 " + hiddenNumber + "입니다! " + winner.getName() + "이 이겼습니다. 승점 1점 확보!");
        winner.addScore();
    }

    // 승자를 찾기
    private Player findWinner() {
        Player winner = players[0];
        int minDifference = Math.abs(hiddenNumber - winner.getGuess());

        for (Player player : players) {
            int difference = Math.abs(hiddenNumber - player.getGuess());
            if (difference < minDifference) {
                winner = player;
                minDifference = difference;
            }
        }
        return winner;
    }

    public void showScores() {
        System.out.println("현재 모든 플레이어의 승점:");
        for (Player player : players) {
            System.out.print(player.getName() + ": " + player.getScore() + "점  2");
        }
    }

    public Player findFinalWinner() {
        Player finalWinner = players[0];
        for (Player player : players) {
            if (player.getScore() > finalWinner.getScore()) {
                finalWinner = player;
            }
        }
        return finalWinner;
    }
}

public class Main_Player {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("게임에 참여할 선수 수 >> ");
        int numPlayers = scanner.nextInt();
        String[] playerNames = new String[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("선수 이름 >> ");
            playerNames[i] = scanner.next();
        }

        GuessGame game = new GuessGame(playerNames);

        while (true) {
            game.startGame();
            System.out.print("계속하시겠습니까? (yes/no): ");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("yes")) {
                game.showScores();
                break;
            }
        }

        Player finalWinner = game.findFinalWinner();
        System.out.println();
        System.out.println("최종 승자는 " + finalWinner.getName() + "입니다!");

        scanner.close();
    }
}
