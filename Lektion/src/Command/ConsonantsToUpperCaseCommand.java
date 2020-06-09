package Command;

public class ConsonantsToUpperCaseCommand implements Command {
    @Override
    public void execute(String t) {

        StringBuilder result = new StringBuilder(t.toLowerCase());
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            char consonant = t.charAt(i);
            switch (consonant) {
                case 'b':
                case 'c':
                case 'd':
                case 'f':
                case 'g':
                case 'h':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'v':
                case 'w':
                case 'x':
                case 'z':
                    result.setCharAt(i, Character.toUpperCase(consonant));
                    count++;
                    break;
            }
        }
        t = result.toString();
        System.out.println("Consonants to upper");
        System.out.println(t);
    }
}
