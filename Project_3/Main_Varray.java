package Project_3;

class Varray {
    private int[] arr;
    private int size;

    public Varray(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public int capacity() {
        return arr.length;
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        if (size >= arr.length) {
            expandArray();
        }
        arr[size] = value;
        size++;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        if (size >= arr.length) {
            expandArray();
        }

        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    private void expandArray() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Main_Varray {
    public static void main(String[] args) {
        Varray v = new Varray(5);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());

        for (int i = 0; i <= 6; i++) {
            v.add(i);
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        v.insert(3, 100);

        v.insert(5, 200);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        for (int i = 50; i <= 54; i++) {
            v.add(i);
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();
    }
}
