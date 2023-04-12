/*
* В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия.
* При этом могут рассматриваться два варианта:
* • каждая строка состоит из одного слова;
* • каждая строка состоит из нескольких слов.
* Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле
* Определить частоту повторяемости букв и слов в стихотворении Александра Пушкина.
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
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

        Map<String, Integer> wordFrequency = new HashMap<>();
        Map<Character, Integer> letterFrequency = new HashMap<>();

        // Читаем входные данные построчно
        String line;
        while ((line = input.readLine()) != null) {
            // Разбиваем строку на слова
            String[] words = line.split(" ");

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (!word.isEmpty()) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    for (char c : word.toCharArray()) {
                        letterFrequency.put(c, letterFrequency.getOrDefault(c, 0) + 1);
                    }
                }
            }

        }
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            output.println(entry.getKey() + " : " + entry.getValue());

        }

        for (Map.Entry<Character, Integer> entry : letterFrequency.entrySet()) {
            output.println(entry.getKey() + " : " + entry.getValue());
        }

        // Закрываем файлы
        input.close();
        output.close();
    }
}
