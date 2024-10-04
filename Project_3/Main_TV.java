package Project_3;

class TV {
	
	String brand;
	int size;
	int price;

	public TV (String brand,int size,int price) {
		this.brand = brand;
		this.price = price;
		this.size = size;
	}
	
	public void show() {
		System.out.println(brand + "에서 만든 " + price + "만원짜리 " + size + "인치 TV");
	}
}

public class Main_TV {
	public static void main(String[] args) {
		TV tv = new TV("Samsung", 50, 300);
		tv.show();
	}
}


