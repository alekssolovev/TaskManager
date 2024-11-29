package out.service;

import entity.TaskAccount;
import in.InputDate;
import in.ReadString;
import out.repositories.TaskRepo;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * Класс для чтения задач
 * @author Sani4
 * @version 1.0
 */
public class ReadTask {
    /**
     * Поле для внедрения зависимости
     */
    private TaskRepo taskRepo;
    /**
     * Поле для внедрения зависимости
     */
    private TaskAccount taskAccount;
    /**
     * Поле для внедрения зависимости
     */
    private ReadString readString;
    /**
     * Поле для внедрения зависимости
     */
    private InputDate inputDate;
    /**
     * Поле для внедрения зависимости
     */
    private Scanner scanner;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     *
     * @param taskRepo    - репозиторий задач
     * @param inputDate   - ввод даты от пользователя
     * @param readString  - ввод данных от пользователя
     * @param scanner     - объект класса scanner
     */
    public ReadTask(TaskRepo taskRepo, ReadString readString, InputDate inputDate, Scanner scanner) {
        this.taskRepo = taskRepo;
        this.readString = readString;
        this.inputDate = inputDate;
        this.scanner = scanner;
    }


    /**
     * Метод, который вызывает нужный метод для фильтрации задач
     *
     * @throws ParseException обработка исключений при парсинге даты от пользователя
     */
    public void choice() throws ParseException {
        System.out.println("Выберите способ фильтрации ");
        System.out.println("1.По статусу\n2.По дате ");
        String inp = readString.readStringFromUser();
        if (inp.equals("1"))
            displayTaskByStatus();
        else if (inp.equals("2")) {
            displayTaskByDate();
        } else System.out.println("Неверный ввод");

    }


    /**
     * Метод который показывает задачи с заданным статусом
     */
    public void displayTaskByStatus() {
        System.out.println("Введите статус задачи завершенная(true) или незавершенная(false)  ");
        String choice = readString.readStringFromUser();

            boolean  inpStatus;
            switch (choice) {
                case "true":
                    inpStatus = true;
                    List<TaskAccount> newList1 = taskRepo.getTaskAccounts().stream()
                            .filter(taskAccount -> taskAccount.getStatus() == inpStatus)
                            .collect(Collectors.toList());
                    if(newList1.isEmpty())
                        System.out.println("Нет задач со статусом true");
                    else
                        System.out.println(newList1);
                    break;
                case "false":
                    inpStatus = false;
                    List<TaskAccount> newList2 = taskRepo.getTaskAccounts().stream()
                            .filter(taskAccount -> taskAccount.getStatus() == inpStatus)
                            .collect(Collectors.toList());
                    if(newList2.isEmpty())
                        System.out.println("Нет задач со статусом false");
                    else
                        System.out.println(newList2);
                    break;
                default:
                    System.out.println("Выберите пункт 2 и повторите ввод(true или  false)");

            }
        }




    /**
     * Метод который показывает задачи с заданной датой создания
     */
    public void displayTaskByDate() throws ParseException {

        System.out.println("Введите дату создания задачи для вывода в консоль");

        Date inpDate = inputDate.inputDateFromUser(scanner);

        List<TaskAccount> newList = taskRepo.getTaskAccounts().stream()
                .filter(taskAccount->taskAccount.getDateOfExec().compareTo(inpDate)==0)
                .collect(Collectors.toList());
        if(newList.isEmpty())
            System.out.println("Нет задач с заданной датой");
        else
            System.out.println(newList);

    }

}



