package Lesson5.Presenter;

import Lesson5.Model.Model;
import Lesson5.Model.User;
import Lesson5.Model.UserPrototypes.AdminPrototype;
import Lesson5.Presenter.Commands.ChangePassword_Command;
import Lesson5.Presenter.Commands.Exit_Command;
import Lesson5.Presenter.Commands.NewUser_Command;
import Lesson5.Presenter.Commands.UserLogin_Command;
import Lesson5.Presenter.Commands.UserLogout_Command;
import Lesson5.View.View;

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
        model.addUser(new User("admin", "admin", "admin", "admin", new AdminPrototype()));
        view.print("в БД добавлен тестовый администратор (логин: \"admin\", пароль: \"admin\")");

        Menu mainMenu = new Menu(view);
        mainMenu.addCommand(new NewUser_Command(view, this, model));
        mainMenu.addCommand(new UserLogin_Command(view, this, model));
        mainMenu.addCommand(new Exit_Command());

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
                        userMenu.addCommand(new UserLogout_Command(view, this, model));
                        break;
                    case "changePassword":
                        userMenu.addCommand(new ChangePassword_Command(view, this, model, currentUser));
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
