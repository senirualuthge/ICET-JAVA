public class Batch {

    public static final int ENROLLMENT_OPEN = 1;
    public static final int ENROLLMENT_CLOSED = 0;

    private final int batchNumber;
    private int status = ENROLLMENT_OPEN;

    public Batch(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isOpen() {
        return status == ENROLLMENT_OPEN;
    }

    public String getStatusText() {
        return isOpen() ? "ENROLLMENTOPEN" : "ENROLLMENTCLOSED";
    }

    @Override
    public String toString() {
        return batchNumber + " Batch";
    }
}
