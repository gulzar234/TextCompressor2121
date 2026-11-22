
public class Decompressor {

    public static String decompress(String text) {

        String result = "";

        int i = 0;

        while (i < text.length()) {

            int start = i;

            // Читаем количество повторений
            while (i < text.length() &&
                    Character.isDigit(text.charAt(i))) {
                i++;
            }

            // Проверяем, есть ли число
            if (start == i) {
                throw new IllegalArgumentException("Invalid compressed text!");
            }

            int count;

            try {
                count = Integer.parseInt(text.substring(start, i));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid count!");
            }

            if (count <= 0) {
                throw new IllegalArgumentException("Count must be positive!");
            }

            // Проверяем, есть ли символ после числа
            if (i >= text.length()) {
                throw new IllegalArgumentException("Missing character!");
            }

            char ch = text.charAt(i);

            // Обрабатываем специальные символы
            if (ch == '\\') {

                i++;

                if (i >= text.length()) {
                    throw new IllegalArgumentException("Incomplete escape!");
                }

                ch = text.charAt(i);
            }

            // Восстанавливаем символы
            for (int j = 0; j < count; j++) {
                result = result + ch;
            }

            i++;
        }

        return result;
    }
}
