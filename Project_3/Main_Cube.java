package Project_3;

class Cube{
	private int width;
	private int height;
	private int depth;
	
	public Cube (int width, int height,int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public int getVolume() { // 부피 계산
		return width * height * depth ;
	}
	
	public void increase (int width, int height,int depth) { // 1씩 증가
		this.width += width;
		this.height += height;
		this.depth += depth;
	}
	
	public boolean isZero() { // 부피 0인지 확인
		return getVolume() == 0;
	}
}

public class Main_Cube {
	public static void main(String[] args) {
		// 가로,세로,높이 1,2,3인 큐브 객체 생성
        Cube cube = new Cube(1, 2, 3);

        System.out.println("큐브의 부피는 " + cube.getVolume());
        // 가로 , 세로 ,높이 각각 1,2,3씩 증가
        cube.increase(1, 2, 3);
 
        System.out.println("큐브의 부피는 " + cube.getVolume());

        if (cube.isZero()) {
            System.out.println("큐브의 부피는 0");
        } else {
            System.out.println("큐브의 부피는 0이 아님");
        }
	}
}
