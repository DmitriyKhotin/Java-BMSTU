/*
* При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File.
* Прочитать текст Java-программы и удалить из него все “лишние” пробелы и табуляции, оставив только необходимые для разделения операторов.
 * */

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Создаем новую директорию и файл
            File dir = new File("C:\\University\\Java-BMSTU\\Laboratory5\\" + "output");
            dir.mkdir();
            File file = new File(dir, "output.txt");
            file.createNewFile();

            // Читаем входной файл
            BufferedReader reader = new BufferedReader(new FileReader("C:\\University\\Java-BMSTU\\Laboratory5\\Variant4_7.java"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line.trim() + "\n"); // Удаляем лишние пробелы и табуляции
            }
            reader.close();

            // Записываем результат в выходной файл
            FileWriter writer = new FileWriter(file);
            writer.write(sb.toString());
            writer.close();

            System.out.println("Completely done!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
