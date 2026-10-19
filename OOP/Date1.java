// Companion class for Demo1.
// Originally `class date` living inside demo1.java; split out so that every
// file holds exactly one top-level class whose name matches the file name.
// The digit suffix avoids clashing with Date4/Date7 from the other demos,
// which share this (default) package.
class Date1 {
	int year;
	int month;
	int day;

	Date1(){
		/*
		year=1970;
		month=1;
		day=1;
		*/
		this(1970, 1, 1);
	}
	public  Date1(int year,int month,int day){
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