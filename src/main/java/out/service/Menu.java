package out.service;


/**
 * Класс содержит метод для отображения меню
 * @author Sani4
 * @version 1.0
 */
public class Menu {

    /**
     * Метод, который выводит пункты меню в консоль
     */
    public static void displayMenu() {
        System.out.println("Нажмите от 1 до 6 для выбора пунка в меню или другой символ для выхода");
        System.out.println("1 Добавить задачу");
        System.out.println("2 Просмотреть задачи");
        System.out.println("3 Редактировать задачу");
        System.out.println("4 Удалить задачу");
        System.out.println("5 Поиск задачи");
        System.out.println("6 Вывести статистику");
    }

}
