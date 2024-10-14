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
}

class ColorPoint extends Point {
    private String color;

    public ColorPoint(int x, int y, String color) {
        super(x, y);  // 부모 클래스의 생성자를 호출
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setXY(int x, int y) {
        move(x, y);  // 부모 클래스의 move 메서드를 이용해 x, y 값을 설정
    }

    @Override
    public String toString() {
        return color + "색의 (" + getX() + "," + getY() + ")의 점";  // 원하는 형식으로 toString 메서드 재정의
    }
}

public class ColorPointMain {
    public static void main(String[] args) {
        ColorPoint cp = new ColorPoint(5, 5, "RED");  // 5,5 좌표에 RED색 점 생성
        cp.setXY(10, 20);  // 좌표를 10,20으로 이동
        cp.setColor("BLUE");  // 색을 BLUE로 변경
        String str = cp.toString();
        System.out.println(str + "입니다.");  // "BLUE색의 (10,20)의 점입니다." 출력
    }
}
