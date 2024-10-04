package Project_3;

class Song {
	
	private String title; // 제목
	private String singer; // 가수
	private int year; // 년도
	private String lang; // 나라
	
	public Song (String title,String singer,int year,String lang) {
		this.title = title;
		this.singer = singer;
		this.year = year;
		this.lang = lang;
	}
	
	public void show() {
		System.out.println(year + "년 " + lang + "의 " + singer + "가 부른 " + title);
	}
}

public class Main_Song {
	public static void main(String[] args) {
		
		
		Song song = new Song ("가로수 그늘 아래 서면", "이문세",1988,"한국");
		
		song.show();
	}

}
