package Project_3;

import java.util.Scanner;


class DayDiary {
    private String content;  // 일기 내용

    public DayDiary() {
        this.content = "";
    }

    // 일기 쓰기
    public void write(String content) {
        this.content = content;
    }

    // 일기 보기
    public String show() {
        return content.isEmpty() ? "..." : content;
    }
}

class MonthDiary {
    private int year, month;
    private DayDiary[] days;

    public MonthDiary(int year, int month) {
        this.year = year;
        this.month = month;
        this.days = new DayDiary[30];
        for (int i = 0; i < days.length; i++) {
            days[i] = new DayDiary();
        }
    }

    private void showMenu() {
    	System.out.println("**** 2024년 10월 다이어리 ****");
        System.out.println("기록: 1, 보기: 2, 종료: 3 >> ");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1: 
                    System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자 이하) >> ");
                    int day = scanner.nextInt();
                    if (day < 1 || day > 30) {
                        System.out.println("잘못된 날짜입니다.");
                        break;
                    }
                    String content = scanner.next();
                    if (content.length() > 4) {
                        System.out.println("글자는 4글자 이하만 가능합니다.");
                        break;
                    }
                    days[day - 1].write(content);
                    System.out.println(day + "일의 내용이 기록되었습니다.");
                    break;

                case 2:  
                    for (int i = 0; i < 30; i++) {
                        if ((i + 1) % 7 == 0) {
                            System.out.println();
                        }
                        System.out.print(days[i].show() + "\t");
                    }
                    System.out.println();
                    break;

                case 3: 
                    return;

                default:
                    System.out.println("잘못된 선택입니다.");
                    break;
            }
        }
    }
}

public class Main_DayDiary {
    public static void main(String[] args) {
        MonthDiary monthDiary = new MonthDiary(2024, 10);  // 2024년 10월 다이어리 생성
        monthDiary.run(); 
    }
}

