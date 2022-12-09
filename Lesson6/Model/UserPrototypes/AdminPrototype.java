package Lesson6.Model.UserPrototypes;

import java.util.ArrayList;
import java.util.List;



public class AdminPrototype implements IUserType {
    public AdminPrototype() {
        list = new ArrayList<>();
        list.add("userlist");
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
        return "администратор";
    }
    
    private List<String> list;
}
