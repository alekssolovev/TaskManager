package out.service;

import entity.TaskAccount;
import out.repositories.TaskRepo;


/**
 * Класс для анализа списка задач и вывода в консоль статистики
 * @author Sani4
 * @version 1.0
 */
public class TaskAnalysis {
    /**Поле для внедрения зависимости  */
    private TaskRepo taskRepo;
    /**Поле для внедрения зависимости  */
    private TaskAccount taskAccount;


    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param taskRepo - репозиторий задач
     */
    public TaskAnalysis(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }


    /**
     * Метод для вывода задач со статусом true или false (завершенные и незавершенные)
     */
    public void displayTaskStat(){
        int totalTasks = 0;
        try { totalTasks = taskRepo.getTaskAccounts().size();}
        catch(Exception e){
            System.out.println("Репозиторий задач пустой, перезапустите программу");
            System.exit(0);
        }
        System.out.println("Общее кол-во задач: " + totalTasks);

        long countIfTrue = taskRepo.getTaskAccounts().stream()
                .filter(taskAccount1 -> taskAccount1.getStatus()==true).count();
        System.out.println("Количество завершенных задач: " + countIfTrue);

        long countIfFalse = taskRepo.getTaskAccounts().stream()
                .filter(taskAccount1 -> taskAccount1.getStatus()==false).count();

        System.out.println("Количество незавершенных задач: " + countIfFalse);


    }


}
