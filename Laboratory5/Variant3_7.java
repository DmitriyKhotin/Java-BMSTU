/*
* В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
* При этом могут рассматриваться два варианта:
* • каждая строка состоит из одного слова;
* • каждая строка состоит из нескольких слов.
* Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле
* В каждом слове стихотворения Николая Заболоцкого заменить первую букву слова на прописную.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        // Проверяем, были ли переданы аргументы командной строки
        if (args.length != 2) {
            System.out.println("Использование: java Main inputFile outputFile");
            return;
        }

        // Открываем файлы для чтения и записи
        BufferedReader input = new BufferedReader(new FileReader("C:\\University\\Java-BMSTU\\Laboratory5\\" + args[0]));
        PrintWriter output = new PrintWriter("C:\\University\\Java-BMSTU\\Laboratory5\\" + args[1]);

        // Читаем входные данные построчно
        String line;
        while ((line = input.readLine()) != null) {
            // Разбиваем строку на слова
            String[] words = line.split(" ");

            // Заменяем первую букву каждого слова на прописную
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (!word.isEmpty()) {
                    char firstChar = Character.toUpperCase(word.charAt(0));
                    words[i] = firstChar + word.substring(1);
                }
            }

            // Объединяем слова обратно в строку
            String result = String.join(" ", words);

            // Записываем полученный результат в выходной файл
            output.println(result);
        }

        // Закрываем файлы
        input.close();
        output.close();
    }
}
