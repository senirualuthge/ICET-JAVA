/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stmangsys;

/**
 * In-memory collection of batches. Batch numbers are unique and start from 100.
 *
 * @author cs
 */
public class BatchCollection {

    private Batch[] batchArray = new Batch[]{
        new Batch("100", Batch.STATUS_CLOSED),
        new Batch("101", Batch.STATUS_OPEN),
        new Batch("102", Batch.STATUS_OPEN)
    };

    public boolean addNewBatch(Batch batch) {
        if (batch == null || batch.getBatchNo() == null) {
            return false;
        }
        if (searchBatch(batch.getBatchNo()) != null) {
            return false;
        }
        extendsBatchArray();
        batchArray[batchArray.length - 1] = batch;
        return true;
    }

    public Batch[] getAllBatch() {
        Batch[] tempBatchArray = new Batch[batchArray.length];
        for (int i = 0; i < batchArray.length; i++) {
            tempBatchArray[i] = batchArray[i];
        }
        return tempBatchArray;
    }

    public Batch searchBatch(String batchNo) {
        if (batchNo == null) {
            return null;
        }
        for (int i = 0; i < batchArray.length; i++) {
            if (batchNo.equalsIgnoreCase(batchArray[i].getBatchNo())) {
                return batchArray[i];
            }
        }
        return null;
    }

    /**
     * Number of students registered in the given batch.
     */
    public int getStudentCount(String batchNo) {
        return AccessStudentCollection.getInstance().getStudentCollection().getStudentsByBatch(batchNo).length;
    }

    /**
     * Next batch number: unique, sequential, starting from 100.
     */
    public String generateNextBatchNo() {
        int highest = 99;
        for (int i = 0; i < batchArray.length; i++) {
            try {
                int no = Integer.parseInt(batchArray[i].getBatchNo());
                if (no > highest) {
                    highest = no;
                }
            } catch (NumberFormatException e) {
                // ignore non numeric batch numbers
            }
        }
        return String.valueOf(highest + 1);
    }

    public boolean updateBatchStatus(String batchNo, int status) {
        Batch batch = searchBatch(batchNo);
        if (batch == null) {
            return false;
        }
        batch.setStatus(status);
        return true;
    }

    private void extendsBatchArray() {
        Batch[] tempBatchArray = new Batch[batchArray.length + 1];
        for (int i = 0; i < batchArray.length; i++) {
            tempBatchArray[i] = batchArray[i];
        }
        batchArray = tempBatchArray;
    }
}
