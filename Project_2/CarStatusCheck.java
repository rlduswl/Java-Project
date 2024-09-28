package Project_2;

import java.util.Scanner;

public class CarStatusCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("자동차 상태 입력 >> ");
        int status = scanner.nextInt();
        
        //온도 계산
        int temperature = status & 0b00111111;  //하위 6비트만 추출
        
        //에어컨 상태 확인
        boolean airConditionerOn = (status & 0b01000000) != 0;
        
        //자동차 상태 확인
        boolean carRunning = (status & 0b10000000) != 0;
        
        
        if (carRunning) {
            System.out.print("자동차가 달리는 상태이며 ");
        } else {
            System.out.print("자동차가 정지 상태이며 ");
        }
        
        if (airConditionerOn) {
            System.out.print("에어컨이 켜진 상태이며 ");
        } else {
            System.out.print("에어컨이 꺼진 상태이며 ");
        }
        
  
        
        // 온도 출력
        System.out.println("온도는 " + temperature + "도입니다.");

        scanner.close();
    }
}
