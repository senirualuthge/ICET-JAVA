package Collection;

// Exercises IntegerCollection2 by walking it with size()/get().
// Run: bash ../../run.sh Collection.Ex2
class Ex2{
	public static void main(String[] args) {
		IntegerCollection2 intC=new IntegerCollection2();
		intC.add(10);
		intC.add(20);
		intC.add(30);
		intC.add(40);
		intC.add(50);
		for(int i=0; i<intC.size(); i++){
			System.out.println("Index at "+i+" : "+intC.get(i));
		}
	}
}
/*
0 : 10
1 : 20
2 : 30
3 : 40
4 : 50
*/