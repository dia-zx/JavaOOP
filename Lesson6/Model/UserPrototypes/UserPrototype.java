package Lesson6.Model.UserPrototypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Прототип обычного пользователя
 */
public class UserPrototype implements IUserType {
   public UserPrototype() {
    list = new ArrayList<>();
    list.add("changePassword");
    list.add("login_change");   
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