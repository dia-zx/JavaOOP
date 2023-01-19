package Lesson6.Model.UserPrototypes;

import java.util.List;



/**
 * Интерфейс типа пользователя
 */
public interface IUserType {
    public enum Type {
        USER,
        ADMIN
    }

    /**
     * Тип пользрвателя
     * @return
     */
    public Type getType();

    /**
     * Выдает список команд, доступных пользователю
     * 
     * @return
     */
    public List<String> getCommands();

}
