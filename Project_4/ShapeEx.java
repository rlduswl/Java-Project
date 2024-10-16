package Project_4;


interface Shape {
 final double PI = 3.14; 
 
 void draw(); // 도형을 그리는 메서드
 double getArea(); // 도형의 면적을 반환하는 메서드
 
 // default 메서드로 기본적인 그리기 출력 제공
 default void redraw() {
     System.out.print("-- 다시 그립니다. ");
     draw(); // 구체적인 도형을 그리기 위해 draw 호출
 }
}


class Circle implements Shape {
 private int radius; // 반지름
 
 public Circle(int radius) {
     this.radius = radius;
 }

 @Override
 public void draw() {
     System.out.println("반지름이 " + radius + "인 원입니다.");
 }

 @Override
 public double getArea() {
     return PI * radius * radius; 
 }
}

class Oval implements Shape {
 private int width, height;
 
 public Oval(int width, int height) {
     this.width = width;
     this.height = height;
 }

 @Override
 public void draw() {
     System.out.println(width + "x" + height + "에 내접하는 타원입니다.");
 }

 @Override
 public double getArea() {
     return PI * (width / 2.0) * (height / 2.0); // 타원의 면적 계산
 }
}


class Rect implements Shape {
 private int width, height; 
 
 public Rect(int width, int height) {
     this.width = width;
     this.height = height;
 }

 @Override
 public void draw() {
     System.out.println(width + "x" + height + " 크기의 사각형입니다.");
 }

 @Override
 public double getArea() {
     return width * height; // 사각형의 면적 계산
 }
}

public class ShapeEx {
 public static void main(String[] args) {
     // Shape 배열을 사용하여 도형 저장
     Shape[] list = new Shape[3];
     list[0] = new Circle(5); 
     list[1] = new Oval(20, 30); 
     list[2] = new Rect(10, 40); 

     for (int i = 0; i < list.length; i++) {
         list[i].redraw(); // 도형 다시 그리기
     }

     for (int i = 0; i < list.length; i++) {
         System.out.println("면적은 " + list[i].getArea());
     }
 }
}
