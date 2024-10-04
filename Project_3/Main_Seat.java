package Project_3;

import java.util.Scanner;

class Seat {
    private String[] seats;
    private String type;

    public Seat(String type, int numSeats) {
        this.type = type;
        this.seats = new String[numSeats];
        for (int i = 0; i < numSeats; i++) {
            seats[i] = "---"; 
        }
    }

    public void showSeats() {
        System.out.print(type + ">> ");
        for (int i = 0; i < seats.length; i++) {
            System.out.print(seats[i] + " ");
        }
        System.out.println();
    }

    // 좌석 예약 메서드
    public boolean reserve(String name, int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.length || !seats[seatNumber - 1].equals("---")) {
            System.out.println("해당 좌석은 예약할 수 없습니다.");
            return false;
        }
        seats[seatNumber - 1] = name;
        return true;
    }

    public boolean cancel(String name) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].equals(name)) {
                seats[i] = "---";  
                return true;
            }
        }
        System.out.println("예약자 이름을 찾을 수 없습니다.");
        return false;
    }
}

class ConcertReservationSystem {
    private Seat sSeats = new Seat("S", 10);
    private Seat aSeats = new Seat("A", 10);
    private Seat bSeats = new Seat("B", 10);
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
    }

    public void showAllSeats() {
        sSeats.showSeats();
        aSeats.showSeats();
        bSeats.showSeats();
    }

    public void reserveSeat() {
        System.out.print("좌석구분 S(1), A(2), B(3) >> ");
        int seatType = scanner.nextInt();
        Seat seat = getSeatByType(seatType);
        if (seat == null) {
            System.out.println("잘못된 좌석 구분입니다.");
            return;
        }

        seat.showSeats();

        System.out.print("이름 >> ");
        String name = scanner.next();

        System.out.print("번호 >> ");
        int seatNumber = scanner.nextInt();

        if (seat.reserve(name, seatNumber)) {
            System.out.println("예약이 완료되었습니다.");
        }
    }

    public void cancelReservation() {
        System.out.print("좌석구분 S(1), A(2), B(3) >> ");
        int seatType = scanner.nextInt();
        Seat seat = getSeatByType(seatType);
        if (seat == null) {
            System.out.println("잘못된 좌석 구분입니다.");
            return;
        }

        System.out.print("이름 >> ");
        String name = scanner.next();

        if (seat.cancel(name)) {
            System.out.println("취소가 완료되었습니다.");
        }
    }

    private Seat getSeatByType(int seatType) {
        switch (seatType) {
            case 1:
                return sSeats;
            case 2:
                return aSeats;
            case 3:
                return bSeats;
            default:
                return null;
        }
    }

    // 시스템 실행 메서드
    public void run() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    reserveSeat();
                    break;
                case 2:
                    showAllSeats();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

public class Main_Seat{
    public static void main(String[] args) {
        System.out.println("명품콘서트 예약 시스템입니다.");
        ConcertReservationSystem system = new ConcertReservationSystem();
        system.run();
    }
}
