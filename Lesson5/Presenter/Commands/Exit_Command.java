package Lesson5.Presenter.Commands;

/**
 * Exit_Command
 */
public class Exit_Command implements ICommand{

    @Override
    public String get_command() {
        return "quit";
    }

    @Override
    public String get_description() {
        return "Выход из программы.";
    }

    @Override
    public void Exercute() {
        System.exit(0);        
    }    
}