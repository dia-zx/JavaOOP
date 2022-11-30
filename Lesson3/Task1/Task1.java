/*
 * Создать метод, который принимает массив int и сортирует его по последней цифре.
 *  Используйте метод Arrays.sort. для его работы создайте свой компаратор. 
 * Имеется в виду последняя цифра в записи числа, например в числе 123, последння цифра 3.
 *  Надо сделать сортировку, которая учитывает только эту последнюю цифру в числе.
 */
package Lesson3.Task1;

import java.util.Arrays;
import java.util.Comparator;

public class Task1 {
    public static void main(String[] args) {
        Integer[] mas = new Integer[] { 1, 136, 58, 500, 87965, 983283 };
        sort(mas);
        for (int it : mas) {
            System.out.println(it);
        }

    }

    /**
     * Метод, сортирующий массив Integer[] по последней цифре.
     * 
     * @param mas
     * @return
     */
    public static Integer[] sort(Integer[] mas) {
        Arrays.sort(mas,
                new Comparator<Integer>() {
                    public int compare(Integer o1, Integer o2) {
                        return (o1 % 10) - (o2 % 10);
                    };
                });
        return mas;
    }

}
