import java.time.LocalDate;

class date{
	public static final int YEAR=0;
	public static final int MONTH=1;
	public static final int DAY=2;
	
	private int year;
	private int month;
	private int day; 
	
	date(){
		this(1970,1,1);
	}
	public date(int year, int month, int day){
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
	public void set(date date){
		set(date.year, date.month, date.day);
	}
    public static date getDateInstance(){
        LocalDate today = LocalDate.now();
        return new date(today.getYear(), today.getMonthValue(), today.getDayOfMonth());
    }
}
class demo4 {
	public static void main(String[] args) {
		date d1=date.getDateInstance();
		System.out.println(d1);//2026-9-17
	}
}
