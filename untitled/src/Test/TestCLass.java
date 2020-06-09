package Test;

public class TestCLass {
    private int anInt;

    public TestCLass(int anInt) {
        this.anInt = anInt;
    }

    public int getAnInt() {
        return anInt;
    }

    public void setAnInt(int anInt) {
        this.anInt = anInt;
    }

    public void count(){
        anInt++;
    }

    @Override
    public String toString() {
        return "TestCLass{" +
                "anInt=" + anInt +
                '}';
    }
}
