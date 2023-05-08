/*
* 6.	Не используя вспомогательных объектов, переставить отрицательные элементы данного списка в конец, а положительные – в начало этого списка.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(2);
        list.add(-3);
        list.add(4);
        list.add(5);
        list.add(-6);

        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
            while (i < j && list.get(i) >= 0) {
                i++;
            }
            while (i < j && list.get(j) < 0) {
                j--;
            }
            if (i < j) {
                Collections.swap(list, i, j);
            }
        }

        System.out.println(list);
    }
}
