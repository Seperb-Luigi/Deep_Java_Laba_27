package lab27.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Путь к файлу
        String filePath = "src/TDir/file.txt";

        // Читаем и выводим содержимое файла в консоль
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Метод для чтения содержимого файла в строку (для тестов)
    public static String readFileContent(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }
}