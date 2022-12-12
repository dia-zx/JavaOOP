package Lesson5.Presenter.Commands;

import Lesson5.Model.Model;
import Lesson5.Model.User;
import Lesson5.Presenter.Presenter;
import Lesson5.View.View;

/**
 * Выдает список пользователей
 */
public class GetUserList_Command implements ICommand {
    public GetUserList_Command(View view, Presenter presenter, Model model, User user) {
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
    public void Exercute() {
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
