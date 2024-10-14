package Project_4;

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    protected void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class PositivePoint extends Point {

    public PositivePoint() {
        super(0, 0); // 기본 생성자: (0, 0) 좌표로 설정
    }

    public PositivePoint(int x, int y) {
        super(x > 0 ? x : 1, y > 0 ? y : 1);  // x와 y 좌표가 모두 양수여야 함. 음수면 (1,1)로 설정
    }

    @Override
    public void move(int x, int y) {
        if (x > 0) {  // x 좌표만 양수일 때 이동
            super.move(x, y);
        }
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
}

public class PositivePointMain {
    public static void main(String[] args) {
        PositivePoint p = new PositivePoint(10, 10);  // (10, 10)의 점
        p.move(10, 10);  // (5, 5)로 이동
        System.out.println(p.toString() + "의 점입니다.");  // (5, 5)의 점

        p.move(2, -2);  // x 좌표는 2, y 좌표는 -2로 이동
        System.out.println(p.toString() + "의 점입니다.");  // (2, -2)의 점

        PositivePoint q = new PositivePoint(-10, -10);  // 음수 좌표이므로 (1,1)으로 설정
        System.out.println(q.toString() + "의 점입니다.");  // (1, 1)의 점
    }
}
