package in;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для чтения строки с проверкой
 * @author Sani4
 * @version 1.0
 */

public class ReadString {

    private Scanner scanner;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param  scanner - объект класса scanner для ввода данных от пользователя
     */
    public ReadString(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Метод для ввода строки
     */
    public String readStringFromUser(){

        String userInput;
        System.out.println("Введите строку:");
        userInput = checkUserInput(scanner);
        return userInput;

    }

    /**
     * Метод для ввода строки с проверкой
     * @param scanner экземпляр класса Scanner для ввода
     * @return  пользовательский ввод (строку)
     */

    public  String  checkUserInput(Scanner scanner) {
        String userInput;
        do {
            if(!scanner.hasNextLine()){
                System.out.println("Повторите ввод");
                scanner.nextLine();
            }
        } while (!scanner.hasNextLine());
        userInput = scanner.nextLine();
        System.out.println("Спасибо! Вы ввели строку " + userInput);
        return  userInput;
    }

}
