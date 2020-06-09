package sample;


import java.util.Random;

public class Rowboat implements iBoat {

    int size = 2;

    public Rowboat(){
        String start = random();
        check(start);

    }

    @Override
    public void create() {

    }

    @Override
    public boolean check(String start) {
        if()

        return false;

    }

    @Override
    public String random() {
        String letter = "abcdef";
        Random r = new Random();
        String number = Integer.toString(r.nextInt(6+1));
        String choice = letter.charAt(r.nextInt(6+1))+number;

        return choice;
    }

}
