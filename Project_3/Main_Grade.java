package Project_3;

import java.util.Scanner;

class Grade {
    private String name;
    private int java;
    private int web;
    private int os;
    
    public Grade(String name, int java, int web, int os) {
        this.name = name;
        this.java = java;
        this.web = web;
        this.os = os;
    }

    public String getName() {
        return name;
    }

    public int getAverage() {
        return (java + web + os) / 3;
    }
}

public class Main_Grade {
	public static void main(String[] args) {
		
	      Scanner scanner = new Scanner(System.in);

	        System.out.print("이름, 자바, 웹, 운영체제 순으로 점수 입력>> ");
	        String name = scanner.next();
	        int java = scanner.nextInt();
	        int web = scanner.nextInt();
	        int os = scanner.nextInt();

	        Grade grade = new Grade(name, java, web, os);

	        System.out.println(grade.getName() + "의 평균은 " + grade.getAverage());

	        scanner.close();
	}

}
