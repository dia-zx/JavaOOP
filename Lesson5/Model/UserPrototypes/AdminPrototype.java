package Lesson5.Model.UserPrototypes;

import java.util.ArrayList;
import java.util.List;

import Lesson5.Presenter.Commands.ICommand;

public class AdminPrototype implements IUserType {
   
    @Override
    public Type getType() {
        return Type.ADMIN;
    }

    @Override
    public List<ICommand> getCommands() {
        List<ICommand> list = new ArrayList<>();
        //list.add(null)
        return list;
    }

    @Override
    public String toString() {
        return "администратор";
    }
    
}
