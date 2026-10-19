// Companion class for Demo5.
// Originally `class Box` in demo5.java, clashing with the Box class in
// demo10.java - hence the Box5 suffix.
class Box5 {
	private int length;
	private int width;
	private int height;

	Box5(){
		this(1,1,1);
	}
	public Box5(int side){
		set(side,side,side);
	}
	public Box5(int length, int width, int height){
		set(length,width,height);
	}
	public void printVolume(){
		System.out.println("Volume of the box : "+getVolume());
	}
	public int getVolume(){
		return length*width*height;
	}
	public void set(int length, int width, int height){
		setLength(length); 	//this.length=length;
		setWidth(width);	//this.width=width;
		setHeight(height);	//this.height=height;
	}
	public void setLength(int length){
		this.length=length;
	}
	public int getLength(){
		return length;
	}
	public void setWidth(int width){
		this.width=width;
	}
	public int getWidth(){
		return width;
	}
	public void setHeight(int height){
		this.height=height;
	}
	public void set(Box5 box){
		set(box.length, box.width, box.height);
	}
	public static Box5 getInstance(){
		return new Box5();
	}
	public int getHeight(){
		return height;
	}
}