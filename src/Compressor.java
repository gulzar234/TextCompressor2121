
public class Compressor {

    public static String compress(String text) {

        String result = "";

        int count = 1;

        for (int i = 0; i < text.length(); i++) {

            if (i + 1 < text.length() &&
                    text.charAt(i) == text.charAt(i + 1)) {

                count++;

            } else {

                result = result + count + escapeCharacter(text.charAt(i));

                count = 1;
            }
        }

        return result;
    }

    public static String escapeCharacter(char ch) {

        if (Character.isDigit(ch) || ch == '\\') {
            return "\\" + ch;
        }

        return String.valueOf(ch);
    }
}
