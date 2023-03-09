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
import java.util.*;
import java.util.ArrayList;
import java.util.Random;

public class MyProgram
{

    public static int n;
    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void print(int[][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(array[i][j] + " ");
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
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = getRandomNumber(-n, n);
            }
        }

        print(array);
        Determin dd = new Determin(array);
        dd.getValue();
    }
}


class Determin {
    private double summ;

    public Determin(int[][] matrix) {
        getReduction(matrix, 1);
    }


    public void getValue() {
        System.out.println(this.summ);
    }


    private void getReduction(int [][] subMinor, double elemParentMinor) {
        if (subMinor.length > 1){
            int [][] tmpMinor = new int[subMinor.length - 1][subMinor[0].length - 1];
            for (int c = 0; c < subMinor[0].length; c++) {
                for (int i = 1; i < subMinor.length; i++) {
                    for (int j = 0; j < subMinor[0].length; j++) {
                        if (j < c)
                            tmpMinor[i - 1][j] = subMinor[i][j];
                        else if (j > c)
                            tmpMinor[i - 1][j - 1] = subMinor[i][j];
                    }
                }
                double paramForSub = Math.round(Math.pow(-1,c+2))*Math.round(subMinor[0][c])*Math.round(elemParentMinor);
                getReduction(tmpMinor, paramForSub);
            }
        }
        else
            this.summ += elemParentMinor * subMinor[0][0];
    }

}









