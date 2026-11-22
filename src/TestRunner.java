
import java.nio.file.Files;
import java.nio.file.Path;

public class TestRunner {

    public static void main(String[] args) {

        int passed = 0;
        int failed = 0;

        for (int i = 1; i <= 10; i++) {

            try {

                String input = Files.readString(
                        Path.of("tests/test" + i + "_input.txt"));

                String expected = Files.readString(
                        Path.of("tests/test" + i + "_expected.txt"));

                String actual = Compressor.compress(input);

                if (actual.equals(expected)) {

                    System.out.println("Test " + i + ": PASSED");
                    passed++;

                } else {

                    System.out.println("Test " + i + ": FAILED");
                    System.out.println("Expected: " + expected);
                    System.out.println("Actual: " + actual);
                    failed++;
                }

            } catch (Exception e) {

                System.out.println("Test " + i + ": ERROR - " + e.getMessage());
                failed++;
            }
        }

        System.out.println("\n=== TEST RESULTS ===");
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
    }
}
