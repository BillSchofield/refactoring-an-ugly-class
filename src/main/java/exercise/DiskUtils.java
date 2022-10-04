package exercise;

public class DiskUtils {
    private static DiskUtils instance = null;

    public void format(String input) {
        // code that formats a physical hard drive partition
        System.out.println("Formatted Partition: " + input);
    }

    public static DiskUtils getInstance() {
        if (instance == null){
            instance = new DiskUtils();
        }
        return instance;
    }

    public void defrag(Defragger df, String pn) {
        df.defrag(pn);
    }
}
