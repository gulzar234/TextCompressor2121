
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== TEXT COMPRESSOR ===");
        System.out.println("1. Compression");
        System.out.println("2. Decompression");
        System.out.print("Choose mode: ");

        String choice = scanner.nextLine();

        try {

            if (choice.equals("1")) {

                // Режим сжатия
                String text = FileManager.readFile("input/raw_input.txt");

                String compressed = Compressor.compress(text);

                FileManager.writeFile("output/compressed.txt", compressed);

                String report = Statistics.createReport(text, compressed);

                System.out.println(report);

                FileManager.writeFile("output/stats_output.txt", report);

                System.out.println("\nCompression completed!");

            } else if (choice.equals("2")) {

                // Режим распаковки
                String compressed = FileManager.readFile("output/compressed.txt");

                String restored = Decompressor.decompress(compressed);

                FileManager.writeFile("output/restored.txt", restored);

                System.out.println("Decompression completed!");
                System.out.println("Restored text:");
                System.out.println(restored);

            } else {

                System.out.println("Invalid choice! Choose 1 or 2.");

            }

        } catch (IOException e) {

            System.out.println("File error: " + e.getMessage());

        } catch (IllegalArgumentException e) {

            System.out.println("Data error: " + e.getMessage());

        }

        scanner.close();
    }
}
