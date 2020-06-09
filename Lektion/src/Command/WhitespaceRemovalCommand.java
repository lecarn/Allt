package Command;

public class WhitespaceRemovalCommand implements Command {
    @Override
    public void execute(String t) {
        String k = t.replaceAll("\\s+","");

        System.out.println("Whitespace removal");
        System.out.println(k);
    }
}
