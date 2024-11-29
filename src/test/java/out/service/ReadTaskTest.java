package out.service;

import entity.TaskAccount;
import in.InputDate;
import in.ReadString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import out.repositories.TaskRepo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class ReadTaskTest {

    @Mock
    private TaskRepo taskRepo;

    private TaskAccount taskAccount;

    private ReadString readString;

    private InputDate inputDate;

    private Scanner scanner;
    

    @InjectMocks
    private ReadTask readTask;

    @BeforeEach
    public void setUp() {

        taskRepo = mock(TaskRepo.class);
        inputDate = mock(InputDate.class);
        readString = mock(ReadString.class);
        taskAccount = mock(TaskAccount.class);
        scanner = mock(Scanner.class);

    }

    @Test
    public void choiceCase1() throws ParseException {


        String simulatedInput = "1";

        Scanner scanner1 = new Scanner(simulatedInput);
        ReadString readString1 = new ReadString(scanner1);
        ReadTask newReadTask = new ReadTask(taskRepo, readString1, inputDate, scanner);


        Assertions.assertThrows(NoSuchElementException.class,() -> newReadTask.choice());

    }

    @Test
    public void choiceCase2() throws ParseException{

        String simulatedInput = "test inp";

        Scanner scanner1 = new Scanner(simulatedInput);
        ReadString readString1 = new ReadString(scanner1);
        ReadTask newReadTask = new ReadTask(taskRepo, readString1, inputDate, scanner);

        newReadTask.choice();

    }

    @Test
    public void displayTaskByStatus(){
        String simulatedInput = "true";

        Scanner scanner1 = new Scanner(simulatedInput);

        ReadString readString1 = new ReadString(scanner1);

        ArrayList<TaskAccount> taskAccounts1 = new ArrayList<>();


        TaskAccount taskAccount1 = new TaskAccount(1,"newName1", "new task1",true,new Date(),"owner1");
        TaskAccount taskAccount2 = new TaskAccount(2,"newName2", "new task2",false,new Date(),"owner2");

        taskAccounts1.add(taskAccount1);
        taskAccounts1.add(taskAccount2);

        TaskRepo taskRepo1 = new TaskRepo(taskAccounts1);

        ReadTask readTask1 = new ReadTask(taskRepo1, readString1, inputDate, scanner);

        readTask1.displayTaskByStatus();




    }

    @Test
    public void displayTaskByDate() throws ParseException{

        when(inputDate.inputDateFromUser(any(Scanner.class))).thenReturn(new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2024"));

        Date newDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2024");

        Date newDate2 = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2024");

        ArrayList<TaskAccount> taskAccounts2 = new ArrayList<>();


        TaskAccount taskAccount1 = new TaskAccount(1,"newName1", "new task1",true,newDate1,"owner1");
        TaskAccount taskAccount2 = new TaskAccount(2,"newName2", "new task2",false,newDate2,"owner2");

        taskAccounts2.add(taskAccount1);
        taskAccounts2.add(taskAccount2);

        TaskRepo taskRepo1 = new TaskRepo(taskAccounts2);

        ReadTask newReadTask = new ReadTask(taskRepo1, readString, inputDate, scanner);

        newReadTask.displayTaskByDate();


    }


}
