package Project_2;

import java.util.Scanner;

public class Gambling {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        System.out.println("***** 컴퓨터 게임을 시작합니다. *****");

	        while (true) {
	            System.out.print("엔터키를 입력 >>  ");
	            String input = sc.nextLine();
	            if (input.equalsIgnoreCase("yes")) {
	            	continue;
	            } else if (input.equalsIgnoreCase("no")){
	            	System.out.println("게임을 종료합니다");
	            	break;
	            }

	            int num1 = (int)(Math.random()*9) + 1;
	            int num2 = (int)(Math.random()*9) + 1;
	            int num3 = (int)(Math.random()*9) + 1;

	            System.out.println(num1 + " " + num2 + " " + num3);

	            if (num1 == num2 && num2 == num3) {
	                System.out.println("성공, 대박났어요!");
	                System.out.println("계속하시겠습니까? (yes / no) >> ");
	            }
	        }
	}

}
