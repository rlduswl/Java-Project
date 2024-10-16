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

    public int getZ() {
        return z;
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

class Point3DColor extends Point3D {
    private String color;

    public Point3DColor(int x, int y, int z, String color) {
        super(x, y, z);  // 부모 클래스 Point3D의 생성자 호출
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + color + "점";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point3DColor) {
            Point3DColor p = (Point3DColor) obj;
            return this.getX() == p.getX() && this.getY() == p.getY() && this.getZ() == p.getZ() && this.color.equals(p.color);
        }
        return false;
    }
}

public class Point3DColorMain {
    public static void main(String[] args) {
        Point3DColor p = new Point3DColor(10, 20, 0, "RED");
        System.out.println(p.toString() + "입니다.");  // (10, 20, 0) 출력

        Point3DColor q = new Point3DColor(1, 2, 0, "BLUE");
        p.move(q.getX(), q.getY(), q.getZ());  // q의 좌표로 이동 (1, 2, 0)
        System.out.println(p.toString() + "입니다.");  // (1, 2, 0) 출력

        Point3DColor r = new Point3DColor(1, 2, 0, "RED");
        if (p.equals(r))  // 좌표와 색상이 같으면 "같은 위치 같은 색깔의 점"
            System.out.println("예, 같은 위치 같은 색깔의 점입니다.");
        else
            System.out.println("아니요");
    }
}
