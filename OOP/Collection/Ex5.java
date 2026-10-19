package Collection;

// Exercises StudentCollection5 - the array-backed collection.
// Run: bash ../../run.sh Collection.Ex5
class Ex5 {
	public static void main(String args[]){
		StudentCollection5 studentCollection=new StudentCollection5();
		studentCollection.add(new Student5("S0001","Nimal",56,87));
		studentCollection.add(new Student5("S0002","Amal",76,97));
		studentCollection.add(new Student5("S0003","Bimal",36,47));
		studentCollection.add(new Student5("S0004","Ranil",96,97));

		studentCollection.printStudents();//{[S0001,Nimal,56,87],[S0002,Amal,76,97]....}
	}
}