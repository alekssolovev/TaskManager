package entity;

import java.util.List;



/**
 * Класс описывающий объект типа UserAccount
 * @author Sani4
 * @version 1.0
 */
public class UserAccount {
    /**Поле уникальный идентификатор  пользователя  */
    private  Integer id;
    /**Поле имени  пользователя  */
    private String username;
    /**Поле списка задач, который принадлежит пользователю   */
    private List<TaskAccount> tasks;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - идентификатор пользователя
     * @param username -имя пользователя
     * @param tasks - список задач пользователя
     */
    public UserAccount(Integer id, String username, List<TaskAccount> tasks) {
        this.id = id;
        this.username = username;
        this.tasks = tasks;
    }

    /**
     * Геттер
     * @return возвращает id пользователя
     */
    public Integer getId() {
        return id;
    }

    /**
     * Сеттер
     * @param  id - устанавливает идентификатор задачи
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Геттер
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер
     * @param  username - устанавливает имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Геттер
     * @return возвращает список задач пользователя
     */
    public List<TaskAccount> getTasks() {
        return tasks;
    }

    /**
     * Сеттер
     * @param  tasks - устанавливает список задач пользователя
     */
    public void setTasks(List<TaskAccount> tasks) {
        this.tasks = tasks;
    }



}
