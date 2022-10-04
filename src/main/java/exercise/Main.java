package exercise;

public class Main {
    public static void main(String[] args) {
        String[] partitions = {"Partition1", "Partition2"};
        FileManager.init(partitions);
        FileManager.run();
    }
}
