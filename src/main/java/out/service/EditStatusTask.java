package out.service;

import entity.TaskAccount;
import in.ReadString;
import out.repositories.EditInterface;
import out.repositories.TaskRepo;

/**
 * Класс для редактирования статуса задачи
 * @author Sani4
 * @version 1.0
 */
public class EditStatusTask  implements EditInterface {
    /**Поле для обеспечения доступа к списку задач в репозитории */
    private TaskRepo taskRepo;
    /**Поле для внедрения зависимости  */
    private TaskAccount taskAccount;
    /**Поле для внедрения зависимости  */
    private ReadString readString;



    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param taskRepo - репозиторий задач
     * @param taskAccount - задача
     * @param readString - ввод данных от пользователя
     */
    public EditStatusTask(TaskRepo taskRepo, TaskAccount taskAccount, ReadString readString) {
        this.taskRepo = taskRepo;
        this.taskAccount = taskAccount;
        this.readString = readString;
    }


    /**
     * Метод для редактирования статуса задачи
     * @param id идентификатор задачи
     */
    @Override
    public void editTaskById(TaskRepo taskRepo,int id) {
        taskAccount = taskRepo.getTaskAccountById(id);
        System.out.println("Введите новый статус задачи");
        System.out.println("введите true или false");
        String userInput = readString.readStringFromUser();
        while (!(userInput.equals("true") || userInput.equals("false"))) {
            userInput = readString.readStringFromUser();
        }
        Boolean newStatus = Boolean.parseBoolean(userInput);
        taskAccount.setStatus(newStatus);
        System.out.println("Статус  задачи с id: " + taskAccount.getId() + " был изменен на " + taskAccount.getStatus());

    }
}
