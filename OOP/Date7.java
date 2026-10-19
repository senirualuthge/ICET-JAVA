import java.time.LocalDate;
import java.time.Year;

// Companion class for Demo7.
// Originally `class Date` in demo7.java. Renamed Date7 so the name does not
// clash with Date1/Date4 from the other demos in this package.
// setYear() returns `this`, so calls can be chained.
// NOTE: getDateInstance() used LocalDate.getYear(), which returns the
// year-of-era (26 for 2026). Year.now().getValue() returns the full year.
class Date7 {
	private int year;
	private int month;
	private int day;

	Date7(){
		this(1970,1,1);
	}
	public Date7(int year, int month, int day){
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
	public Date7 setYear(int year){
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

	public void set(Date7 date){
		set(date.year, date.month, date.day);
	}
	public static Date7 getDateInstance(){
		LocalDate d1=LocalDate.now();
		return new Date7(Year.now().getValue(), d1.getMonthValue(), d1.getDayOfMonth());
	}
}