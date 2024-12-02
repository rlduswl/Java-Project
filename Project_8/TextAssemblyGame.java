package Project_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TextAssemblyGame extends JFrame {
    private String[] predefinedTexts = {
            "Java is a powerful language",
            "Coding is fun and rewarding",
            "Practice makes perfect",
            "Learning new things is exciting"
    };
    private String[] currentWords; // 현재 문장을 단어로 나눈 배열
    private ArrayList<JButton> wordButtons = new ArrayList<>(); // 단어 버튼 리스트
    private StringBuilder userProgress = new StringBuilder(); // 사용자가 클릭한 단어의 진행상황
    private String currentText; // 현재 선택된 문장
    private int currentWordIndex = 0; // 다음에 클릭해야 할 단어의 인덱스

    private JLabel progressLabel; // 하단에 완성된 문장을 표시
    private JPanel gamePanel; // 단어 버튼들이 표시되는 영역

    public TextAssemblyGame() {
        setTitle("Text Assembly Game");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 상단 패널: New Text 버튼
        JPanel topPanel = new JPanel();
        JButton newTextButton = new JButton("New Text");
        topPanel.add(newTextButton);

        // 중앙 패널: 게임 영역
        gamePanel = new JPanel();
        gamePanel.setLayout(null); // 자유 배치
        gamePanel.setBackground(Color.WHITE);

        // 하단 패널: 진행 상태 레이블
        JPanel bottomPanel = new JPanel();
        progressLabel = new JLabel("Press 'New Text' to start.");
        progressLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bottomPanel.add(progressLabel);

        // New Text 버튼 이벤트
        newTextButton.addActionListener(e -> startNewGame());

        add(topPanel, BorderLayout.NORTH);
        add(gamePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void startNewGame() {
        // 초기화
        gamePanel.removeAll();
        wordButtons.clear();
        userProgress.setLength(0);
        progressLabel.setText("Assemble the sentence!");

        // 랜덤 문장 선택
        Random random = new Random();
        currentText = predefinedTexts[random.nextInt(predefinedTexts.length)];
        currentWords = currentText.split("\\s+");
        currentWordIndex = 0;

        // 단어 섞기
        ArrayList<String> shuffledWords = new ArrayList<>();
        Collections.addAll(shuffledWords, currentWords);
        Collections.shuffle(shuffledWords);

        // 단어 버튼 생성 및 랜덤 위치에 배치
        for (String word : shuffledWords) {
            JButton wordButton = new JButton(word);
            wordButton.setFont(new Font("Arial", Font.PLAIN, 14));
            wordButton.setSize(100, 30);
            int x = random.nextInt(gamePanel.getWidth() - 100);
            int y = random.nextInt(gamePanel.getHeight() - 30);
            wordButton.setLocation(x, y);

            // 단어 버튼 클릭 이벤트
            wordButton.addActionListener(e -> handleWordClick(wordButton));

            gamePanel.add(wordButton);
            wordButtons.add(wordButton);
        }

        gamePanel.revalidate();
        gamePanel.repaint();
    }

    private void handleWordClick(JButton wordButton) {
        String clickedWord = wordButton.getText();

        // 클릭한 단어가 다음 단어인지 확인
        if (clickedWord.equals(currentWords[currentWordIndex])) {
            userProgress.append(clickedWord).append(" ");
            progressLabel.setText(userProgress.toString().trim());
            wordButton.setEnabled(false); // 클릭된 버튼 비활성화
            currentWordIndex++;

            // 문장 완성 확인
            if (currentWordIndex == currentWords.length) {
                progressLabel.setText("Congratulations! You completed the sentence: " + currentText);
                JOptionPane.showMessageDialog(this, "You won! Well done!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect word! Try again.");
        }
    }

    public static void main(String[] args) {
        new TextAssemblyGame();
    }
}

