package Jtable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class LectureTableViewer extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    public LectureTableViewer() {
        setTitle("Lecture Table Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // JTable 초기화
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // 데이터 로드 버튼 추가
        JPanel controlPanel = new JPanel();
        JButton loadButton = new JButton("Load Lectures");
        controlPanel.add(loadButton);

        add(controlPanel, BorderLayout.NORTH);

        // 버튼 이벤트 리스너
        loadButton.addActionListener(e -> loadTableData());
    }

    private void loadTableData() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // Oracle DB URL
        String user = "system"; // Oracle 사용자 이름
        String password = "sys"; // Oracle 비밀번호

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // DB 연결
            connection = DriverManager.getConnection(url, user, password);

            // SQL 실행
            String query = "SELECT professor_name, lecture_name, lecture_time FROM C##DIT1BAN.lectures";


 // 강의 테이블 조회
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            // 테이블 모델 초기화
            tableModel.setRowCount(0); // 기존 데이터 제거
            tableModel.setColumnCount(0); // 기존 컬럼 제거

            // 컬럼 이름 설정
            tableModel.addColumn("Professor");
            tableModel.addColumn("Lecture Name");
            tableModel.addColumn("Lecture Time");

            // 데이터 추가
            while (resultSet.next()) {
                Object[] rowData = new Object[3];
                rowData[0] = resultSet.getString("professor_name");
                rowData[1] = resultSet.getString("lecture_name");
                rowData[2] = resultSet.getString("lecture_time");
                tableModel.addRow(rowData);
            }

            JOptionPane.showMessageDialog(this, "Data Loaded Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // 콘솔에서 추가 디버깅 가능
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Oracle JDBC Driver not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // 리소스 정리
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LectureTableViewer viewer = new LectureTableViewer();
            viewer.setVisible(true);
        });
    }
}
