// Companion class for Demo2.
// A date value object whose setters are reachable through a single
// set(field, value) entry point, with YEAR/MONTH/DAY acting as named indices.
class DateValue {
    public static final int YEAR=0;
    public static final int MONTH=1;
    public static final int DAY=2;

	private int year;
	private int month;
	private int day;

	DateValue(){
		this(1970,1,1);
	}
	public DateValue(int year, int month, int day){
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
				break;
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


}