package in;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputDateTest {

    @Mock
    Scanner scanner;


    @InjectMocks
    InputDate inputDate =  new InputDate(scanner);


    @Test
    public void inputDateFromUser() throws ParseException {
        // Перенаправление ввода с консоли
        String simulatedInput = "11\n11\n2024\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        scanner = new Scanner(System.in);
        Date date = inputDate.inputDateFromUser(scanner);

        Assertions.assertNotNull(date);
        Assertions.assertInstanceOf(Date.class, date);
    }


    @Test
    public void checkUserDateInputIfInt(){
        // Перенаправление ввода с консоли
        String simulatedInputInt = "1";
        ByteArrayInputStream inInt = new ByteArrayInputStream(simulatedInputInt.getBytes());
        System.setIn(inInt);

        // Чтение данных (например, через Scanner или другой метод)
        scanner = new Scanner(System.in);
        int testInp = inputDate.checkUserDateInput(scanner);
        scanner.close();

        //Integer outputInt = inputDate.checkUserInput(scanner);
        Assertions.assertTrue(testInp == 1);
    }

    @Test
    public void checkUserDateInputIfStr() {
        String simulatedInputStr = "Test input str!";

        ByteArrayInputStream inStr = new ByteArrayInputStream(simulatedInputStr.getBytes());
        System.setIn(inStr);

        scanner = new Scanner(System.in);

        //Проверяем что метод checkUserDateInput() кидает правильное исключение.
        Assertions.assertThrows(NoSuchElementException.class, () ->inputDate.checkUserDateInput(scanner) );
    }

}
