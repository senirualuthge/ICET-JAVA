package icet.sms.model;

public class Batch {
    private int batchId;
    private String batchName;
    private int status; // 1 = ENROLLMENTOPEN, 0 = ENROLLMENTCLOSED

    public Batch(int batchId) {
        this.batchId = batchId;
        this.batchName = "Batch " + batchId;
        this.status = 1; // default ENROLLMENTOPEN
    }

    public int getBatchId() {
        return batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isEnrollmentOpen() {
        return status == 1;
    }

    @Override
    public String toString() {
        return batchName + " (ID: " + batchId + ") - " +
               (status == 1 ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED");
    }
}
