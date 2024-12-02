package Project_9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.*;

public class AudioFileViewer extends JFrame {
    private Clip audioClip;

    public AudioFileViewer() {
        setTitle("Audio File Viewer");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 메뉴 바 생성
        JMenuBar menuBar = new JMenuBar();
        JMenu audioMenu = new JMenu("오디오");
        JMenuItem playItem = new JMenuItem("연주");
        JMenuItem stopItem = new JMenuItem("종료");

        // "연주" 메뉴 아이템 동작
        playItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAudio();
            }
        });

        // "종료" 메뉴 아이템 동작
        stopItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAudio();
            }
        });

        // 메뉴 추가
        audioMenu.add(playItem);
        audioMenu.addSeparator(); // 구분선 추가
        audioMenu.add(stopItem);
        menuBar.add(audioMenu);

        setJMenuBar(menuBar);

        setVisible(true);
    }

    private void playAudio() {
        // 오디오 파일 선택
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("WAV 파일", "wav"));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File audioFile = fileChooser.getSelectedFile();

            try {
                // 기존 재생 중인 오디오가 있다면 정지
                if (audioClip != null && audioClip.isRunning()) {
                    audioClip.stop();
                    audioClip.close();
                }

                // 새로운 오디오 파일 로드 및 재생
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                audioClip = AudioSystem.getClip();
                audioClip.open(audioStream);
                audioClip.start();

                JOptionPane.showMessageDialog(this, "오디오 연주를 시작합니다: " + audioFile.getName());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "오디오 파일을 재생할 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void stopAudio() {
        // 오디오 정지
        if (audioClip != null && audioClip.isRunning()) {
            audioClip.stop();
            audioClip.close();
            JOptionPane.showMessageDialog(this, "오디오 연주를 종료합니다.");
        } else {
            JOptionPane.showMessageDialog(this, "재생 중인 오디오가 없습니다.");
        }
    }

    public static void main(String[] args) {
        new AudioFileViewer();
    }
}

