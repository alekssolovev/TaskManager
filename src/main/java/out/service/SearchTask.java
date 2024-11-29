package out.service;

import entity.TaskAccount;
import out.repositories.SearchInterface;
import out.repositories.TaskRepo;

/**
 * Класс для поиска задач
 * @author Sani4
 * @version 1.0
 */
public class SearchTask  implements SearchInterface {
    /**Поле для внедрения зависимости  */
    private TaskRepo taskRepo;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param taskRepo - репозиторий задач
     */
    public SearchTask(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    /**
     * Метод, который вызывает нужный метод для фильтрации задач
     * @param search паттерн для поиска задачи по имени или описанию
     */
    @Override
    public void searchByPattern(String search) {
        taskRepo.getTaskAccounts().stream()
                 .filter(taskAccount1 -> taskAccount1.getName().contains(search))
                  .forEach(taskAccount1 -> System.out.println("Результат поиска в названии:\n" + taskAccount1));

        taskRepo.getTaskAccounts().stream()
                .filter(taskAccount1 -> taskAccount1.getDescription().contains(search))
                .forEach(taskAccount1 -> System.out.println("Результат поиска в описании:\n" + taskAccount1));
    }

}
