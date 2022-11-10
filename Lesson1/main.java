package Lesson1;

import java.util.List;
import java.util.Scanner;

import Lesson1.Person.Gender;
import Lesson1.Relation.Type;

/**
 * main
 */
public class main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        FamilyTreeUtils utils = new FamilyTreeUtils(tree);
        utils.testFillTree();
        
        Scanner scanner = new Scanner(System.in);

        do {
            printMenu();
            String input = scanner.nextLine();
            if (input.equals("exit"))
                return;
            switch (input) {
                case "print":
                    utils.print();
                    break;
                case "save":
                    tree.save("FamilyTree.dat");
                    break;
                case "load":
                    tree.load("FamilyTree.dat");
                    break;
                case "findparents":
                    System.out.println("Введите ID: ");
                    input = scanner.nextLine();
                    List<Person> parents = utils.FindParents(Integer.parseInt(input));
                    for (Person person : parents) {
                        System.out.println(person);
                    }
                    break;
            
                
                default:
                System.out.println("Неверная команда.");
                    break;
            }

        } while (true);

        



    }

    public static void printMenu() {
        System.out.println("***************** Меню ****************");
        System.out.println("Введите команду из списка:");
        System.out.println("exit - выход");
        System.out.println("print - вывод дерева");
        System.out.println("save - сохранени в файл");
        System.out.println("load - загрузка дерева из файла");
        System.out.println("findparents - нахождение родителей персоны с ID");
        System.out.println("***************************************");
    }





}