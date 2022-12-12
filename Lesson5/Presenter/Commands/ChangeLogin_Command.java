package Lesson5.Presenter.Commands;

import Lesson5.Model.Model;
import Lesson5.Model.User;
import Lesson5.Presenter.Presenter;
import Lesson5.View.View;

public class ChangeLogin_Command implements ICommand {
    public ChangeLogin_Command(View view, Presenter presenter, Model model, User user) {
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
    public void Exercute() {
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