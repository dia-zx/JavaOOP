package Lesson2.Commands;

import java.util.Scanner;

import Lesson2.FamilyTreeUtils;
import Lesson2.Interfaces.ICommand;

/*
 * Сохранение дерева в файл "FamilyTree.dat"
 */
public class Command_save implements ICommand {

    @Override
    public String info() {
        return "save - сохранение в файл";
    }

    @Override
    public String getName() {
        return "save";
    }

    @Override
    public void exercute(Scanner scanner, FamilyTreeUtils utils) {
        utils.geFamilyTree().save("FamilyTree.dat");
    }

}
