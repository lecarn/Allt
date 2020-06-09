package Bridge;

public class Bmw extends Car {

    public Bmw(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.println("Bmw have been painted");
        color.applyColor();

    }
}
