package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

public class FileManager {
	private final BufferedReader bufferedReader;
	private final QuitCommand quit;
	private final Map<String, Command> commandDispatcher;

	public FileManager(BufferedReader bufferedReader, Map<String, Command> commandDispatcher, QuitCommand quit) {
		this.bufferedReader = bufferedReader;
		this.commandDispatcher = commandDispatcher;
		this.quit = quit;
	}

	public void run() {
		do {
			String command = getInput();
			if (commandDispatcher.containsKey(command)) {
				commandDispatcher.get(command).execute();
			}
		} while (!quit.now());
	}
	private String getInput() {
		System.out.println("Enter disk command:");
		System.out.println("* format");
		System.out.println("* print");
		System.out.println("* defrag");
		System.out.println("* quit");
		String result = "";
		try {
			result = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}