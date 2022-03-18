package work;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	public MyDate(int y,int m,int d) {
		this.day=d;
		this.month=m;
		this.year=y;
	}
	
	public boolean equals(MyDate md) {
		if(this.year==md.year&&this.month==md.month&&this.day==md.day)
			return true;
		else
			return false;
	}
}
