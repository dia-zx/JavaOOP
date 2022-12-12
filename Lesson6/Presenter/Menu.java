package Lesson6.Presenter;

import java.util.HashMap;
import java.util.List;

import Lesson6.Model.User;
import Lesson6.Presenter.MenuItems.IMenuItem;
import Lesson6.View.View;

public class Menu {
    public User currentUser;

    public Menu(View view) {
        this.view = view;
        menuItems = new HashMap<>();
        currentUser = null;
    }

    /**
     * Очистка списка команд меню
     */
    public void clear() {
        menuItems.clear();
    }

    /**
     * Добавление команды в меню команд
     * 
     * @param menuitem
     */
    public void addMenuItem(IMenuItem menuitem) {
        menuItems.put(menuitem.get_command(), menuitem);
    }

    /**
     * Добавление списка команд в меню команд
     * 
     * @param command
     */
    public void addMenuItems(List<IMenuItem> menuitems) {
        for (IMenuItem item : menuitems) {
            menuItems.put(item.get_command(), item);
        }
    }

    /**
     * Функционирование меню
     * 
     * @return
     */
    public IMenuItem exercute() {
        do {
            view.print("");
            view.print("------------------- меню ------------------");
            for (IMenuItem item : menuItems.values()) {
                view.print(item.get_command() + " - " + item.get_description());
            }
            view.print("-------------------------------------------");
            if (currentUser == null)
                view.print("Введите команду");
            else
                view.print(currentUser.name + " " + currentUser.secondName + ". Введите команду:");
            String input = view.input();
            if (menuItems.containsKey(input)) {
                return menuItems.get(input);
            }
            view.print("неверная команда!");
        } while (true);
    }

    private View view;
    private HashMap<String, IMenuItem> menuItems;
}
