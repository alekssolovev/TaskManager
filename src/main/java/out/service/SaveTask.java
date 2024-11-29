package out.service;


import out.repositories.SaveTaskInterface;
import out.repositories.TaskRepo;

import java.io.*;
import java.nio.file.Path;


/**
 * Класс содержит метод для сохранения задачи
 * @author Sani4
 * @version 1.0
 */
public class SaveTask implements SaveTaskInterface {
    /**Поле для внедрения зависимости  */
    private TaskRepo taskRepo;

    /**
     * Конструктор - сохрание нового репозитория с определенными значениями
     * @param taskRepo - репозиторий задач
     */
    public SaveTask(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    /**
     * Метод, который вызывает нужный метод для фильтрации задач
     * @throws IOException обработка исключений в системе вывода
     * @param tasks репозиторий задач
     */
    public void save(TaskRepo tasks,String filePath) throws IOException {

        FileOutputStream fos = new FileOutputStream(String.valueOf(Path.of(filePath)));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(tasks);
        oos.close();
    }

}
