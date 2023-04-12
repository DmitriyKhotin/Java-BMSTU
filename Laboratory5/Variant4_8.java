/*
* При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File.
* Из текста Java-программы удалить все виды комментариев.
*/

import java.io.*;
import java.util.regex.*;
public class RemoveComments {
    public static void main(String[] args) throws IOException {
        // Создаем новый файл для результатов
        File dir = new File("C:\\University\\Java-BMSTU\\Laboratory5\\" + "output1");
        dir.mkdir();
        File file = new File(dir, "output.txt");
        file.createNewFile();

        // Читаем исходный файл
        BufferedReader reader = new BufferedReader(new FileReader("C:\\University\\Java-BMSTU\\Laboratory5\\Variant4_8.java"));

        String line = null;
        StringBuilder sb = new StringBuilder();
        boolean isMultilineComment = false;
        while ((line = reader.readLine()) != null) {
            if (!isMultilineComment) {
                // Удаляем однострочные комментарии
                int commentIndex = line.indexOf("//");
                if (commentIndex != -1) {
                    line = line.substring(0, commentIndex);
                }

                // Проверяем, начинается ли многострочный комментарий
                int openCommentIndex = line.indexOf("/*");
                if (openCommentIndex != -1) {
                    isMultilineComment = true;
                    line = line.substring(0, openCommentIndex);
                }
            } else {
                // Закрываем многострочный комментарий
                int closeCommentIndex = line.indexOf("*/");
                if (closeCommentIndex != -1) {
                    isMultilineComment = false;
                    line = line.substring(closeCommentIndex + 2);
                } else {
                    line = "";
                }
            }

            sb.append(line + "\n");
        }

        FileWriter writer = new FileWriter(file);
        writer.write(sb.toString());
        writer.close();
        reader.close();
    }
}
