package exercise;

public class Defragger {
    private String[] p;

    public Defragger(String[] p) {
        this.p = p;
    }

    public boolean canDefrag(Partition p) {
        for(String n : this.p){
            if (n.equals(p.toString())){
                return true;
            }
        }
        return false;
    }
}
