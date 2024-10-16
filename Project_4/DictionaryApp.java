package Project_4;

abstract class PairMap {
    protected String[] keyArray; // 키 배열
    protected String[] valueArray; // 값 배열
    protected int size; // 현재 저장된 키-값 쌍의 개수

    public PairMap(int size) {
        this.size = size;
        keyArray = new String[size]; // 키 배열 생성
        valueArray = new String[size]; // 값 배열 생성
    }

    // 추상 메서드 선언
    public abstract String get(String key); 
    public abstract void put(String key, String value);
    public abstract String delete(String key); 
    public abstract int length(); 
}

class Dictionary extends PairMap {
    private int itemCount; 

    public Dictionary(int size) {
        super(size);
        this.itemCount = 0;
    }

    @Override
    public String get(String key) {
        for (int i = 0; i < itemCount; i++) {
            if (keyArray[i].equals(key)) { 
                return valueArray[i];
            }
        }
        return null; 
    }

    @Override
    public void put(String key, String value) {
        for (int i = 0; i < itemCount; i++) {
            if (keyArray[i].equals(key)) { 
                valueArray[i] = value;
                return;
            }
        }
        if (itemCount < size) {
            keyArray[itemCount] = key;
            valueArray[itemCount] = value;
            itemCount++;
        }
    }

    @Override
    public String delete(String key) {
        for (int i = 0; i < itemCount; i++) {
            if (keyArray[i].equals(key)) {
                String deletedValue = valueArray[i];
              
                keyArray[i] = keyArray[itemCount - 1];
                valueArray[i] = valueArray[itemCount - 1];
                keyArray[itemCount - 1] = null;
                valueArray[itemCount - 1] = null;
                itemCount--;
                return deletedValue;
            }
        }
        return null; 
    }

    @Override
    public int length() {
        return itemCount;
    }
}

public class DictionaryApp {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);


        dic.put("이재문", "자바");
        dic.put("김지현", "파이썬");
        dic.put("이재문", "C++"); 
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("김지현의 값은 " + dic.get("김지현"));


        dic.delete("김지현");
        System.out.println("김지현의 값은 " + dic.get("김지현"));
    }
}
