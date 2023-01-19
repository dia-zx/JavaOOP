package Lesson6.Presenter.MenuItems;

import Lesson6.Model.Model;
import Lesson6.Model.User;
import Lesson6.Presenter.Presenter;
import Lesson6.View.View;

public class ChangePassword_MenuItem implements IMenuItem {
    public ChangePassword_MenuItem(View view, Presenter presenter, Model model, User user) {
        this.view = view;
        this.presenter = presenter;
        this.model = model;
        this.user = user;
    }

    @Override
    public String get_command() {
        return "changePassword";
    }

    @Override
    public String get_description() {
        return "Смена пароля.";
    }

    @Override
    public void exercute() {
        view.print("************** " + get_command() + "************** ");
        view.print("Введите старый пароль:");
        String oldpassword = view.input();

        view.print("Введите новый пароль:");
        String newpassword = view.input();
        try {
            Model.checkPassword(newpassword);
        } catch (Exception e) {
            view.print(e.getMessage());
            return;
        }
        if (user.changePassword(newpassword, oldpassword)) {
            view.print("Пароль успешно изменен!");
            return;
        }
        view.print("Неверный логин или пароль...");
    }

    private View view;
    private Model model;
    private Presenter presenter;
    private User user;
}
