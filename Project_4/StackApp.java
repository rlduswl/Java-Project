package Project_4;
import java.util.Scanner;

//IStack 인터페이스 정의
interface IStack {
 int capacity(); // 최대 저장 가능한 개수 반환
 int length(); // 현재 스택에 저장된 개수 반환
 boolean push(String val); // 문자열 추가
 String pop(); // 문자열 제거
}

//StringStack 클래스는 IStack 인터페이스를 구현
class StringStack implements IStack {
 private String[] stack; // 스택을 저장할 배열
 private int top = 0; // 스택의 현재 위치

 // 생성자, 크기를 입력받아 스택 배열 생성
 public StringStack(int capacity) {
     stack = new String[capacity];
 }

 @Override
 public int capacity() {
     return stack.length;
 }

 @Override
 public int length() {
     return top;
 }

 @Override
 public boolean push(String val) {
     if (top == stack.length) {
         System.out.println("스택이 꽉 차서 " + val + " 저장 불가");
         return false; // 스택이 꽉 찼을 경우
     }
     stack[top++] = val; // 문자열을 스택에 추가하고 top을 증가시킴
     return true;
 }

 @Override
 public String pop() {
     if (top == 0) {
         return null; // 스택이 비어있을 경우
     }
     return stack[--top]; // 스택에서 문자열을 제거하고 반환
 }
}

public class StackApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     
     System.out.print("스택 용량 >> ");
     int size = scanner.nextInt(); // 스택의 크기를 입력받음
     StringStack stack = new StringStack(size);

     while (true) {
         System.out.print("문자열 입력 >> ");
         String input = scanner.next();

         if (input.equals("그만")) { 
             break;
         }

         stack.push(input); // 입력받은 값을 스택에 추가 (스택이 꽉 차면 메시지 출력)
     }

     System.out.print("스택에 저장된 모든 문자열 팝: ");
     while (true) {
         String value = stack.pop();
         if (value == null) {
             break; 
         }
         System.out.print(value + " "); // 스택에서 문자열을 하나씩 팝
     }

     scanner.close();
 }
}
