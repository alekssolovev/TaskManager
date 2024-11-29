package out.service;

import entity.TaskAccount;
import in.InputDate;
import in.ReadString;
import out.repositories.CreateInterface;
import out.repositories.TaskRepo;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс содержит метод для создания задачи
 * @author Sani4
 * @version 1.0
 */
public class CreateTask implements CreateInterface {
    /**Поле для обеспечения доступа к списку задач в репозитории */
    private TaskRepo taskRepo;
    /**Поле для внедрения зависимости */
    private TaskAccount taskAccount;
    /**Поле для внедрения зависимости */
    private InputDate inputDate;
    /**Поле для внедрения зависимости */
    private ReadString readString;
    /**Поле для внедрения зависимости */
    private Scanner scanner;
    /**Поле для внедрения зависимости */
    private SaveTask saveTask;

    private String filePath;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param taskRepo - репозиторий задач
     * @param inputDate - ввод даты от пользователя
     * @param readString - ввод данных от пользователя
     * @param  scanner - объект класса scanner
     */
    public CreateTask(TaskRepo taskRepo, InputDate inputDate, ReadString readString, Scanner scanner, String filePath) {
        this.taskRepo = taskRepo;
        this.inputDate = inputDate;
        this.readString = readString;
        this.scanner = scanner;
        this.filePath=filePath;
    }

    /**
     * Метод для создания задачи
     * @param scanner обеспечивает ввод данных
     * @throws ParseException исключение при обработке даты введенной пользователем программы
     */
    @Override
    public void create(Scanner scanner) throws ParseException, IOException {
        scanner = new Scanner(System.in);
        int id;
        taskAccount = new TaskAccount(null,null,null,null,null,null);
        if(taskRepo.getTaskAccounts().isEmpty())
            taskRepo.setTaskAccounts(new ArrayList<TaskAccount>());
        taskRepo.getTaskAccounts().add(taskAccount);

        if(taskRepo.getTaskAccounts().size()==1)
            id = taskRepo.getTaskAccounts().size();
        else
            id = taskRepo.getTaskAccounts().size()+1;
        taskAccount.setId(id);
        System.out.println("Введите дату выполнения");
        taskAccount.setDateOfExec(inputDate.inputDateFromUser(scanner));
        System.out.println("Введите имя задачи");

        taskAccount.setName(readString.readStringFromUser());
        System.out.println("Введите имя владельца задачи");
        taskAccount.setOwner(readString.readStringFromUser());
        System.out.println("Введите описание задачи");
        taskAccount.setDescription(readString.readStringFromUser());
        taskAccount.setStatus(false);
        System.out.println("Статус задачи по умолчанию false отредактируйте задачу для изменения");
        System.out.println("id задачи "+taskAccount.getName()+" равен " + taskAccount.getId());
        saveTask = new SaveTask(taskRepo);
        saveTask.save(taskRepo,filePath);
        System.out.println("Был создан " + taskAccount);
    }
}
