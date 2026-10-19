// Companion class for Demo3.
// Same idea as DateValue, plus an overloaded set(DemoDate) copy constructor.
class DemoDate {
	public static final int YEAR=0;
	public static final int MONTH=1;
	public static final int DAY=2;

	private int year;
	private int month;
	private int day;

	DemoDate(){
		this(1970,1,1);
	}
	public DemoDate(int year, int month, int day){
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

	public void set(DemoDate d1){
		set(d1.year,d1.month,d1.day);
	}


}