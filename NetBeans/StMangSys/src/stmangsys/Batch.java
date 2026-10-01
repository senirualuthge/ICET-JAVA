/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stmangsys;

/**
 * Represents a batch. Batch numbers are unique and start from 100.
 * Status: 1 = ENROLLMENT OPEN, 0 = ENROLLMENT CLOSED.
 *
 * @author cs
 */
public class Batch {

    public static final int STATUS_OPEN = 1;
    public static final int STATUS_CLOSED = 0;

    private String batchNo;
    private int status;

    public Batch(String batchNo, int status) {
        this.batchNo = batchNo;
        this.status = status;
    }

    @Override
    public String toString() {
        return batchNo + "\t" + getStatusText();
    }

    public String getBatchNo() {
        return batchNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusText() {
        return status == STATUS_OPEN ? "ENROLLMENT OPEN" : "ENROLLMENT CLOSED";
    }
}
