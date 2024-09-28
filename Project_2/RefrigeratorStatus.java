package Project_2;

import java.util.Scanner;

public class RefrigeratorStatus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 냉장고 상태를 이진수 문자열로 입력받고 이를 2진수로 변환
        System.out.print("냉장고 상태 입력 >> ");
        String str = scanner.next();  
        byte status = Byte.parseByte(str, 2);  // 문자열을 2진수로 변환
        
        //전원 상태 출력
        if ((status & 0b00000001) != 0) {
            System.out.print("전원이 켜져 있음.");
        } else {
            System.out.print("전원이 꺼져 있음.");
        }

        //문 상태 출력
        if ((status & 0b00000010) != 0) {
            System.out.print("문이 닫혀 있음.");
        } else {
            System.out.print("문이 열려 있음.");
        }

        //전구 상태 출력
        if ((status & 0b00000100) != 0) {
            System.out.print("전구가 정상 작동 중.");
        } else {
            System.out.print("전구가 손상된 상태.");
        }

        //온도 상태 출력
        if ((status & 0b00001000) != 0) {
            System.out.print("냉장고 온도는 3도 미만.");
        } else {
            System.out.print("냉장고 온도는 3도 이상.");
        }

        scanner.close();
    }
}
