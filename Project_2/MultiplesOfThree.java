package Project_2;

import java.util.Scanner;

public class MultiplesOfThree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num[] = new int [10];
		
		System.out.print("양의 정수 10개 입력 >> ");
		for (int i=0; i<num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		System.out.print("3의 배수는 >>");
		for (int i=0; i<num.length; i++) {
			if (num[i] % 3 == 0) {
				System.out.print(num[i] + " ");
			}
		}
	}

}
