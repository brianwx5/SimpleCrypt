import static java.lang.Character.*;

public class ROT13 {
    protected int shift;


    ROT13(Character cs, Character cf) {
        this.shift = (cf - cs);
    }

    ROT13() {
        this.shift = 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return encrypt(text);

    }

    public String encrypt(String text) {
        String answer = rotateByCharacterPosition(text, shift);
        return answer;
    }

    public String decrypt(String text) {
        String answer = rotateByCharacterPosition(text, shift);
        return answer;
    }

    public static String rotate(String s, Character c) {
        int characterIndex = s.indexOf(c);
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(characterIndex) + s.substring(0, characterIndex));
        return sb.toString();
    }

    public String rotateByCharacterPosition(String s, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i)) && Character.isLowerCase(s.charAt(i))) {
                sb.append((char) (((s.charAt(i) - 'a' + shift) % 26) + 'a'));
            } else if (Character.isAlphabetic(s.charAt(i)) && Character.isUpperCase(s.charAt(i))) {
                sb.append((char) (((s.charAt(i) - 'A' + shift) % 26) + 'A'));
            } else sb.append(s.charAt(i));
        }
        return sb.toString();
    }


}
