package Bridge;

public abstract class Car {
    Color color;

    public Car(Color c){this.color = c; }

    abstract public void applyColor();

}
