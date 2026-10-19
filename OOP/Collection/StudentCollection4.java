package Collection;

import java.util.ArrayList;

// StudentCollection4 - the same job as the hand-rolled collections, done with
// java.util.ArrayList instead of a manual int[]/Student[] grow-and-copy.
// (Split out of Ex4.java; renamed from StudentCollection, which also appears
// in Ex5.java in this package.)
class StudentCollection4 {
	private final ArrayList<Student4> students = new ArrayList<>();

	public void add(Student4 student) {
		students.add(student);
	}

	public void printStudents() {
		for (Student4 student : students) {
			System.out.println(student);
		}
	}
}