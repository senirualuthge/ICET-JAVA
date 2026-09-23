import java.util.*;
class date{
	int year;
	int month;
	int day;

	date(){
		/* 
		year=1970;
		month=1;
		day=1;
		*/
		this(1970, 1, 1);
	}
	public  date(int year,int month,int day){
		setYear(year);//this.year=year;
		setMonth(month);//this.month=month;
		setDay(day);//this.day=day
	}
	public  void set(int year,int month,int day){
		this.year=year;
		this.month=month;
		this.day=day;
	}

	public void printDate(){
	System.out.println(year+"-"+month+"-"+day);
	}	
	public void set(){
		System.out.println(toString());
	}
	public void setYear(int year){
		this.year=year;
	}
	public void setMonth(int month){
		this.month=month;
	}
	public void setDay(int day){
		this.day=day;
	}
	public String toString(){
		return(year+"-"+month+"-"+day);
	}
	
}


class Demo1 {
	public static void main(String[] args) {
		date d1=new date();
		d1.printDate(); //1970-1-1 (Default date);
		
		d1.set(1999,12,31);	
		d1.printDate(); //1999-12-31
		
		date d2=new date(2020,3,14);
		d2.printDate(); //2020-3-14
		
		date d3=new date();
		d3.setYear(2026);
		d3.setMonth(9);
		d3.setDay(17);
		System.out.println(d3);//2026-9-17
	}
}