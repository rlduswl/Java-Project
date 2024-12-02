package Project_9;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleMenuExample extends JFrame {
    public SimpleMenuExample() {
        setTitle("Simple Menu Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("파일");
        JMenuItem openItem = new JMenuItem("열기");
        JMenuItem saveItem = new JMenuItem("저장");
        JMenuItem exitItem = new JMenuItem("종료");

        openItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "열기 선택됨"));
        saveItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "저장 선택됨"));
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); 
        fileMenu.add(exitItem);

        
        JMenu editMenu = new JMenu("편집");
        JMenuItem copyItem = new JMenuItem("복사");
        JMenuItem pasteItem = new JMenuItem("붙여넣기");

        copyItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "복사 선택됨"));
        pasteItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "붙여넣기 선택됨"));

        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // 세 번째 메뉴 생성
        JMenu viewMenu = new JMenu("보기");
        JMenuItem zoomInItem = new JMenuItem("확대");
        JMenuItem zoomOutItem = new JMenuItem("축소");

        // 보기 메뉴 아이템에 동작 추가
        zoomInItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "확대 선택됨"));
        zoomOutItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "축소 선택됨"));

        viewMenu.add(zoomInItem);
        viewMenu.add(zoomOutItem);

        // 네 번째 메뉴 생성
        JMenu helpMenu = new JMenu("도움말");
        JMenuItem aboutItem = new JMenuItem("정보");

        // 도움말 메뉴 아이템에 동작 추가
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "이 프로그램은 메뉴 예제입니다."));

        helpMenu.add(aboutItem);

        // 메뉴 바에 메뉴 추가
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        // 프레임에 메뉴 바 설정
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleMenuExample();
    }
}
