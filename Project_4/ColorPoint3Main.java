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

class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);  // 부모 클래스 Point의 생성자를 호출하여 x, y 좌표를 설정
        this.z = z;
    }

    public void moveUp() {
        z += 3;  // z 좌표를 3 증가
    }

    public void moveDown() {
        z -= 2;  // z 좌표를 2 감소
    }

    public void move(int x, int y) {
        super.move(x, y);  // 부모 클래스의 move() 메서드를 호출하여 x, y 좌표만 이동
    }

    public void move(int x, int y, int z) {
        super.move(x, y);  // 부모 클래스의 move()로 x, y 이동
        this.z = z;  // z 좌표도 이동
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")";
    }
}

public class ColorPoint3Main {
    public static void main(String[] args) {
        Point3D p = new Point3D(3, 2, 1);  // 초기 z 좌표를 1로 설정
        System.out.println(p.toString() + "의 점입니다.");  // (3, 2, 1) 출력

        p.moveUp();  // z 좌표를 3 증가 (z = 1 -> z = 4)
        System.out.println(p.toString() + "의 점입니다.");  // (3, 2, 4) 출력

        p.moveDown();  // z 좌표를 2 감소 (z = 4 -> z = 2)
        System.out.println(p.toString() + "의 점입니다.");  // (3, 2, 2) 출력

        p.move(5, 5);  // x = 5, y = 5로 이동, z는 그대로 (z = 2)
        System.out.println(p.toString() + "의 점입니다.");  // (5, 5, 2) 출력

        p.move(100, 200, 300);  // (100, 200, 300)으로 이동
        System.out.println(p.toString() + "의 점입니다.");  // (100, 200, 300) 출력
    }
}
