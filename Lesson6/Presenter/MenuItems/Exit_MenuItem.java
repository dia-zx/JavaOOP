package Lesson6.Presenter.MenuItems;

/**
 * Exit_Command
 */
public class Exit_MenuItem implements IMenuItem{

    @Override
    public String get_command() {
        return "quit";
    }

    @Override
    public String get_description() {
        return "Выход из программы.";
    }

    @Override
    public void exercute() {
        System.exit(0);        
    }    
}