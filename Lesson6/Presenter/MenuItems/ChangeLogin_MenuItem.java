package Lesson6.Presenter.MenuItems;

import Lesson6.Model.Model;
import Lesson6.Model.User;
import Lesson6.Presenter.Presenter;
import Lesson6.View.View;

public class ChangeLogin_MenuItem implements IMenuItem {
    public ChangeLogin_MenuItem(View view, Presenter presenter, Model model, User user) {
        this.view = view;
        this.presenter = presenter;
        this.model = model;
        this.user = user;
    }

    @Override
    public String get_command() {
        return "login_change";
    }

    @Override
    public String get_description() {
        return "Изменение логина";
    }

    @Override
    public void exercute() {
        view.print("************** " + get_command() + "************** ");
        view.print("Введите новый логин:");
        String login = view.input();
        view.print("Введите пароль:");
        String password = view.input();
        try {
            model.changeLogin(user.getLogin(), login, password);
        } catch (RuntimeException e) {
            view.print(e.getMessage());
            return;
        }
        view.print("Логин успешно изменен!");
    }

    private View view;
    private Model model;
    private Presenter presenter;
    private User user;
}