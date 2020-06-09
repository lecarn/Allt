package Command;

public class VowelsToWhilespaceCommand implements Command {
    @Override
    public void execute(String t) {

        String k = t.replaceAll("[aAeEiIoOuU]", " ");

        System.out.println("Vowels to white");
        System.out.println(k);

    }
}
