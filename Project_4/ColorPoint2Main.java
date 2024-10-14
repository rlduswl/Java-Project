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

class ColorPoint2 extends Point {
    private String color;

    public ColorPoint2(int x, int y, String color) {
        super(x, y);  // 부모 클래스 Point의 생성자 호출
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setXY(int x, int y) {
        move(x, y);  // 부모 클래스의 move 메서드를 이용하여 x, y 좌표 설정
    }

    @Override
    public String toString() {
        return color + "색의 (" + getX() + "," + getY() + ")의 점";
    }

    // 두 점 사이의 거리 계산 메서드
    public double getDistance(Point p) {
        int dx = getX() - p.getX();
        int dy = getY() - p.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}

public class ColorPoint2Main {
    public static void main(String[] args) {
        // zeroPoint 생성 및 출력
        ColorPoint2 zeroPoint = new ColorPoint2(0, 0, "WHITE");
        System.out.println(zeroPoint.toString());

        // 좌표를 (10, 20)으로 이동하고 색을 RED로 설정한 후 출력
        ColorPoint2 cp = new ColorPoint2(10, 20, "RED");
        cp.setColor("BLUE");  // 색을 BLUE로 변경
        cp.setXY(10, 20);  // 좌표를 (10, 20)으로 설정
        System.out.println(cp.toString() + "입니다.");

        // 두 점 사이의 거리 계산
        ColorPoint2 thresholdPoint = new ColorPoint2(100, 100, "BLACK");
        double distance = cp.getDistance(thresholdPoint);
        System.out.println("cp와 임계점 사이의 거리: " + distance);
    }
}
