package Collection;

// Exercises StudentCollection4 - the ArrayList-backed collection.
// Run: bash ../../run.sh Collection.Ex4
class Ex4 {
	public static void main(String args[]){
		StudentCollection4 studentCollection=new StudentCollection4();
		studentCollection.add(new Student4("S0001","Nimal",56,87));
		studentCollection.add(new Student4("S0002","Amal",76,97));
		studentCollection.add(new Student4("S0003","Bimal",36,47));
		studentCollection.add(new Student4("S0004","Ranil",96,97));

		studentCollection.printStudents();
	}
}