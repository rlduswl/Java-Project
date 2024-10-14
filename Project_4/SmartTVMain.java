package Project_4;

class Television {  
    private int size;

    public Television(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}

class MyColorTV extends Television {  
    private int color;

    public MyColorTV(int size, int color) {
        super(size);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void printProperty() {
        System.out.println(getSize() + "인치 " + color + "컬러");
    }
}

class SmartTV extends MyColorTV {
    private String ipAddress;

    public SmartTV(String ipAddress, int size, int color) {
        super(size, color);
        this.ipAddress = ipAddress;
    }

    @Override
    public void printProperty() {
        System.out.println("나의 SmartTV: " + ipAddress + " 주소의 " + getSize() + "인치 " + getColor() + "컬러");
    }
}

public class SmartTVMain {
    public static void main(String[] args) {
        SmartTV smartTV = new SmartTV("192.168.0.5", 77, 2000000); 
        smartTV.printProperty();
    }
}
