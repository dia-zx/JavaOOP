package Lesson5.Presenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Lesson5.Presenter.Commands.ICommand;
import Lesson5.View.View;

public class Menu {
    public Menu(View view) {
        this.view = view;
        menuCommands = new HashMap<>();
    }

    public void clear() {
        menuCommands.clear();
    }

    public void addCommand(ICommand command) {
        menuCommands.put(command.get_command(), command);
    }

    public Icommand Exercute() {
        do {
            view.print("");
            view.print("------------------- меню ------------------");
            for (ICommand command : menuCommands.values()) {
                view.print(command.get_command() + " - " + command.get_description());
            }
            view.print("------------------- меню ------------------");
            view.print("Введите команду");
            String input = view.input();
            if (menuCommands.containsKey(input)) {
                return menuCommands.get(input);
            }
            view.print("неверная команда!");
        } while (true);
    }

    private View view;
    private HashMap<String, ICommand> menuCommands;
}
