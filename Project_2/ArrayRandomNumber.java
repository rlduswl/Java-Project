package Project_2;

import java.util.Scanner;

public class ArrayRandomNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum =0;
		
		System.out.print("정수 몇 개 저장하시겠습니까? >> ");
		int n = sc.nextInt();
		int num[] = new int[n];
		
		System.out.print("랜덤한 정수들 >> ");
		for (int i=0; i<n; i++) {
			int rand = (int)(Math.random()*100) + 1;
			num[i] = rand; 
			sum+=num[i];
			System.out.print(num[i] + " ");
		}
		System.out.println();
		double avg = sum / (double) n;
		System.out.print("평균은 >> " + avg);
	}

}
