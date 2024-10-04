package Project_3;

class Account {
    private int balance; 

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return amount;  
        } else {
            return 0;
        }
    }
}

public class Main_Account {
    public static void main(String[] args) {
        // 100원을 예금하면서 계좌 생성
        Account a = new Account(100);
        a.deposit(5000);  // 5000원 입금
        System.out.println("잔금은 " + a.getBalance() + "입니다.");

        // 여러 금액을 한 번에 입금
        int[] bulk = {100, 500, 200, 700};
        for (int b : bulk) {
            a.deposit(b);
        }
        System.out.println("잔금은 " + a.getBalance() + "입니다.");

        // 1000원 인출 시도
        int money = 1000;
        int wMoney = a.withdraw(money);
        if (wMoney == 0) {
            System.out.println(money + "원만 인출");
        } else {
            System.out.println(money + "원 인출");
        }
        System.out.println("잔금은 " + a.getBalance() + "입니다.");
    }
}

