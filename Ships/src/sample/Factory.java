package sample;

public class Factory {

    Object o;

    public Object Create(int size) {
        switch (size) {
            case 2:
                Rowboat rb = new Rowboat();
                o = rb;
                break;
            case 3:
                Submarine sm = new Submarine();
                o = sm;
                break;
            case 4:
                Battleship bs = new Battleship();
                o = bs;
                break;
            case 5:
                Carrier carrier = new Carrier();
                o = carrier;
                break;
            default:
                System.out.println("You did wrong!");

        }
        return o;
    }

}
