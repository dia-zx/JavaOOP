package Lesson6.Presenter;

import Lesson6.Model.Model;
import Lesson6.Model.User;
import Lesson6.Model.UserPrototypes.AdminPrototype;
import Lesson6.Presenter.MenuItems.*;
import Lesson6.View.View;

/**
 * presenter
 */

public class Presenter {
    public Presenter(View view, Model model) {
        this.model = model;
        this.view = view;
    }

    public User currentUser;

    public void Start() {
        currentUser = null;
        model.addUser(new User("Иван", "Грозный", "admin", "admin", new AdminPrototype()));
        view.print("в БД добавлен тестовый администратор (логин: \"admin\", пароль: \"admin\")");

        Menu mainMenu = createMainMenu();

        do {
            // #region Основное меню
            do {
                view.print("");
                view.print("В БД всего " + model.getUserCount() + " пользователей");
                mainMenu.exercute().exercute();
            } while (currentUser == null);
            // #endregion

            // #region Меню пользователя (различно для простого и администратора)
            Menu userMenu = createUserMenu();
            do {
                userMenu.exercute().exercute();
            } while (currentUser != null);
            // #endregion

        } while (true);
    }

    /**
     * Создание главного меню
     * 
     * @return
     */
    private Menu createMainMenu() {
        Menu mainMenu = new Menu(view);
        mainMenu.addMenuItem(new NewUser_MenuItem(view, this, model));
        mainMenu.addMenuItem(new UserLogin_MenuItem(view, this, model));
        mainMenu.addMenuItem(new Exit_MenuItem());
        return mainMenu;
    }

    /**
     * Создание меню пользователя
     * 
     * @return
     */
    private Menu createUserMenu() {
        Menu userMenu = new Menu(view);
        userMenu.currentUser = currentUser;
        for (String menuitem : currentUser.type.getCommands()) {
            switch (menuitem) {
                case "logout":
                    userMenu.addMenuItem(new UserLogout_MenuItem(view, this, model));
                    break;
                case "changePassword":
                    userMenu.addMenuItem(new ChangePassword_MenuItem(view, this, model, currentUser));
                    break;
                case "userlist":
                    userMenu.addMenuItem(new GetUserList_MenuItem(view, this, model, currentUser));
                    break;
                case "login_change":
                    userMenu.addMenuItem(new ChangeLogin_MenuItem(view, this, model, currentUser));
                    break;
            }
        }
        return userMenu;
    }

    private View view;
    private Model model;

}
