class Demo1{
	long[] ar=new long[100000];
}
class Demo{
	public static void main(String args[]){
		Demo1[] ar=new Demo1[100000];
		System.out.println("Start main");
		for (int i = 0; i < 100000; i++){
			System.out.println("i : "+i);
			ar[i]=new Demo1();
		}
		System.out.println("End main");
	}
}
