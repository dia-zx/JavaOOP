package Lesson6.Presenter.MenuItems;

import Lesson6.Model.Model;
import Lesson6.Model.User;
import Lesson6.Presenter.Presenter;
import Lesson6.View.View;

public class UserLogin_MenuItem implements IMenuItem {
    public UserLogin_MenuItem(View view, Presenter presenter, Model model) {
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
    public void exercute() {
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
