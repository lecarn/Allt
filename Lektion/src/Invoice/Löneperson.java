package Invoice;

public class Löneperson {
    String namn;
    int lön;

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public int getLön() {
        return lön;
    }

    public void setLön(int lön) {
        this.lön = lön;
    }
    public void print(){
        System.out.println(namn+" har lönen");
        System.out.println(lön);
    }

}
