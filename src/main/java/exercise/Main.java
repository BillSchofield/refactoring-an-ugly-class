package exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws PartitionDoesNotExistException {
        String[] partitions = {"Partition1", "Partition2"};
        Defragger defragger = new Defragger(partitions);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DiskUtils instance = DiskUtils.getInstance();
        FilePrinterFactory filePrinterFactory = new FilePrinterFactory();
        FileManager fileManager = new FileManager(bufferedReader, instance, defragger, filePrinterFactory);
        fileManager.run();
    }
}
