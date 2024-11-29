package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


/**
 * Класс описывающий объект типа TaskAccount
 * @author Sani4
 * @version 1.0
 */
public class TaskAccount implements Serializable {

    /**Поле идентификатор  задачи   */
    private Integer id;
    /**Поле имени  задачи   */
    private String name;
    /**Поле описания  задачи   */
    private String description; // описание задачи
    /**Поле статуса  задачи   */
    private Boolean status; // completed or not completed (завершена или нет)
    /**Поле даты создания  задачи   */
    private Date dateOfExec; // дата выполнения задачи
    /**Поле имени владельца задачи   */
    private  String owner; // владелец (создатель) задачи

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        TaskAccount that = (TaskAccount) object;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(status, that.status) && Objects.equals(dateOfExec, that.dateOfExec) && Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, status, dateOfExec, owner);
    }

    @Override
    public String toString() {
        return "TaskAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", dateOfExec=" + dateOfExec +
                ", owner='" + owner + '\'' +
                '}';
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - идентификатор задачи
     * @param name -имя  задачи
     * @param description - описание задачи
     * @param status - статус задачи
     * @param  dateOfExec - дата создания задачи
     * @param owner - владелец задачи
     */
    public TaskAccount(Integer id, String name, String description, Boolean status, Date dateOfExec, String owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.dateOfExec = dateOfExec;
        this.owner = owner;
    }


    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @see TaskAccount#TaskAccount(Integer, String, String, Boolean, Date, String)
     */
    public TaskAccount(Integer id, String name, Date dateOfExec, String owner) {
        this.id = id;
        this.name = name;
        this.dateOfExec = dateOfExec;
        this.owner = owner;
    }

    /**
     * Геттер
     * @return возвращает id задачи
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
     * @return возвращает имя задачи
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер
     * @param  name - устанавливает имя задачи
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Геттер
     * @return возвращает описание задачи
     */
    public String getDescription() {
        return description;
    }

    /**
     * Сеттер
     * @param  description - устанавливает описание задачи
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Геттер
     * @return возвращает статус задачи
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Сеттер
     * @param status - устанавливает статус задачи
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Геттер
     * @return возвращает дату создания задачи
     */
    public Date getDateOfExec() {
        return dateOfExec;
    }

    /**
     * Сеттер
     * @param  dateOfExec - устанавливает дату создания задачи
     */
    public void setDateOfExec(Date dateOfExec) {
        this.dateOfExec = dateOfExec;
    }

    /**
     * Геттер
     * @return возвращает владельца задачи
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Сеттер
     * @param  owner - устанавливает владельца задачи
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }



}
