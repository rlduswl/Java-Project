package Project_4;

import java.util.ArrayList;
import java.util.Scanner;

// 추상 클래스 Shape
abstract class Shape {
    private Shape next; // 링크드 리스트 형식으로 다음 Shape를 가리키는 포인터

    public Shape() {
        next = null;
    }

    public void setNext(Shape obj) {
        next = obj;
    }

    public Shape getNext() {
        return next;
    }

    public abstract void draw(); // 추상 메서드, 각 도형의 그리기 메서드
}

// Line 클래스 (Shape 상속)
class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

// Rect 클래스 (Shape 상속)
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

// Circle 클래스 (Shape 상속)
class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

// GraphicEditor 클래스
public class GraphicEditorMain {
    private ArrayList<Shape> shapes; // 도형을 저장할 리스트

    public GraphicEditorMain() {
        shapes = new ArrayList<>(); // 도형 리스트 초기화
    }

    // 도형 추가 메서드
    public void insert(int shapeType) {
        Shape shape = null;
        switch (shapeType) {
            case 1:
                shape = new Line();
                break;
            case 2:
                shape = new Rect();
                break;
            case 3:
                shape = new Circle();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                return;
        }
        shapes.add(shape);
    }

    // 도형 출력 메서드
    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    // 도형 삭제 메서드
    public void delete(int index) {
        if (index < 0 || index >= shapes.size()) {
            System.out.println("삭제할 수 없습니다.");
            return;
        }
        shapes.remove(index);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GraphicEditorMain editor = new GraphicEditorMain();

        System.out.println("Beauty Graphic Editor를 실행합니다.");
        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두보기(3), 종료(4)>> ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("도형 종류 Line(1), Rect(2), Circle(3)>> ");
                    int shapeType = scanner.nextInt();
                    editor.insert(shapeType);
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치>> ");
                    int index = scanner.nextInt();
                    editor.delete(index);
                    break;
                case 3:
                    editor.drawAll();
                    break;
                case 4:
                    System.out.println("Beauty Graphic Editor를 종료합니다.");
                    scanner.close();
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
    }
}
