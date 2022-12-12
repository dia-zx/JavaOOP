package Lesson5.Presenter.Commands;

import Lesson5.Model.Model;
import Lesson5.Model.User;
import Lesson5.Model.UserPrototypes.UserPrototype;
import Lesson5.Presenter.Presenter;
import Lesson5.View.View;

/**
 * NewUser_Command
 */
public class NewUser_Command implements ICommand {
    public NewUser_Command(View view, Presenter presenter, Model model) {
        this.view = view;
        this.presenter = presenter;
        this.model = model;
    }

    @Override
    public String get_command() {
        return "newuser";
    }

    @Override
    public String get_description() {
        return "Добавление нового пользователя";
    }

    @Override
    public void Exercute() {
        view.print("************** " + get_command() + "************** ");
        view.print("Введите логин + (" + Model.get_login_requarements() + ")");
        String login = view.input();
        try {
            Model.checkLogin(login);
        } catch (Exception e) {
            view.print(e.toString());
            return;
        }

        view.print("Ваше Имя:");
        String name = view.input();

        view.print("Ваша Фамилия:");
        String second_name = view.input();

        view.print("Введите пароль (" + Model.get_password_requarements() + ")");
        String password = view.input();
        try {
            Model.checkPassword(password);
        } catch (Exception e) {
            view.print(e.toString());
            return;
        }

        view.print("Подтвердите пароль: ");
        String passwordConfirm = view.input();
        if (password.equals(passwordConfirm)) {
            try {
                model.addUser(new User(name, second_name, login, password, new UserPrototype()));
            } catch (Exception e) {
                view.print(e.getMessage());
            }
        }

    }

    private View view;
    private Model model;
    private Presenter presenter;
}