package Project_3;

class Average {
    private int[] scores;
    private int nextIndex;

    public Average() {
        scores = new int[10];
        nextIndex = 0;
    }

    public void put(int score) {
        if (nextIndex < scores.length) {
            scores[nextIndex] = score;
            nextIndex++;
        } else {
            System.out.println("저장된 데이터가 모두 찼습니다.");
        }
    }

    public void showAll() {
        System.out.println
        ("**** 저장된 데이터 모두 출력 ****");
        for (int i = 0; i < nextIndex; i++) {
            System.out.println
            (scores[i] + " ");
        }
        System.out.println();
    }

    public double getAvg() {
        if (nextIndex == 0) {
            return 0.0;
        }
        
        int sum = 0;
        for (int i = 0; i < nextIndex; i++) {
            sum += scores[i];
        }
        return (double) sum / nextIndex; 
    }
}

public class Main_Average {
	public static void main(String[] args) {
	       Average avg = new Average();

	        avg.put(10);
	        avg.put(15);
	        avg.put(100);

	        avg.showAll();

	        System.out.println("평균은 " + avg.getAvg());
	}
}
