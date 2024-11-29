package out.repositories;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


/**
 *  Интерфейс содержит переопределяемый метод для создания задачи
 * @author Sani4
 * @version 1.0
 */
public interface CreateInterface {

    public void create(Scanner scanner) throws ParseException, IOException;

}
