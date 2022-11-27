package Lesson4.Commands;

import java.util.List;
import java.util.Scanner;

import Lesson4.FamilyTreeUtils;
import Lesson4.Person;
import Lesson4.Interfaces.ICommand;

/*
 * Поиск родителей для персоны ID
 */
public class Command_findparents implements ICommand {

    @Override
    public String info() {
        return "findparents - нахождение родителей персоны с ID";
    }

    @Override
    public String getName() {
        return "findparents";
    }

    @Override
    public void exercute(Scanner scanner, FamilyTreeUtils utils) {
        System.out.println("Введите ID: ");
        String input = scanner.nextLine();
        List<Person> parents = utils.FindParents(Integer.parseInt(input));
        for (Person person : parents) {
            System.out.println(person);
        }

    }

}
