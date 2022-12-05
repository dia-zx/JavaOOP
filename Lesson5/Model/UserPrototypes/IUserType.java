package Lesson5.Model.UserPrototypes;

import java.util.List;

import Lesson5.Presenter.Commands.ICommand;

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
