package Lesson6.Presenter.MenuItems;

import Lesson6.Model.Model;
import Lesson6.Model.User;
import Lesson6.Presenter.Presenter;
import Lesson6.View.View;

/**
 * Выдает список пользователей
 */
public class GetUserList_MenuItem implements IMenuItem {
    public GetUserList_MenuItem(View view, Presenter presenter, Model model, User user) {
        this.view = view;
        this.presenter = presenter;
        this.model = model;
        this.user = user;
    }

    @Override
    public String get_command() {
        return "userlist";
    }

    @Override
    public String get_description() {
        return "Список пользователей.";
    }

    @Override
    public void exercute() {
        view.print("************** " + get_command() + "************** ");
        for (User user : model.getUsers()) {
            view.print(user.toString());
        }
    }

    private View view;
    private Model model;
    private Presenter presenter;
    private User user;
}
