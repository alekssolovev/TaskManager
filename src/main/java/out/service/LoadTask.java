package out.service;

import out.repositories.LoadTaskInterface;
import out.repositories.TaskRepo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Класс содержит метод для сохранения задачи
 * @author Sani4
 * @version 1.0
 */
public class LoadTask implements LoadTaskInterface {

    /**Поле для внедрения зависимости  */
    private TaskRepo taskRepo;
    /**Поле для внедрения зависимости  */
    //private Path path;

    private String filePath;

    /**
     * Конструктор - загрузка десериализованного репозитория с определенными значениями
     */
    public LoadTask(String filePath) {
        this.filePath = filePath;
    }


    /**
     * Метод, который вызывает нужный метод для фильтрации задач
     * @throws IOException обработка исключений в системе вывода
     * @return возвращаем репозиторий задач
     */
    @Override
    public TaskRepo  load() throws IOException {
        FileInputStream fis;
        try{fis = new FileInputStream(filePath);}
        catch(FileNotFoundException e){
            fis = new FileInputStream(filePath);
        }
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            taskRepo= (TaskRepo) ois.readObject();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
        return  taskRepo;

    }
}
