package out.service;

import entity.TaskAccount;
import in.ReadString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import out.repositories.TaskRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class EditNameTaskTest {

    @Mock
    private TaskRepo taskRepo;
    private TaskAccount taskAccount;
    private ReadString readString;

    @InjectMocks
    private EditNameTask editNameTask;

    @BeforeEach
    public void setUp() {

        taskAccount = new TaskAccount(1,"Name1", "Task1",true,new Date(),"owner1");
        ArrayList<TaskAccount> taskAccounts = new ArrayList<>();
        taskAccounts.add(taskAccount);
        taskRepo = new TaskRepo(taskAccounts);

    }

    @Test
    public void editTaskById(){

        String simulatedInput = "newName1";

        Scanner scanner = new Scanner(simulatedInput);
        readString = new ReadString(scanner);

        editNameTask = new EditNameTask(taskRepo,taskAccount,readString);
        editNameTask.editTaskById(taskRepo,1);

        Assertions.assertTrue(simulatedInput.equals(taskAccount.getName()));

    }


}
