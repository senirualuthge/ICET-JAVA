import java.util.ArrayList;
import java.util.List;

public class Database {

    private static final Database INSTANCE = new Database();

    private final List<Batch> batches = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();

    private Database() {
    }

    public static Database get() {
        return INSTANCE;
    }

    public List<Batch> getBatches() {
        return new ArrayList<>(batches);
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

    public Batch findBatch(int batchNumber) {
        for (Batch batch : batches) {
            if (batch.getBatchNumber() == batchNumber) {
                return batch;
            }
        }
        return null;
    }

    public boolean batchExists(int batchNumber) {
        return findBatch(batchNumber) != null;
    }

    public boolean addBatch(int batchNumber) {
        if (batchExists(batchNumber)) {
            return false;
        }
        batches.add(new Batch(batchNumber));
        return true;
    }

    public int nextBatchNumber() {
        int next = 100;
        for (Batch batch : batches) {
            if (batch.getBatchNumber() >= next) {
                next = batch.getBatchNumber() + 1;
            }
        }
        return next;
    }

    public Student findStudentById(String registrationNo) {
        if (registrationNo == null) {
            return null;
        }
        String trimmed = registrationNo.trim();
        for (Student student : students) {
            if (student.getRegistrationNo().equalsIgnoreCase(trimmed)) {
                return student;
            }
        }
        return null;
    }

    public Student findStudentByNic(String nic) {
        if (nic == null) {
            return null;
        }
        String trimmed = nic.trim();
        for (Student student : students) {
            if (student.getNic().equalsIgnoreCase(trimmed)) {
                return student;
            }
        }
        return null;
    }

    public boolean nicExists(String nic) {
        return findStudentByNic(nic) != null;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> studentsInBatch(int batchNumber) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getBatchNumber() == batchNumber) {
                result.add(student);
            }
        }
        return result;
    }

    public int studentCountInBatch(int batchNumber) {
        return studentsInBatch(batchNumber).size();
    }

    public String generateStudentId(Batch batch, boolean physical) {
        int nextSequence = 1;
        for (Student student : studentsInBatch(batch.getBatchNumber())) {
            String id = student.getRegistrationNo();
            try {
                int sequence = Integer.parseInt(id.substring(7));
                if (sequence >= nextSequence) {
                    nextSequence = sequence + 1;
                }
            } catch (NumberFormatException ignored) {
            }
        }
        return String.format("%s24%03d%03d", physical ? "PR" : "OR", batch.getBatchNumber(), nextSequence);
    }
}
