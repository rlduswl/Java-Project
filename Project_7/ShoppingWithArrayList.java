package Project_7;

import java.util.HashMap;
import java.util.Scanner;

public class ShoppingWithArrayList  {
    public static void main(String[] args) {

        HashMap<String, Integer> items = new HashMap<>();
        items.put("고추장", 3000);
        items.put("만두", 500);
        items.put("새우깡", 1500);
        items.put("콜라", 600);
        items.put("참치캔", 2000);
        items.put("치약", 1000);
        items.put("연어", 2500);
        items.put("삼겹살", 2500);

        Scanner scanner = new Scanner(System.in);

        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        for (String item : items.keySet()) {
            System.out.println("[" + item + ", " + items.get(item) + "]");
        }

        while (true) {
            System.out.print("물건과 개수를 입력하세요 >> ");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String[] inputs = input.split(" ");
            if (inputs.length % 2 != 0) { 
                System.out.println("입력에 문제가 있습니다!");
                continue;
            }

            int totalCost = 0; 
            boolean isValid = true;
            
            for (int i = 0; i < inputs.length; i += 2) {
                String itemName = inputs[i];
                int quantity;

                try {
                    quantity = Integer.parseInt(inputs[i + 1]);
                } catch (NumberFormatException e) {
                    System.out.println("입력에 문제가 있습니다!");
                    isValid = false;
                    break;
                }

                if (!items.containsKey(itemName)) {
                    System.out.println(itemName + "은(는) 없는 상품입니다.");
                    isValid = false;
                    break;
                }

                totalCost += items.get(itemName) * quantity;
            }

  
            if (isValid) {
                System.out.println("전체 비용은 " + totalCost + "원 입니다.");
            }
        }
    }
}
