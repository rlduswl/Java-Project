package Project_4;

import java.util.Scanner;

abstract class Box {
    protected int size;

    public Box(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public abstract boolean consume();
    public abstract void print();
}

class IngredientBox extends Box {
    private String name;

    public IngredientBox(String name, int size) {
        super(size);
        this.name = name;
    }

    @Override
    public boolean consume() {
        if (!isEmpty()) {
            size--;
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        System.out.println(name + " *****" + size);
    }

    public String getName() {
        return name;
    }
}

public class CoffeeMaker {
    public static void main(String[] args) {
        IngredientBox coffee = new IngredientBox("커피", 5);
        IngredientBox prim = new IngredientBox("프림", 5);
        IngredientBox sugar = new IngredientBox("설탕", 5);

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("*****남은 커피 재료*****");
            coffee.print();
            prim.print();
            sugar.print();

            System.out.println("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4");
            System.out.print("선택> ");
            choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("커피 자판기 프로그램을 종료합니다.");
                break;
            }

            boolean ingredientShortage = false;
            
            switch (choice) {
                case 1: // 다방커피: 커피, 프림, 설탕 모두 소비
                    if (!coffee.consume() || !prim.consume() || !sugar.consume()) {
                        ingredientShortage = true;
                    }
                    break;
                case 2: // 설탕커피: 커피, 설탕 소비
                    if (!coffee.consume() || !sugar.consume()) {
                        ingredientShortage = true;
                    }
                    break;
                case 3: // 블랙커피: 커피만 소비
                    if (!coffee.consume()) {
                        ingredientShortage = true;
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");
                    continue;
            }

            if (ingredientShortage) {
                System.out.println("원료가 부족합니다.");
            }
        }

        scanner.close();
    }
}
