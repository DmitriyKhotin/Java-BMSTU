/*
 * Ввести с консоли n – размерность матрицы a[n][n].
 * Задать значения элементов матрицы в интервале значений от -n до n
 * с помощью датчика случайных чисел.
 */

/*
 *7. Повернуть матрицу на 90 (180, 270) градусов против часовой стрелки.
 *8. Вычислить определитель матрицы.
 */
import java.util.Scanner;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;


public class MyProgram
{

    public static int n;
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> array) {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            temp.add(i, new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                temp.get(i).add(j, array.get(j).get(i));
            }
        }
        return temp;
    }

    public static ArrayList<ArrayList<Integer>> mirrorHorizontal(ArrayList<ArrayList<Integer>> array) {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            int curString = n - i - 1;
            temp.add(i, new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                temp.get(i).add(j, array.get(curString).get(j));
            }
        }
        return temp;
    }

    public static ArrayList<ArrayList<Integer>> mirrorVertical(ArrayList<ArrayList<Integer>> array) {
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            temp.add(i, new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                temp.get(i).add(j, array.get(i).get(n - j - 1));
            }
        }
        return temp;
    }

    public static void print(ArrayList<ArrayList<Integer>> array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array.get(i).get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.close();
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            array.add(i, new ArrayList<Integer>());
            for (int j = 0; j < n; j++) {
                array.get(i).add(j, getRandomNumber(-n, n));
            }
        }

        print(array);
        print(transpose(array));
        System.out.println("On 90*");
        print(mirrorHorizontal(transpose(array)));
        System.out.println("On 180*");
        print(mirrorVertical(mirrorHorizontal(array)));
        System.out.println("On 270*");
        print(mirrorVertical(transpose(array)));

    }
}
