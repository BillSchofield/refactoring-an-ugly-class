package exercise;

public class Defragger {
    private String[] p;

    public Defragger(String[] p) {
        this.p = p;
    }

    public boolean canDefrag(String p) {
        for(String n : this.p){
            if (n.equals(p)){
                return true;
            }
        }
        return false;
    }

    public void defrag(String pn) {
        // code that defrags a physical hard drive partition
        System.out.println("Defragged Partition: " + pn);
    }
}
