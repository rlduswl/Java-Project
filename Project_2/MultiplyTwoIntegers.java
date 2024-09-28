package Project_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplyTwoIntegers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int n = 0, m = 0;
	        boolean validInput = false;

	        while (!validInput) {
	            try {
	                System.out.print("곱하고자 하는 정수 2개 입력>>");
	                n = sc.nextInt();
	                m = sc.nextInt();
	                validInput = true; 
	            } catch (InputMismatchException e) {
	                System.out.println("정수를 입력하세요!");
	                sc.nextLine(); 
	            }
	        }

	        System.out.println(n + " x " + m + " = " + (n * m));
	        sc.close();
	}

}
