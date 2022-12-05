package Lesson5.Presenter.Commands;

import Lesson5.Model.Model;
import Lesson5.Model.User;
import Lesson5.Presenter.Presenter;
import Lesson5.View.View;

public class UserLogin_Command implements ICommand {
    public UserLogin_Command(View view, Presenter presenter, Model model) {
        this.view = view;
        this.presenter = presenter;
        this.model = model;
    }

    @Override
    public String get_command() {
        return "login";
    }

    @Override
    public String get_description() {
        return "Вход зарегистрированного пользователя";
    }

    @Override
    public void Exercute() {
        view.print("************** " + get_command() + "************** ");
        view.print("Введите логин:");
        String login = view.input();
        view.print("Введите пароль:");
        String password = view.input();
        User user = model.getUser(login);
        if (user != null && user.checkPassword(password)) {
            presenter.currentUser = user;
            view.print("Добро пожаловать " + user.name + "!");
            return;
        }
        view.print("Неверный логин или пароль...");
    }

    private View view;
    private Model model;
    private Presenter presenter;
}
