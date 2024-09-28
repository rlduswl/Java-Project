package Project_2;

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String response;
        
        do {
            int rand = (int)(Math.random() * 100) + 1;  
            int low = 1;
            int high = 99;
            boolean correct = false;
            int count = 0;
            
            System.out.println("수를 결정하였습니다. 맞추어 보세요.");
            
            while (!correct) { 
                System.out.print((count + 1) + ">> ");
                int guess = scanner.nextInt();
                count++;
                
                if (guess < rand) {
                    System.out.println("더 높게");
                    low = guess + 1; 
                    System.out.println(low + "-" + high);
                } else if (guess > rand) {
                    System.out.println("더 낮게");
                    high = guess - 1;  
                    System.out.println(low + "-" + high);
                } else {
                    System.out.println("맞았습니다!");
                    correct = true;  
                }
            }
            
            System.out.print("다시 하시겠습니까?(y/n) >> ");
            response = scanner.next();
        } while (response.equalsIgnoreCase("y"));
        
        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}
