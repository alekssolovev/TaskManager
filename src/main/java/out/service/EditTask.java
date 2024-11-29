package out.service;

import entity.TaskAccount;
import in.InputDate;
import in.ReadString;
import out.repositories.EditInterface;
import out.repositories.TaskRepo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

/**
 * Класс для редактирования задач
 * @author Sani4
 * @version 1.0
 */

public class EditTask {
    /**Поле для хранения команд для редактирования полей класса TaskAccount  */
    private Map<String,EditInterface> editMap;
    /**Поле для хранения задач  */
    private TaskRepo taskRepo;
    /**Поле для внедрения зависимости  */
    private TaskAccount taskAccount;
    /**Поле для внедрения зависимости  */
    private InputDate inputDate;
    /**Поле для внедрения зависимости  */
    private ReadString readString;
    /**Поле для внедрения зависимости  */
    private Scanner scanner;
    /**Поле для внедрения зависимости  */
    private SaveTask saveTask;


    /**
     * Конструктор - создание нового объекта с определенными значениями
     * Создадим новую Map коллекцию в конструкторе со ссылкой на другие
     * классы, изменяющие параметры задачи.
     */
    public EditTask(TaskRepo taskRepo, InputDate inputDate, ReadString readString,Scanner scanner) {
        this.taskRepo = taskRepo;
        this.inputDate = inputDate;
        this.scanner = scanner;
        editMap = new HashMap<>();

       editMap.put("date",new EditDateTask(taskRepo,taskAccount,inputDate,scanner));
       editMap.put("description",new EditDescriptionTask(taskRepo,taskAccount,readString));
       editMap.put("name",new EditNameTask(taskRepo,taskAccount,readString));
       editMap.put("status",new EditStatusTask(taskRepo,taskAccount,readString));

    }

    /**
     * Метод, который вызывает методы для редактирования задачи
     * @param id идентификатор задачи
     */
    public void editTask(String varParam, int id,String filePath) {
        taskAccount = taskRepo.getTaskAccountById(id);
        if (taskAccount == null)
            System.out.println("Задачи с указанным id не существует");

         try{
             EditInterface editInterface = Optional.ofNullable(editMap.get(varParam))
                     .orElseThrow(() -> new IllegalStateException("Параметр отсутствует "));
             editInterface.editTaskById(taskRepo, id);
            saveTask = new SaveTask(taskRepo);
            saveTask.save(taskRepo,filePath);
         }
         catch (NullPointerException | IOException  | IllegalStateException e) {
             throw  new NullPointerException();
         }
    }


}




