
class Box{
	private int length;
	private int width;
	private int height;
	
	public Box(){
		this(0, 0, 0);
	}
	public Box(int length, int width, int height){
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
class Demo10 {
	public static void main(String[] args) {
		Box[] br=new Box[3]; //Reference array, Box type
		System.out.println(br[0]+" "+br[1]+" "+br[2]); //null null null 
		int[] lengths = {12, 120, 1};
		int[] widths = {5, 50, 2};
		int[] heights = {3, 30, 3};
		int j = 0;
		while (j < br.length) {
			br[j] = new Box(lengths[j], widths[j], heights[j]);
			j++;
		}

		int i = 0;
		while (i < br.length) {
			System.out.println(br[i].getLength() + " " + br[i].getWidth() + " " + br[i].getHeight());
			i++;
		}
	}
}
