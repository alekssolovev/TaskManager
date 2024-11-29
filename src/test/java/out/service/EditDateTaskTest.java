package out.service;

import entity.TaskAccount;
import in.InputDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import out.repositories.TaskRepo;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class EditDateTaskTest {

    @Mock
    private TaskRepo taskRepo;
    private TaskAccount taskAccount;
    private InputDate inputDate;
    private Scanner scanner;

    @InjectMocks
    private EditDateTask editDateTask;

    @BeforeEach
    public void setUp() throws ParseException {
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2024");
        String simulatedInput = "01\n02\n2024\n";
        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        scanner = new Scanner(System.in);
        inputDate = new InputDate(scanner);
        taskAccount = new TaskAccount(1,"Name1", "Task1",true,date1 ,"owner1");
        ArrayList<TaskAccount> taskAccounts = new ArrayList<>();
        taskAccounts.add(taskAccount);
        taskRepo = new TaskRepo(taskAccounts);

    }

    @Test
    public void editTaskById() throws ParseException {

        Date newDate1 = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2024");

        editDateTask = new EditDateTask(taskRepo,taskAccount,inputDate,scanner);
        editDateTask.editTaskById(taskRepo,1);

        Assertions.assertTrue(taskAccount.getDateOfExec().compareTo(newDate1)==0);


    }
}
