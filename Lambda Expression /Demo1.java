interface Vehicle{
	public void park();
}
class Demo{
	public static void main(String args[]){
		Vehicle v1=()->{
				System.out.println("Lambda Expression");
		};
		v1.park();
	}
}
