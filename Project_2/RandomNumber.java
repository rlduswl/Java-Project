package Project_2;

public class RandomNumber {
	public static void main(String[] args) {
		int num [] = new int[10];
		int sum=0;
		
		System.out.print("랜덤한 정수 >> ");
		for (int i=0; i<num.length; i++) {
			int rand = (int)(Math.random()*9) + 11;
			num[i] = rand;
			sum +=num[i];
			System.out.print(num[i] + " ");
		}
		System.out.println();
		
		double avg = sum / (double)num.length;
		System.out.println("평균>> " + avg);

	}

}
