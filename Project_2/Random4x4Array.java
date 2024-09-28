package Project_2;

public class Random4x4Array {
    public static void main(String[] args) {
        int arr [][]= new int[4][4]; 

        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
            	int rand = (int)(Math.random()*255) + 1;
            	arr[i][j] = rand;
                System.out.print(arr[i][j] + "\t"); 
            }
            System.out.println();  
        }
    }
}

