
package Lesson6.Presenter.MenuItems;

import Lesson6.Model.Model;
import Lesson6.Presenter.Presenter;
import Lesson6.View.View;

/**
 * выход пользователя Logout
 */
public class UserLogout_MenuItem implements IMenuItem {
    public UserLogout_MenuItem(View view, Presenter presenter, Model model) {
        this.view = view;
        this.presenter = presenter;
        this.model = model;
    }

    @Override
    public String get_command() {
        return "logout";
    }

    @Override
    public String get_description() {
        return "Выход (Logout).";
    }

    @Override
    public void exercute() {
        presenter.currentUser = null;
        view.print("До свидания...");
    }

    private View view;
    private Model model;
    private Presenter presenter;
}