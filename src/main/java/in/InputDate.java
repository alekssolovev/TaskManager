package in;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/**
 * Класс для обеспечения ввода даты
 * @author Sani4
 * @version 1.0
 */
public class InputDate {

    private Scanner scanner;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param  scanner - объект класса scanner для ввода данных от пользователя
     */
    public InputDate(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Метод для ввода даты
     * @param scanner для ввода даты в методе
     * @return  дату, объект класса date
     * @throws ParseException обработки даты введенной от пользователя
     */
    public  Date  inputDateFromUser(Scanner scanner) throws ParseException {
        System.out.println("Введите дату в формате дата/месяц/год");
        System.out.println("Введите дату:");
        int dateInp, monthInp, yearInp;
        dateInp = checkUserDateInput(scanner);
        System.out.println("Введите месяц:");
        monthInp = checkUserDateInput(scanner);
        System.out.println("Введите год:");
        yearInp = checkUserDateInput(scanner);

        String strToDate = dateInp + "-" + monthInp + "-"+ yearInp;
        System.out.println(strToDate);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(strToDate);
        System.out.println(date);
        return date;

    }

    /**
     * Метод для ввода числа с проверкой
     * @param scanner для ввода числа в методе
     * @return строку от пользователя
     */
     int checkUserDateInput(Scanner scanner) {
        String userInput;
        do {
            if(!scanner.hasNextInt()){
                System.out.println("Повторите ввод");
                scanner.nextLine();}
        }while (!scanner.hasNextInt());
        userInput = scanner.nextLine();
        int intInp = Integer.parseInt(userInput);
        System.out.println("Спасибо! Вы ввели число " + intInp);
        return  intInp;


    }
}
