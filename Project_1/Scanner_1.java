package ScanneQuiz;

import java.util.Scanner;

public class Scanner_1 {
	public static void main(String[] args) {
		System.out.print("$1=1200원 입니다. 달러를 입력하세요 >> ");
		
		Scanner sc = new Scanner(System.in);
		int dollar =sc.nextInt();
		
		System.out.println("$" + dollar + "는 "+ dollar*1200 + "원 입니다");
		sc.close();
	}

}
