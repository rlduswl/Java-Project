package Project_3;

class Rectangle {
    private int x, y; // 좌표
    private int width, height; // 가로, 세로 크기

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void show() {
        System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
    }

    public boolean isSquare() {
        return width == height;
    }

    // 다른 사각형이 이 사각형 안에 포함되는지 확인
    public boolean contains(Rectangle r) {
        // 이 사각형의 범위가 다른 사각형을 포함하는지 확인
        return (this.x <= r.x && this.y <= r.y &&
                this.x + this.width >= r.x + r.width &&
                this.y + this.height >= r.y + r.height);
    }
}

public class Main_Rectangle {
    public static void main(String[] args) {
    	
        Rectangle a = new Rectangle(3, 3, 6, 6);  // (3, 3)에서 6x6 크기의 사각형
        Rectangle b = new Rectangle(4, 4, 2, 3);  // (4, 4)에서 2x3 크기의 사각형

        a.show();

        if (a.isSquare()) {
            System.out.println("정사각형입니다.");
        } else {
            System.out.println("정사각형이 아닙니다.");
        }

        if (a.contains(b)) {
            System.out.println("a는 b를 포함합니다.");
        } else {
            System.out.println("a는 b를 포함하지 않습니다.");
        }
    }
}
