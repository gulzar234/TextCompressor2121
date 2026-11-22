
import java.util.Locale;

public class Statistics {

    public static int getOriginalSize(String text) {
        return text.length();
    }

    public static int getCompressedSize(String text) {
        return text.length();
    }

    public static int getSavedCharacters(String original, String compressed) {
        return original.length() - compressed.length();
    }

    public static double getSavedPercentage(String original, String compressed) {

        if (original.length() == 0) {
            return 0;
        }

        return (double) getSavedCharacters(original, compressed)
                / original.length() * 100;
    }

    // Создаём текст отчёта
    public static String createReport(String original, String compressed) {

        int originalSize = getOriginalSize(original);
        int compressedSize = getCompressedSize(compressed);
        int saved = getSavedCharacters(original, compressed);
        double percentage = getSavedPercentage(original, compressed);

        String status = "SUCCESS";

        if (compressedSize > originalSize) {
            status = "WARNING: Compression increased file size!";
        }

        return String.format(Locale.US,
                "=== COMPRESSION REPORT ===%n%n" +
                        "Input File: raw_input.txt (%d chars)%n%n" +
                        "Output File: compressed.txt (%d chars)%n%n" +
                        "Space Saved: %d chars (%.2f%%)%n%n" +
                        "Status: %s",
                originalSize, compressedSize, saved, percentage, status);
    }
}
