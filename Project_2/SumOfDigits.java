package Project_2;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number[] = new int[10]; 

        System.out.print("양의 정수 10개 입력 >> ");
        for (int i = 0; i < number.length; i++) {
        	number[i] = sc.nextInt();
        }

        System.out.print("자릿수의 합이 9인 것 >> ");
        for (int i = 0; i < number.length; i++) {
            int sum = 0;
            int num = number[i];

            while (num > 0) {
                sum += num % 10;
                num /= 10; 
            }

            if (sum == 9) {
                System.out.print(number[i] + " ");
            }
        }
    }
}
