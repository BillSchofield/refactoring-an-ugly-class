package com.thoughtworks.exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws PartitionDoesNotExistException {
        String[] partitions = {"Partition1", "Partition2"};
        Defragger defragger = new Defragger(partitions);

        DiskUtils diskUtils = DiskUtils.getInstance();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileManager fileManager = new FileManager(diskUtils, bufferedReader, defragger, new FilePrinterAdapter());
        fileManager.run();
    }
}
