/*
 7. Ввести n слов с консоли.
 * Найти слово, состоящее только из различных символов.
 * Если таких слов несколько, найти первое из них.
 */

/*
 * 8. Ввести n слов с консоли.
 * Среди слов, состоящих только из цифр, найти слово-палиндром.
 * Если таких слов больше одного, найти второе из них.
 */
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class MyProgram
{
    public static Boolean flag;
    public static String result;
    public static void main(String[] args)
    {
        Date taskGetDate = new Date(123, 2, 17);
        System.out.println("Khotin Dmitriy");
        System.out.println("Task get: " + taskGetDate);
        System.out.println("Task done: " + new Date());
        Scanner in = new Scanner(System.in);
        String str;
        ArrayList<String> arrayList = new ArrayList<String>();

        do {
            str = in.nextLine();
            if (!str.equals("")) {
                arrayList.add(str);
            }
        } while (!str.equals(""));
        in.close();

        // MyObject result = new MyObject<String>("");
        // MyObject flag = new MyObject<Boolean>(false);
        result = "";
        flag = false;
        arrayList.forEach((newString) -> System.out.print(newString + " "));
        System.out.print("\n");
        arrayList.forEach((checkString) -> {
            if (checkString.length() == checkString.chars().distinct().count() && flag != true) {
                result = checkString;
                flag = true;
            }
        });
        if (result != "") {
            System.out.println("\n" + result);
        } else {
            System.out.println("Not exist");
        }
    }
}
