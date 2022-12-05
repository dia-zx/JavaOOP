package Lesson5.Model;

import java.util.Calendar;
import java.util.Date;

import Lesson5.Model.UserPrototypes.IUserType;

public class User {

    public User(String name, String secondName, String login, String password, IUserType type) {
        this.name = name;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.type = type;
        reg_Date = Calendar.getInstance().getTime();
    }
    
    public String name;
    public String secondName;
    public IUserType type;

    
    
    /**
     * Изменение пароля
     * 
     * @param newPassword
     * @param oldPassword
     * @return true - пароль был изменен
     */
    public boolean changePassword(String newPassword, String oldPassword) {
        if (password.equals(this.password)) {
            password = newPassword;
            return true;
        }
        return false;
    }

    /**
     * Смена логина
     * 
     * @param newlogin новый логин
     * @param password пароль пользователя
     * @return true - логин изменен
     */
    public boolean changeLogin(String newlogin, String password) {
        if (password.equals(this.password)) {
            login = newlogin;
            return true;
        }
        return false;
    }

    /**
     * Логин пользователя
     * 
     * @return
     */
    public String getLogin() {
        return login;
    }



    /**
     * Дата регистрации пользователя
     * 
     * @return
     */
    public Date getRegDate() {
        return (Date) reg_Date.clone(); // защитим от изменений...
    }

    private String login;
    private String password;
    private Date reg_Date;

    @Override
    public String toString() {
        return "логин: " + login + " " + secondName + " " + name + " " + reg_Date.toString() + " - " + type.toString();
    }
}
