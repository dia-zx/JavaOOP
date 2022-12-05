package Lesson5.Model.UserPrototypes;

import java.util.ArrayList;
import java.util.List;


public class UserPrototype implements IUserType {
   public UserPrototype() {
    List<String> list = new ArrayList<>();
    list.add("logout");        
   }

    @Override
    public Type getType() {
        return Type.ADMIN;
    }

    @Override
    public List<String> getCommands() {
        return list;
    }

    @Override
    public String toString() {
        return "пользователь";
    }
    
    private List<String> list;
}