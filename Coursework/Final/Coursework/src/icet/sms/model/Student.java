package icet.sms.model;

public class Student {
    private String registrationNo;
    private String name;
    private String nic;
    private int prfMarks;
    private int dbmsMarks;
    private int batchId;

    public Student(String registrationNo, String name, String nic,
                   int prfMarks, int dbmsMarks, int batchId) {
        this.registrationNo = registrationNo;
        this.name = name;
        this.nic = nic;
        this.prfMarks = prfMarks;
        this.dbmsMarks = dbmsMarks;
        this.batchId = batchId;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

    public int getBatchId() {
        return batchId;
    }

    public double calculateGPA() {
        double prfGPA = getGPAFromMarks(prfMarks);
        double dbmsGPA = getGPAFromMarks(dbmsMarks);
        return (prfGPA + dbmsGPA) / 2.0;
    }

    private double getGPAFromMarks(int marks) {
        if (marks >= 80) return 4.0;
        if (marks >= 70) return 3.5;
        if (marks >= 60) return 3.0;
        if (marks >= 50) return 2.5;
        if (marks >= 40) return 2.0;
        if (marks >= 30) return 1.5;
        if (marks >= 20) return 1.0;
        if (marks >= 0)  return 0.0;
        return 0.0; // -1 absent or -2 not conducted -> GPA 0.0
    }

    public boolean isEligibleForIndustryTraining() {
        if (calculateGPA() <= 3.25) return false;
        if (prfMarks <= 50) return false;
        if (dbmsMarks <= 50) return false;
        return true;
    }

    @Override
    public String toString() {
        return registrationNo + " | " + name + " | " + nic +
               " | PRF: " + prfMarks + " | DBMS: " + dbmsMarks +
               " | GPA: " + String.format("%.2f", calculateGPA());
    }
}
