package Project_2;

import java.util.Scanner;

public class Grade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        String[] course = {"C", "C++", "Python", "Java", "HTML5"};
        String[] grade = {"A+", "B+", "B", "A+", "D"};
        
        while (true) {

            System.out.print("과목 >> ");
            String courseName = sc.nextLine();

            if (courseName.equals("그만")) {
                break;
            }

            boolean found = false;
            for (int i = 0; i < course.length; i++) {
                if (course[i].equals(courseName)) {
                    System.out.println(course[i] + "의 학점은 " + grade[i] + "입니다.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(courseName + "는 없는 과목입니다.");
            }
        }
	}
}
