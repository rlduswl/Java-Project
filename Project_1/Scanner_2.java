package ScanneQuiz;

import java.util.Scanner;

public class Scanner_2 {
	public static void main(String[] args) {
		System.out.print("생일 입력 하세요 >>");
		
		Scanner sc = new Scanner(System.in);
		int Birthday = sc.nextInt();
		
		System.out.println(Birthday/10000 + "년" + (Birthday%10000)/100 + "월" + Birthday%100 + "일");
		sc.close();
	}

}
