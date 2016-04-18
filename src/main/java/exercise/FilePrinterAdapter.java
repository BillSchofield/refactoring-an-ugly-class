package com.thoughtworks.exercise;

import java.io.File;

public class FilePrinterAdapter {
    public void print(File file) {
        FilePrinter filePrinter = new FilePrinter(file);
        filePrinter.print();
    }
}
