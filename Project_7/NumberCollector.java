package Project_7;

import java.util.Scanner;
import java.util.Vector;

public class NumberCollector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> numbers = new Vector<>();
        
        System.out.println("숫자를 입력하세요 (종료하려면 -1을 입력):");

        while (true) {
            int num = scanner.nextInt();
            if (num == -1) { 
                break;
            }
            numbers.add(num); 
        }
        

            int min = numbers.get(0);
            for (int n : numbers) {
                if (n < min) {
                    min = n;
                }
            }
            
            System.out.println("가장 작은 수: " + min);
        }
    }



