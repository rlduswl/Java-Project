package Project_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeOrder {
    public static void main(String[] args) {
        String[] coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int[] price = {3000, 3500, 4000, 5000};
        
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        
        System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");

        while (true) {
            try {
                System.out.print("주문 >> ");
                String coffeeOrder = scanner.next();

                if (coffeeOrder.equalsIgnoreCase("그만")) {
                    break;
                }

                int index = -1;
                for (int i = 0; i < coffee.length; i++) {
                    if (coffee[i].equals(coffeeOrder)) {
                        index = i;
                        break;
                    }
                }

                if (index == -1) {
                    System.out.println(coffeeOrder + "는 없는 메뉴입니다.");
                    continue; 
                }

                int count = scanner.nextInt();

                total += price[index] * count;
                System.out.println("가격은 " + (price[index] * count) + "원 입니다.");

            } catch (InputMismatchException e) {
                System.out.println("잔수는 정수로 입력하세요!");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
