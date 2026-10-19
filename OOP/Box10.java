// Companion class for Demo10.
// Originally `class Box` in demo10.java, clashing with the Box class in
// demo5.java - hence the Box10 suffix. Immutable: only getters.
class Box10 {
	private int length;
	private int width;
	private int height;

	public Box10(){
		this(0, 0, 0);
	}
	public Box10(int length, int width, int height){
		this.length=length;
		this.width=width;
		this.height=height;
	}
	public int getLength(){
		return length;
	}
	public int getHeight(){
		return height;
	}
	public int getWidth(){
		return width;
	}

}