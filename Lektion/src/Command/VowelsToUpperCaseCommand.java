package Command;

public class VowelsToUpperCaseCommand implements Command {

    @Override
    public void execute(String t) {
        StringBuilder result = new StringBuilder(t.toLowerCase());
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            char vowel = t.charAt(i);
            switch (vowel) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    result.setCharAt(i, Character.toUpperCase(vowel));
                    count++;
                    break;
            }
        }
        t = result.toString();
        System.out.println("Vowels to upper");
        System.out.println(t);
    }
}