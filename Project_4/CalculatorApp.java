package Project_4;

import java.util.Scanner;


abstract class Calc {
 protected int a, b;
 protected String errorMsg = null;

 public void setValue(int a, int b) {
     this.a = a;
     this.b = b;
 }

 public abstract int calculate();
}


class Add extends Calc {
 @Override
 public int calculate() {
     return a + b;
 }
}


class Sub extends Calc {
 @Override
 public int calculate() {
     return a - b;
 }
}


class Mul extends Calc {
 @Override
 public int calculate() {
     return a * b;
 }
}


class Div extends Calc {
 @Override
 public int calculate() {
     if (b == 0) {
         errorMsg = "0으로 나눌 수 없음";
         return 0;
     }
     return a / b;
 }
}

public class CalculatorApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Calc calc = null;

     while (true) {
         System.out.print("두 정수와 연산자를 입력하세요>>");
         int num1 = scanner.nextInt();
         int num2 = scanner.nextInt();
         String operator = scanner.next();

         switch (operator) {
             case "+":
                 calc = new Add();
                 break;
             case "-":
                 calc = new Sub();
                 break;
             case "*":
                 calc = new Mul();
                 break;
             case "/":
                 calc = new Div();
                 break;
             default:
                 System.out.println("잘못된 연산자입니다.");
                 continue;
         }

         calc.setValue(num1, num2);
         int result = calc.calculate();

         if (calc.errorMsg != null) { 
             System.out.println(calc.errorMsg + ", 프로그램 종료");
             break;
         }

         System.out.println("계산 결과 " + result);
     }

     scanner.close();
 }
}
