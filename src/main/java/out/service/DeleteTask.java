package out.service;

import entity.TaskAccount;
import out.repositories.DeleteInterface;
import out.repositories.TaskRepo;

import java.io.IOException;


/**
 * Класс содержит метод для удаления задачи
 * @author Sani4
 * @version 1.0
 */
public class DeleteTask implements DeleteInterface {
    /**Поле для внедрения зависимости */
    private TaskAccount taskAccount;
    /**Поле для обеспечения доступа к списку задач в репозитории */
    private TaskRepo taskRepo;
    /**Поле для внедрения зависимости */
    private SaveTask saveTask;

    private String filePath;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param taskRepo - репозиторий задач
     */
    public DeleteTask(TaskRepo taskRepo,String filePath) {
        this.taskRepo = taskRepo;
        this.filePath = filePath;

    }


    /**
     * Метод для удаления задачи
     * @param id идентификатор задачи
     */
    @Override
    public void delete(int id) throws IOException {
        taskAccount = taskRepo.getTaskAccountById(id);
        taskRepo.getTaskAccounts().remove(taskAccount);
        System.out.println("Задача с id:" + id + " удалена");
        saveTask = new SaveTask(taskRepo);
        saveTask.save(taskRepo,filePath);

    }


}
