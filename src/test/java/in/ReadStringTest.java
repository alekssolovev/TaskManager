package in;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ReadStringTest {

    @Mock
    Scanner scanner ;


    @InjectMocks
    ReadString readString;

    @Test
    public void  readStringFromUser(){
        // Перенаправление ввода с консоли
        String simulatedInputStr = "Test str";
        ByteArrayInputStream inStr = new ByteArrayInputStream(simulatedInputStr.getBytes());
        System.setIn(inStr);
        // Чтение данных (например, через Scanner или другой метод)
        scanner = new Scanner(System.in);
        readString = new ReadString(scanner);
        String testString = readString.readStringFromUser();

        Assertions.assertEquals(simulatedInputStr, testString);

    }

    @Test
    public void  checkUserInputIfNull(){
        Assertions.assertThrows(NullPointerException.class, () -> readString.checkUserInput(null));
    }

    @Test
    public void  checkUserInputIfNotNull(){
        String simulatedInputStr = "Test str";
        ByteArrayInputStream inStr = new ByteArrayInputStream(simulatedInputStr.getBytes());
        System.setIn(inStr);

        scanner = new Scanner(System.in);
        readString = new ReadString(scanner);

        String testStr = readString.checkUserInput(scanner);

        Assertions.assertEquals(simulatedInputStr, testStr);
    }

}
