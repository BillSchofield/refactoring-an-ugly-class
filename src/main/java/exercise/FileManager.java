package exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

//      Conditionals
//[X]   Names are hard to understand
//      getInput() vs input()
//[X]   Duplication of DiskUtils
//      run() is too long
//      Null checks
//[X]   No DI (new instances)
//[X]   No DI (singleton access)
//[X]   Run is a static method
//[X]   No constructor
//      Default field values
//      GetInput() is public?

public class FileManager {
    private Defragger defragger;
    private final BufferedReader bufferedReader;
    private final DiskUtils diskUtils;
    private final FilePrinterFactory filePrinterFactory;

    public FileManager(BufferedReader bufferedReader, DiskUtils diskUtils, Defragger defragger, FilePrinterFactory filePrinterFactory) {
        this.bufferedReader = bufferedReader;
        this.diskUtils = diskUtils;
        this.defragger = defragger;
        this.filePrinterFactory = filePrinterFactory;
    }

    public void run() throws PartitionDoesNotExistException {
        while (!input("Enter disk command").equals("quit")) {
            String command = input();
            if (command.equals("format")) {
                diskUtils.format(input("Enter name of drive to format"));
            } else if (command.equals("print")) {
                String fileName = input("Enter file name");
                File file = diskUtils.getFile(fileName);
                filePrinterFactory.create(file).print();
            } else if (command.equals("defrag")) {
                diskUtils.useDefragger(this, defragger);
            }
        }
    }

    private String input() {
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return "";
    }

    public String input(String prompt) {
        System.out.println(prompt);
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return "";
    }
}
