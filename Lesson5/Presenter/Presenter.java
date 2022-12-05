package Lesson5.Presenter;



import Lesson5.Model.Model;
import Lesson5.Presenter.Commands.Exit_Command;
import Lesson5.Presenter.Commands.NewUser_Command;
import Lesson5.View.View;

/**
 * presenter
 */

public class Presenter {
    public Presenter(View view, Model model) {
        this.model = model;
        this.view = view;
    }

    private int stage;

    public void Start() {
        Menu mainMenu = new Menu(view);
        mainMenu.addCommand(new NewUser_Command(view, null, model));
        mainMenu.addCommand(new Exit_Command());


        stage = 0;

    }

    private View view;
    private Model model;
    
}

