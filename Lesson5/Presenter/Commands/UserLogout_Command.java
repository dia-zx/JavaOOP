
package Lesson5.Presenter.Commands;

import Lesson5.Model.Model;
import Lesson5.Presenter.Presenter;
import Lesson5.View.View;

/**
 * выход пользователя Logout
 */
public class UserLogout_Command implements ICommand {
    public UserLogout_Command(View view, Presenter presenter, Model model) {
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
    public void Exercute() {
        presenter.currentUser = null;
        view.print("До свидания...");
    }
    
    private View view;
    private Model model;
    private Presenter presenter;
}