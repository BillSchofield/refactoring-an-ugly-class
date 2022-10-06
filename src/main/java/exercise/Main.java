package exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] partitions = {"Partition1", "Partition2"};
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Defragger defragger = new Defragger(partitions);

        Map<String, Command> commandDispatcher = new HashMap<>();
        commandDispatcher.put("print", new PrintCommand(bufferedReader));
        commandDispatcher.put("format", new FormatCommand(bufferedReader, partitions));
        commandDispatcher.put("defrag", new DefragCommand(bufferedReader, defragger));
        QuitCommand quitCommand = new QuitCommand();
        commandDispatcher.put("quit", quitCommand);

        FileManager fileManager = new FileManager(bufferedReader, commandDispatcher, quitCommand);
        fileManager.run();
    }
}
