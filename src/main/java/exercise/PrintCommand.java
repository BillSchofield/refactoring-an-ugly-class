package exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class PrintCommand implements Command {
	private BufferedReader bufferedReader;

	public PrintCommand(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void execute() {
		String fn = "";
		System.out.println("Enter name of file to print");
		try {
			fn = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(fn);
		FilePrinter fp = new FilePrinter(file);
		fp.print();

	}
}
