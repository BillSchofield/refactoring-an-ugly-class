package com.thoughtworks.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


/*
    Conditionals inside loops
    Lots of ifs
X   Not Testable - New Statements
X   Not Testable - Singleton
    Long method
    Strings are inline
X   Variable names are unclear & Undescriptive
X   Inconsistent white space
    Null checks
X   Duplication - DiskUtils
    Default assignments
X   Method is static
    Passing 'this' to defragger

 */

public class FileManager {
    private final FilePrinterAdapter filePrinterAdapter;
    private Defragger defragger;
    private final DiskUtils diskUtils;
    private String input = null;
    private BufferedReader bufferedReader;

    public FileManager(DiskUtils diskUtils, BufferedReader bufferedReader, Defragger defragger, FilePrinterAdapter filePrinterAdapter) {
        this.diskUtils = diskUtils;
        this.bufferedReader = bufferedReader;
        this.defragger = defragger;
        this.filePrinterAdapter = filePrinterAdapter;
    }

    public void run() throws PartitionDoesNotExistException {
        while (!input("Enter disk command").equals("quit")) {
            String input1 = getInput();
            if (input1.equals("format")) {
                format();
            } else if (input1.equals("print")) {
                print();
            } else if (input1.equals("defrag")) {
                defrag();
            }
        }
    }

    private void format() {
        diskUtils.format(this.input("Enter name of drive to format"));
    }

    private void defrag() throws PartitionDoesNotExistException {
        diskUtils.useDefragger(this, defragger);
    }

    private void print() {
        String fileName = input("Enter file name");
        File file = diskUtils.getFile(fileName);
        filePrinterAdapter.print(file);
    }

    public String getInput() {
        if (input == null) {
            input = input();
        }
        return input;
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
