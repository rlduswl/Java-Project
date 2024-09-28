package Project_2;

import java.util.Scanner;

public class For_star {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
        while (num <= 0) {
            System.out.print("양의 정수 >> ");
            num = sc.nextInt();
        }
		
		for (int i=num; i > 0; i--) {
			for (int j=0; j<i; j++) {
				System.out.print("*");
			}
		System.out.println();
		}
		
	}

}
