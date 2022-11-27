package Lesson2.Commands;

import java.util.Scanner;

import Lesson2.FamilyTreeUtils;
import Lesson2.Interfaces.ICommand;

/**
 * Вывод дерева на экран
 */
public class Command_print implements ICommand {

    @Override
    public String info() {
        return "print - вывод дерева";
    }

    @Override
    public String getName() {
        return "print";
    }

    @Override
    public void exercute(Scanner scanner, FamilyTreeUtils utils) {
        utils.print();
    }
}