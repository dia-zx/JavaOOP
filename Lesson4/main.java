package Lesson4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Lesson4.Commands.Command_findparents;
import Lesson4.Commands.Command_load;
import Lesson4.Commands.Command_print;
import Lesson4.Commands.Command_save;
import Lesson4.Interfaces.ICommand;

/**
 * main
 */
public class main {
    public static List<ICommand> commands;

    public static void main(String[] args) {
        FamilyTree<SpecialPerson> tree = new FamilyTree<>(new SpecialPerson(0));
        testFillTree(tree);
        FamilyTreeUtils<SpecialPerson> utils = new FamilyTreeUtils<>(tree);

        // #region добавляем команды меню в список commands
        commands = new ArrayList<ICommand>();
        commands.add(new Command_print());
        commands.add(new Command_save());
        commands.add(new Command_load());
        commands.add(new Command_findparents());
        // #endregion

        Scanner scanner = new Scanner(System.in);

        do {
            printMenu();
            String input = scanner.nextLine();
            if (input.equals("exit"))
                break;

            boolean input_is_OK = false;
            for (ICommand command : commands) {
                if (input.equals(command.getName())) {
                    command.exercute(scanner, utils);
                    input_is_OK = true;
                    break;
                }
            }
            if (!input_is_OK)
                System.out.println("Неверная команда.");
        } while (true);
        scanner.close();
    }

    public static void printMenu() {
        System.out.println("***************** Меню ****************");
        System.out.println("Введите команду из списка:");
        System.out.println("exit - выход");
        for (ICommand command : commands) {
            System.out.println(command.info());
        }
        System.out.println("***************************************");
    }

    /**
     * Тестовое заполнение дерева
     * 
     * @param familyTree
     */
    public static void testFillTree(FamilyTree<SpecialPerson> familyTree) {
        SpecialPerson person1 = familyTree
                .addPerson(new SpecialPerson(0, "Дмитрий", "Ермоленко", "Юрьевич", Person.Gender.MALE, "Москва"));
        SpecialPerson person21 = familyTree.addPerson(
                new SpecialPerson(0, "Валентина", "Округина", "Владимировна", Person.Gender.FEMALE, "Ленинград"));
        SpecialPerson person22 = familyTree
                .addPerson(new SpecialPerson(0, "Иван", "Ермоленко", "Николаевич", Person.Gender.MALE, "Ленинград"));
        SpecialPerson person31 = familyTree
                .addPerson(new SpecialPerson(0, "Любовь", "Безрукова", "Ивановна", Person.Gender.FEMALE, "Горький"));
        SpecialPerson person32 = familyTree
                .addPerson(new SpecialPerson(0, "Владимир", "Округин", "Иванович", Person.Gender.MALE, "Москва"));
        SpecialPerson person33 = familyTree.addPerson(
                new SpecialPerson(0, "Вера", "Евдокимовна", "Михайловна", Person.Gender.FEMALE, "Волгоград"));
        SpecialPerson person34 = familyTree
                .addPerson(new SpecialPerson(0, "Николай", "Ермоленко", "Федорович", Person.Gender.MALE, "Москва"));

        familyTree.addRelation(new Relation(person21.id, person1.id, Relation.Type.CHILD));
        familyTree.addRelation(new Relation(person22.id, person1.id, Relation.Type.CHILD));
        familyTree.addRelation(new Relation(person31.id, person21.id, Relation.Type.CHILD));
        familyTree.addRelation(new Relation(person32.id, person21.id, Relation.Type.CHILD));
        familyTree.addRelation(new Relation(person33.id, person22.id, Relation.Type.CHILD));
        familyTree.addRelation(new Relation(person34.id, person22.id, Relation.Type.CHILD));
    }

}