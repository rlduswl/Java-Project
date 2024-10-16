package Project_4;

import java.util.Scanner;

class BaseArray {
    protected int[] array; // 배열 메모리
    protected int nextIndex = 0; // 다음에 삽입될 배열 인덱스

    public BaseArray(int size) {
        array = new int[size];
    }

    public int length() {
        return array.length;
    }

    public void add(int n) {
        if (nextIndex == array.length) return; // 배열이 꽉 찼으면 추가하지 않음
        array[nextIndex] = n;
        nextIndex++;
    }

    public void print() {
        for (int n : array) System.out.print(n + " ");
        System.out.println();
    }
}

class BinaryArray extends BaseArray {
    private int threshold;

    public BinaryArray(int size, int threshold) {
        super(size); // 부모 클래스(BaseArray)의 생성자 호출
        this.threshold = threshold;
    }

    @Override
    public void add(int n) {
        // 입력값 n이 threshold보다 크면 1, 작거나 같으면 0을 추가
        if (n > threshold) {
            super.add(1);
        } else {
            super.add(0);
        }
    }
}

public class BaseArrayMain {
    public static void main(String[] args) {
        int threshold = 50; // 임계값 50
        BinaryArray bArray = new BinaryArray(10, threshold); // BinaryArray 객체 생성

        Scanner scanner = new Scanner(System.in);
        System.out.print(">>");
        for (int i = 0; i < bArray.length(); i++) {
            bArray.add(scanner.nextInt()); // 입력받은 값 추가
        }

        bArray.print(); // 배열 출력
        scanner.close();
    }
}
