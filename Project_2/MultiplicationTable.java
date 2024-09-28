package Project_2;

import java.util.Scanner;

public class MultiplicationTable {
	public static void main(String[] args) {
		int count = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**** 구구단을 맞추는 퀴즈입니다. ****");
		
		while(count < 3) {
			int rand1 = (int)(Math.random()*9) + 1;
			int rand2 = (int)(Math.random()*9) + 1;
			int CorrectAnswer = rand1 * rand2; // 정답
			
			System.out.print(rand1 + " X " + rand2 + " = ");
			int Answer = sc.nextInt(); // 내가 작성한 답
			
			if (CorrectAnswer == Answer) {
				System.out.println("정답입니다. 잘했어요");
			}else {
				count++;
				System.out.println(count+"번 틀렸습니다. 분발하세요");
			}
			
		}
		
		System.out.println("퀴즈를 종료합니다.");
	}

}
