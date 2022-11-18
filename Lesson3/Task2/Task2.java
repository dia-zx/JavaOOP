/*
 * Создайте класс, который представляет из себя коллекцию,
 *  добавьте 2 метода add и get для работы с коллекцией.
 *  Реализуйте возможность использования цикла for-each для работы с данной коллекцией.
 *  Для этого реализуйте интерфейс Iterable и создайте итератор.
 */
package Lesson3.Task2;

import java.util.Arrays;
import java.util.Collection;

/**
 * Task2
 */
public class Task2 {

    public static void main(String[] args) {
        MyCollection<String> myCollection;
        myCollection = new MyCollection<>();
        myCollection.add("one");
        myCollection.add("two");
        myCollection.add("three");
        myCollection.addAll(Arrays.asList("1", "2", "3"));
        print(myCollection);

        System.out.println("удаляем [3] элемент:");
        myCollection.remove(3);
        print(myCollection);

        System.out.println("удаляем \"two\" элемент:");
        myCollection.remove("two");
        print(myCollection);
    }

    public static <T> void print(Collection<T> collection){
        for ( T it : collection) {
            System.out.println(it);
        }
    }
}