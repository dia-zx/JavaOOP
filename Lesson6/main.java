package Lesson6;

import Lesson6.Model.Model;
import Lesson6.Presenter.Presenter;
import Lesson6.View.View;

public class main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Presenter presenter = new Presenter(view, model);
        presenter.Start();

    }
}
