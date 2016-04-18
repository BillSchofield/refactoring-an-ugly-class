package com.thoughtworks.exercise;

public class Partition {
    public Partition(String n) throws PartitionDoesNotExistException {
        if (!DiskUtils.getInstance().canFindPartition(n)){
            throw new PartitionDoesNotExistException();
        }
        // initialize partition
    }
}
