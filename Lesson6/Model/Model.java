package Lesson6.Model;

import java.util.Collection;
import java.util.HashMap;

public class Model {
    private HashMap<String, User> users;

    public Model() {
        users = new <String, User>HashMap();
    }

    /**
     * Возвращает число пользователей в БД
     * 
     * @return
     */
    public int getUserCount() {
        return users.size();
    }

    /**
     * Добавление пользователя
     * 
     * @param user
     */
    public void addUser(User user) throws RuntimeException {
        if (users.containsKey(user.getLogin())) {
            throw new RuntimeException("Пользователь с таким логином уже существует!");
        }
        users.put(user.getLogin(), user);
    }

    /**
     * Удаление пользователя
     * 
     * @param login
     */
    public void removeUser(String login) {
        users.remove(login);
    }

    /**
     * Возвращает список пользователей
     * @return
     */
    public Collection<User> getUsers() {
        return users.values();
    }

    /**
     * Возвращает экземпляр пользователя с указанным логином
     * 
     * @param login
     * @return User - OK; null - нет пользователя с таким логином
     */
    public User getUser(String login) {
        return users.get(login);
    }

    /**
     * Проверка существования логина
     * 
     * @param login
     * @return true - такой логин существует
     */
    public boolean FindLogin(String login) {
        return users.keySet().contains(login);
    }

    /**
     * Проверка логина на соответствие требованиям
     * 
     * @param login
     * @throws RuntimeException при несответствии
     */
    static public void checkLogin(String login) throws RuntimeException {
        if (login.length() < 5)
            throw new RuntimeException("Длина пароля (логина) должна быть >= 5 символов");
        if (login.contains(" "))
            throw new RuntimeException("Пробелы в логине/пароле не допустимы!");
    }

    /**
     * Смена логина пользователя
     * @param current_login
     * @param new_login
     * @param password
     * @throws RuntimeException
     */
    public void changeLogin(String current_login, String new_login, String password) throws RuntimeException{
        User user = getUser(current_login);
        if (user == null) {
            throw new RuntimeException("Пользователя с таким Login нет!");
        }

        checkLogin(new_login);

        if (FindLogin(new_login)) {
            throw new RuntimeException("Пользователь с таким Login уже есть!");
        }
        if (!user.changeLogin(new_login, password)) {
            throw new RuntimeException("Неверный пароль!");
        }
        users.remove(current_login);
        users.put(new_login, user);
    }


    /**
     * Проверка пароля на соответствие требованиям
     * 
     * @param password
     * @throws RuntimeException при несответствии пароля
     */
    static public void checkPassword(String password) throws RuntimeException {
        checkLogin(password);
        boolean letterOK = false;
        boolean numberOK = false;
        password = password.toLowerCase();
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                letterOK = true;
                continue;
            }
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                numberOK = true;
                continue;
            }
            throw new RuntimeException("Пароль должен содержать только буквы латинского алфавита и цифры!");
        }
        if (!letterOK) {
            throw new RuntimeException("Пароль должен содержать хотя бы 1 букву латинского алфавита!");
        }
        if (!numberOK) {
            throw new RuntimeException("Пароль должен содержать хотя бы 1 цифру!");
        }
    }

    /**
     * Возвращает требования к login пользователя
     * 
     * @return
     */
    static public String get_login_requarements() {
        return "Логин должен состоять из 5 и более символов. Пробелы не допустимы!";
    }

    /**
     * Возвращает требования к password пользователя
     * 
     * @return
     */
    static public String get_password_requarements() {
        return "Пароль должен состоять из 5 и более символов (буквы латинского алфавита и цифры). Пробелы не допустимы!";
    }
}
