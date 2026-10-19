import java.time.Year;

// Companion class for Demo4.
// Originally `class date` in demo4.java, clashing with the `date` class in
// demo1.java - hence the Date4 suffix.
// NOTE: getDateInstance() used LocalDate.getYear(), which returns the
// year-of-era (26 for 2026). Year.now().getValue() returns the full year.
class Date4 {
	public static final int YEAR=0;
	public static final int MONTH=1;
	public static final int DAY=2;

	private int year;
	private int month;
	private int day;

	Date4(){
		this(1970,1,1);
	}
	public Date4(int year, int month, int day){
		set(year,month,day);
	}
	public void printDate(){
		System.out.println(toString());
	}
	public void set(int field, int value){
		switch(field){
			case YEAR:
				setYear(value);
				break;
			case MONTH:
				setMonth(value);
				break;
			case DAY:
				setDay(value);
		}
	}

	public void set(int year, int month, int day){
		setYear(year);//this.year=year;
		setMonth(month);//this.month=month;
		setDay(day);//this.day=day;
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
		return year+"-"+month+"-"+day;
	}
	public void set(Date4 date){
		set(date.year, date.month, date.day);
	}
    public static Date4 getDateInstance(){
        return new Date4(Year.now().getValue(), java.time.LocalDate.now().getMonthValue(),
                java.time.LocalDate.now().getDayOfMonth());
    }
}