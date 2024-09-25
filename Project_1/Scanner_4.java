package ScanneQuiz;

import java.util.Scanner;

public class Scanner_4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("여행지 >> ");
		String travel = sc.nextLine();
		
		System.out.print("인원 수 >> ");
		int people = sc.nextInt();
		
		System.out.print("숙박일 >> ");
		int lodgment = sc.nextInt();
		
		System.out.print("1인 항공료 >> ");
		int aviation = sc.nextInt();
		
		System.out.print("1인 숙박비 >> ");
		int money = sc.nextInt();
		
		System.out.print(people + "명의 " + travel +" "+ lodgment + "박 " + (lodgment+1) + "일 여행에는 방이 " + (people + 1) / 2 + "개 필요하며 경비는 ");
		
		if (people%2 == 0) {
			System.out.println((((people / 2)* money) * lodgment) + (aviation*people) + "원 입니다");
		} else {
			System.out.println(((((people+1)/ 2)* money) * lodgment)+(aviation*people) + "원 입니다");
		}
		
		sc.close();
	}
}
