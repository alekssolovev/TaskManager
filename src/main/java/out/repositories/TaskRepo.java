package out.repositories;

import entity.TaskAccount;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Класс для хранения списка задач
 * @author Sani4
 * @version 1.0
 */
public class TaskRepo implements Serializable {

    private  ArrayList<TaskAccount> taskAccounts;


    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param taskAccounts - новый репозиторий задач
     */
    public TaskRepo(ArrayList<TaskAccount> taskAccounts ) {
        this.taskAccounts = taskAccounts;
    }

    /**
     * Геттер
     * @return возвращает список задач
     */
    public ArrayList<TaskAccount> getTaskAccounts() {
        return taskAccounts;
    }

    /**
     * Сеттер
     * @param taskAccounts - устанавливает список задач
     */
    public void setTaskAccounts(ArrayList<TaskAccount> taskAccounts) {
        this.taskAccounts = taskAccounts;
    }

    /**
     * Метод для поиска задачи
     * @param id идентификатор задачи
     * @return  задачу с заданным идентификатором id
     */
    public TaskAccount getTaskAccountById(int id) {
        return taskAccounts.stream().filter(t -> t.getId() == id).findFirst().orElse(null);

    }

}
