import java.util.*;

class  DEMOoop1 {
    class Student{
        private String name;
        private String regno;
        private String nic;
        private int batch;
        private int PrfM;
        private int DBSMm;
        
        Student(String name, String regno, String nic, int batch, int PrfM, int DBSMm) {
            this.name = name;
            this.regno = regno;
            this.nic = nic;
            this.batch = batch;
            this.PrfM = PrfM;
            this.DBSMm = DBSMm;
        }
        public String getname() {
            return name;
        }

        public String getregno() {
            return regno;
        }

        public String getnic() {
            return nic;
        }

        public int getbatch() {
            return batch;
        }

        public int getPrfM() {
            return PrfM;
        }

        public int getDBSMm() {
            return DBSMm;
        }

        public void setname(String name) {
        this.name = name;

        }
        
        public void setNic(String nic) {
        this.nic = nic;

        }
    
        public void setPrfMarks(int prfMarks) {
            this.PrfM = prfMarks;
        }

        public void setDbmsMarks(int dbmsMarks) {
            this.DBSMm = dbmsMarks;
        }
        


    }
    


    
    class Batch11{
        private int batchNo;
        private boolean enrollmentOpen;
        private int studentCount;

        Batch11(int batchNo, boolean enrollmentOpen, int studentCount) {
            this.batchNo = batchNo;
            this.enrollmentOpen = enrollmentOpen;
            this.studentCount = studentCount;
        }

        public int getBatchNo() {
        return batchNo;

        }
        
        public boolean isEnrollmentOpen() {
            return enrollmentOpen;
        }

        public int getStudentCount() {
            return studentCount;
        }
        
        public void setBatchNo(int batchNo) {
        this.batchNo = batchNo;
        }

        public void setEnrollmentOpen(boolean enrollmentOpen) {
            this.enrollmentOpen = enrollmentOpen;
        }

        public void setStudentCount(int studentCount) {
            this.studentCount = studentCount;
        }
    }

}