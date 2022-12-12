package Lesson4.Interfaces;

import java.util.Scanner;

import Lesson4.FamilyTreeUtils;


public interface ICommand {
    /**
     * Информация о команде
     * @return
     */
    String info();

    /**
     * код команды при вводе с клавиатуры
     * @return
     */
    String getName();

    /**
     * Выполняемый метод
     * @param scanner 
     * @param utils
     */
    void exercute(Scanner scanner, FamilyTreeUtils utils);
}
