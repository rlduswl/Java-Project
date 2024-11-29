package Project_7;

import java.util.HashMap;
import java.util.Scanner;

class Location {
    private double latitude;  // 위도
    private double longitude; // 경도

    // 생성자
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return latitude + ", " + longitude;
    }
}

public class LocationManager {
    public static void main(String[] args) {
        HashMap<String, Location> locations = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("도시와 위도, 경도를 입력하세요 ");

        int cityCount = 0;
        while (cityCount < 4) { 
            System.out.print(">> ");
            String input = scanner.nextLine();

            if (input.equals("그만")) { 
                System.out.println("입력을 종료합니다.");
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length != 3) { 
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                continue;
            }

            String city = parts[0]; 
            double latitude;
            double longitude;

            try {
                latitude = Double.parseDouble(parts[1]); 
                longitude = Double.parseDouble(parts[2]); 
            } catch (NumberFormatException e) {
                System.out.println("위도와 경도는 숫자로 입력해야 합니다.");
                continue;
            }

            if (!locations.containsKey(city)) {
                locations.put(city, new Location(latitude, longitude));
                cityCount++;
            } else {
                System.out.println("이미 입력된 도시입니다.");
            }
        }

        System.out.println("\n현재 등록된 도시와 위도, 경도:");
        for (String city : locations.keySet()) {
            System.out.println(city + ": " + locations.get(city));
        }

        System.out.println("\n도시 검색을 시작합니다. 도시 이름을 입력하세요 (종료하려면 '그만' 입력):");

        while (true) {
            System.out.print(">> ");
            String city = scanner.nextLine();

            if (city.equals("그만")) { 
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (locations.containsKey(city)) { 
                Location location = locations.get(city);
                System.out.println(city + "의 경도와 위도: " + location);
            } else { 
                System.out.println(city + "은(는) 없는 도시입니다.");
            }
        }
    }
}
