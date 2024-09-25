package ScanneQuiz;

import java.util.Scanner;

public class Scanner_3 {
	public static void main(String[] args) {
		System.out.println("**** 자바 분식입니다. 주문하시면 금액을 알려드립니다. *****");
		
		System.out.print("떡볶이 몇 인분 >> ");
		Scanner scanner1 = new Scanner(System.in);
		int sc1 = scanner1.nextInt(); // 떡볶이
		
		System.out.print("김말이 몇 인분 >> ");
		Scanner scanner2 = new Scanner(System.in);
		int sc2 = scanner2.nextInt(); // 김말이
		
		System.out.print("쫄면 몇 인분 >> ");
		Scanner scanner3 = new Scanner(System.in);
		int sc3 = scanner3.nextInt(); // 쫄면 
		
		System.out.println("전체 금액은 " + ((sc1*2000) + (sc2*1000) + (sc3*3000)) + "원 입니다");
		
		scanner1.close();
		scanner2.close();
		scanner3.close();
	}

}
