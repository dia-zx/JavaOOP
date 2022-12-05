package Lesson5.Model.UserPrototypes;

import java.util.ArrayList;
import java.util.List;



public class AdminPrototype implements IUserType {
    public AdminPrototype() {
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
        return "администратор";
    }
    
    private List<String> list;
}
