
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    // Чтение текста из файла
    public static String readFile(String fileName) throws IOException {

        return Files.readString(Path.of(fileName));
    }

    // Запись текста в файл
    public static void writeFile(String fileName, String text) throws IOException {

        Files.writeString(Path.of(fileName), text);
    }
}
