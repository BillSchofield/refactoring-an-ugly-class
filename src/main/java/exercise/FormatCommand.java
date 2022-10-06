package exercise;

import java.io.BufferedReader;
import java.io.IOException;

public class FormatCommand implements Command{
	private BufferedReader bufferedReader;
	private String[] partitions;

	public FormatCommand(BufferedReader bufferedReader, String[] partitions) {
		this.bufferedReader = bufferedReader;
		this.partitions = partitions;
	}

	@Override
	public void execute() {
		String result = "";
		System.out.println("Enter name of partition to format");
		try {
			result = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String n : partitions) {
			if (n.equals(result)) {
				DiskUtils.getInstance().format(result);
			}
		}

	}
}
