import entity.TaskAccount;
import in.InputDate;
import in.ReadString;

import out.repositories.TaskRepo;
import out.service.*;

import java.io.EOFException;

import java.io.IOException;

import java.text.ParseException;
import java.util.*;



public class Main {
    public static void main(String[] args) throws ParseException, IOException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<TaskAccount> tasks = new ArrayList<>();


        InputDate inputDate = new InputDate(scanner);
        ReadString readString = new ReadString(scanner);

        System.out.println("Введите абсолютный путь к директории для сохранения файла");
        String filePath = readString.readStringFromUser();

        TaskRepo taskRepo;
        LoadTask loadTask = new LoadTask(filePath);

        try {
            taskRepo = new TaskRepo(loadTask.load().getTaskAccounts());
        }catch (EOFException e){
            taskRepo = new TaskRepo(tasks);
            SaveTask saveTask = new SaveTask(taskRepo);
            saveTask.save(taskRepo,filePath);
        }

        CreateTask createTask = new CreateTask(taskRepo,inputDate,readString,scanner,filePath);
        ReadTask readTask = new ReadTask(taskRepo,readString,inputDate,scanner);
        EditTask editTask = new EditTask(taskRepo,inputDate,readString,scanner);
        DeleteTask deleteTask = new DeleteTask(taskRepo,filePath);
        SearchTask searchTask = new SearchTask(taskRepo);
        TaskAnalysis taskAnalysis = new TaskAnalysis(taskRepo);

        String userInp;
        Integer inp;


        do{
            Menu.displayMenu();
            userInp = readString.readStringFromUser();
            int idForDel;
            try{inp = Integer.parseInt(userInp);}
            catch(NumberFormatException e){
                inp = 8;
            }
            switch (inp){
                case 1:
                    createTask.create(scanner);
                    break;
                case 2:
                    readTask.choice();
                    break;
                case 3:
                    int idForEdit;
                    System.out.println("Введите id задачи: ");
                    try { idForEdit = Integer.parseInt(readString.readStringFromUser());
                        TaskAccount taskAccount = taskRepo.getTaskAccountById(idForEdit);
                        if(taskAccount == null){
                            System.out.println("Задачи с таким id не существует");
                            break;
                        }
                    }
                    catch (NumberFormatException e){
                        break;
                    }
                    System.out.println("Введите date для изменения даты,description для описания, name для имени и status для статуса");
                    String varParam = readString.readStringFromUser();
                    try {
                        editTask.editTask(varParam,idForEdit,filePath);
                    }catch (NullPointerException | NoSuchElementException e){
                        System.out.println("Неверный ввод или id задачи");
                        break;
                    }

                case 4:
                    System.out.println("Введите id задачи: ");
                    idForDel = Integer.parseInt(readString.readStringFromUser());
                    deleteTask.delete(idForDel);
                    break;
                case 5:
                    System.out.println("Введите паттерн для поиска задачи ");
                    String pattern = readString.readStringFromUser();
                    searchTask.searchByPattern(pattern);
                    break;
                case 6:
                    taskAnalysis.displayTaskStat();
                    break;
                default:
                    System.out.println("Выход");

            }

        } while (inp >=1 && inp < 7);


    }
}
