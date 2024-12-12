package lab27.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private final String filePath = "src/TDir/test.txt";

    @BeforeEach
    public void setup() throws IOException {
        // Создаем или очищаем файл перед каждым тестом
        Files.write(Paths.get(filePath), new byte[0]);
    }

    @AfterEach
    public void cleanup() throws IOException {
        // Удаляем файл после каждого теста
        Files.deleteIfExists(Paths.get(filePath));
    }

    @Test
    public void testReadFileContent() throws IOException {
        // Записываем данные в файл
        String expectedContent = "SHALOM\n";
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(expectedContent);
        }

        // Читаем данные из файла
        String actualContent = Main.readFileContent(filePath);
        System.out.print(actualContent);
        // Проверяем, что содержимое файла соответствует ожидаемому
        Assertions.assertEquals(expectedContent, actualContent, "Содержимое файла должно совпадать с ожидаемым.");
    }

    @Test
    public void testReadFileContentEmptyFile() throws IOException {
        // Читаем данные из пустого файла
        String actualContent = Main.readFileContent(filePath);

        // Проверяем, что содержимое файла пустое
        assertEquals("", actualContent, "Содержимое пустого файла должно быть пустой строкой.");
    }
}
