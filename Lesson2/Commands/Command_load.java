package Lesson2.Commands;

import java.util.Scanner;

import Lesson2.FamilyTreeUtils;
import Lesson2.Interfaces.ICommand;

/**
 * Загрузка дерева из файла "FamilyTree.dat"
 */
public class Command_load implements ICommand {

    @Override
    public String info() {
        return "load - загрузка дерева из файла";
    }

    @Override
    public String getName() {
        return "load";
    }

    @Override
    public void exercute(Scanner scanner, FamilyTreeUtils utils) {
        utils.geFamilyTree().load("FamilyTree.dat");
    }

}
