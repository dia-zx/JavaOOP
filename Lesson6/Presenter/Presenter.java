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
        model.addUser(new User("Иван", "Грозный", "admin", "admin", new AdminPrototype()));
        view.print("в БД добавлен тестовый администратор (логин: \"admin\", пароль: \"admin\")");

        Menu mainMenu = new Menu(view);
        mainMenu.addCommand(new NewUser_MenuItem(view, this, model));
        mainMenu.addCommand(new UserLogin_MenuItem(view, this, model));
        mainMenu.addCommand(new Exit_MenuItem());

        Menu userMenu = new Menu(view);

        currentUser = null;

        do {
            do {
                view.print("");
                view.print("В БД всего " + model.getUserCount() + " пользователей");
                mainMenu.Exercute().Exercute();
            } while (currentUser == null);

            userMenu.currentUser = currentUser;
            userMenu.clear();

            for (String command : currentUser.type.getCommands()) {
                switch (command) {
                    case "logout":
                        userMenu.addCommand(new UserLogout_MenuItem(view, this, model));
                        break;
                    case "changePassword":
                        userMenu.addCommand(new ChangePassword_Command(view, this, model, currentUser));
                        break;
                    case "userlist":
                        userMenu.addCommand(new GetUserList_MenuItem(view, this, model, currentUser));
                        break;
                    case "login_change":
                        userMenu.addCommand(new ChangeLogin_MenuItem(view, this, model, currentUser));
                        break;
                }

            }

            do {
                userMenu.Exercute().Exercute();
            } while (currentUser != null);
        } while (true);

    }

    private View view;
    private Model model;

}
