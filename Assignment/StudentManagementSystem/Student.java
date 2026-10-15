public class Student {

    public static final int MARK_NOT_CONDUCTED = -2;
    public static final int MARK_ABSENT = -1;

    private final String registrationNo;
    private String nic;
    private String name;
    private int prfMarks = MARK_NOT_CONDUCTED;
    private int dbmsMarks = MARK_NOT_CONDUCTED;
    private final int batchNumber;
    private final boolean physical;

    public Student(String registrationNo, String nic, String name, int batchNumber, boolean physical) {
        this.registrationNo = registrationNo;
        this.nic = nic;
        this.name = name;
        this.batchNumber = batchNumber;
        this.physical = physical;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrfMarks() {
        return prfMarks;
    }

    public void setPrfMarks(int prfMarks) {
        this.prfMarks = prfMarks;
    }

    public int getDbmsMarks() {
        return dbmsMarks;
    }

    public void setDbmsMarks(int dbmsMarks) {
        this.dbmsMarks = dbmsMarks;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public boolean isPhysical() {
        return physical;
    }

    public double getGpa() {
        return GpaUtil.studentGpa(this);
    }
}
