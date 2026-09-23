import java.time.*;
class Date{
	private int year;
	private int month;
	private int day; 
	
	Date(){
		this(1970,1,1);
	}
	public Date(int year, int month, int day){
		set(year,month,day);
	}	
	public void printDate(){
		System.out.println(toString());
	}

	public void set(int year, int month, int day){
		setYear(year);//this.year=year;
		setMonth(month);//this.month=month;
		setDay(day);//this.day=day;
	}
	public Date setYear(int year){
		this.year=year;
		return this;
	}
	public void setMonth(int month){
		this.month=month;
	}
	public void setDay(int day){
		this.day=day;
	}
	public String toString(){
		return year+"-"+month+"-"+day;
	}

	public void set(Date date){
		set(date.year, date.month, date.day);
	}
	public static Date getDateInstance(){
		LocalDate d1=LocalDate.now();
		return new Date(d1.getYear(),d1.getMonthValue(),d1.getDayOfMonth());
	}
}
class demo7 {
	public static void main(String[] args) {
		Date d1=Date.getDateInstance();
		System.out.println(d1); //2026-9-17
		
		d1.setYear(1999);
		System.out.println(d1); //2026-9-17-->1999-9-17
		
		Date d2=d1.setYear(1999);
		System.out.println(d2); //1999-9-17
	}
}
