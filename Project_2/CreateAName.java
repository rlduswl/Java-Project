package Project_2;

import java.util.Scanner;

public class CreateAName {
	public static void main(String[] args) {
		String boyMiddleList [] = {"기","민","용","종","현","진","재","승","소","상","지"};
		String boyLastList [] = {"태","진","광","혁","우","철","빈","준","구","호","석"};
		String girlMiddleList [] = {"은","원","경","수","현","예","여","송","서","채","하"};
		String girlLastList [] = {"진","연","경","서","리","숙","미","원","린","희","수"};

		Scanner sc = new Scanner(System.in);
		
		System.out.println("**** 작명 프로그램이 실행됩니다. ****");
		
		while (true) {
			System.out.print("남 / 여 선택 >> ");
			String gender = sc.nextLine();
			
			if (gender.equals("그만")) {
				break;
			}
			
			System.out.print("성 입력 >> ");
			String sex = sc.nextLine();
			
            String middleName, lastGeneratedName;
            int middleIndex, lastIndex;
			
			if (gender.equals("남")) {
                middleIndex = (int)(Math.random() * boyMiddleList.length);
                lastIndex = (int)(Math.random() * boyLastList.length);
                middleName = boyMiddleList[middleIndex];
                lastGeneratedName = boyLastList[lastIndex];
                
			}else if (gender.equals("여")) {
                middleIndex = (int)(Math.random() * girlMiddleList.length);
                lastIndex = (int)(Math.random() * girlLastList.length);
                middleName = girlMiddleList[middleIndex];
                lastGeneratedName = girlLastList[lastIndex];
                
			} else {
                System.out.println("남/여 중에서 입력하세요 !");
                continue;
            }
			System.out.println("추천 이름 >> " + sex + middleName + lastGeneratedName);
		}
	}

}
