package out.service;

import entity.TaskAccount;
import in.ReadString;
import out.repositories.EditInterface;
import out.repositories.TaskRepo;

/**
 * Класс для редактирования имени задачи
 * @author Sani4
 * @version 1.0
 */
public class EditNameTask implements EditInterface {
    /**Поле для обеспечения доступа к списку задач в репозитории */
    private TaskRepo taskRepo;
    /**Поле для внедрения зависимости */
    private TaskAccount taskAccount;
    /**Поле для внедрения зависимости */
    private ReadString readString;


    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param taskRepo - репозиторий задач
     * @param taskAccount - задача
     * @param readString - ввод данных от пользователя
     */
    public EditNameTask(TaskRepo taskRepo, TaskAccount taskAccount, ReadString readString) {
        this.taskRepo = taskRepo;
        this.taskAccount = taskAccount;
        this.readString = readString;
    }


    /**
     * Метод для редактирования имени задачи
     * @param id идентификатор задачи
     */
    @Override
    public void editTaskById(TaskRepo taskRepo,int id) {
        taskAccount = taskRepo.getTaskAccountById(id);
        System.out.println("Введите новое имя задачи");
        String newName = readString.readStringFromUser();
        taskAccount.setName(newName);
        System.out.println("Параметр name задачи с id: " + taskAccount.getId() + " был изменен." + " Новое имя: " + taskAccount.getName());

    }
}


