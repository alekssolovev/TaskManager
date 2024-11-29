package out.service;

import entity.TaskAccount;
import in.InputDate;
import out.repositories.EditInterface;
import out.repositories.TaskRepo;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;


/**
 * Класс для редактирования даты создания задачи
 * @author Sani4
 * @version 1.0
 */
public class EditDateTask implements EditInterface {
    /**Поле для обеспечения доступа к списку задач в репозитории */
    private TaskRepo taskRepo;
    /**Поле для внедрения зависимости */
    private TaskAccount taskAccount;
    /**Поле для внедрения зависимости */
    private InputDate inputDate;
    /**Поле для внедрения зависимости */
    private Scanner scanner;


    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param taskRepo - репозиторий задач
     * @param taskAccount - задача
     * @param inputDate - ввод даты от пользователя
     * @param  scanner - объект класса scanner
     */
    public EditDateTask(TaskRepo taskRepo, TaskAccount taskAccount, InputDate inputDate, Scanner scanner) {
        this.taskRepo = taskRepo;
        this.taskAccount = taskAccount;
        this.inputDate = inputDate;
        this.scanner = scanner;
    }

    /**
     * Метод для редактирования даты создания задачи
     * @param id идентификатор задачи
     */
    @Override
    public void editTaskById(TaskRepo taskRepo,int id)  {
        taskAccount = taskRepo.getTaskAccountById(id);
        System.out.println("Введите новую дату создания задачи");
        try {
            Date newDate = inputDate.inputDateFromUser(scanner);
            taskAccount.setDateOfExec(newDate);
            System.out.println("Параметр dateOfExec задачи с id: " + taskAccount.getId() + " был изменен. Новая дата: " + taskAccount.getDateOfExec());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
