/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stmangsys;

/**
 * Singleton access point to the BatchCollection, mirroring
 * AccessStudentCollection.
 *
 * @author cs
 */
public class AccessBatchCollection {

    private BatchCollection batchCollection;

    private static AccessBatchCollection accessBatchCollection;

    private AccessBatchCollection() {
        batchCollection = new BatchCollection();
    }

    public static AccessBatchCollection getInstance() {
        if (accessBatchCollection == null) {
            accessBatchCollection = new AccessBatchCollection();
        }
        return accessBatchCollection;
    }

    public BatchCollection getBatchCollection() {
        return batchCollection;
    }
}
