package Lesson5.Presenter;

import java.util.HashMap;
import java.util.List;

import Lesson5.Model.User;
import Lesson5.Presenter.Commands.ICommand;
import Lesson5.View.View;

public class Menu {
    public User currentUser;

    public Menu(View view) {
        this.view = view;
        menuCommands = new HashMap<>();
        currentUser = null;
    }
    
    /**
     * Очистка списка команд меню
     */
    public void clear() {
        menuCommands.clear();
    }

    /**
     * Добавление команды в меню команд
     * @param command
     */
    public void addCommand(ICommand command) {
        menuCommands.put(command.get_command(), command);
    }

    /**
     * Добавление списка команд в меню команд
     * @param command
     */
    public void addCommands(List<ICommand> commands) {
        for (ICommand command : commands) {
            menuCommands.put(command.get_command(), command);            
        }
    }

    /**
     * Функционирование меню
     * @return
     */
    public ICommand Exercute() {
        do {
            view.print("");
            view.print("------------------- меню ------------------");
            for (ICommand command : menuCommands.values()) {
                view.print(command.get_command() + " - " + command.get_description());
            }
            view.print("-------------------------------------------");
            if(currentUser == null)
                view.print("Введите команду");
            else
                view.print(currentUser.name + " " + currentUser.secondName + ". Введите команду:");
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
