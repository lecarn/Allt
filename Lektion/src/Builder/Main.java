package Builder;

public class Main {

    public static void main(String[]args ){

        Computer comp = new Computer.ComputerBuilder("10000 TB", "5 GB")
                .setBluetoothEnabled(false)
                .build();
    }

}
