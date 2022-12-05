package Lesson5;

import Lesson5.Model.Model;
import Lesson5.Model.User;
import Lesson5.Model.UserPrototypes.AdminPrototype;
import Lesson5.Presenter.Presenter;
import Lesson5.View.View;

public class main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Presenter presenter = new Presenter(view, model);
        presenter.Start();

    }
    
}
