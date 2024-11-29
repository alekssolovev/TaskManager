package out.service;


import entity.TaskAccount;
import in.ReadString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import out.repositories.TaskRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


@ExtendWith(MockitoExtension.class)
public class EditStatusTaskTest {

    @Mock
    private TaskRepo taskRepo;
    private TaskAccount taskAccount;
    private ReadString readString;

    @InjectMocks
    private EditStatusTask editStatusTask;

    @BeforeEach
    public void setUp() {
         taskAccount = new TaskAccount(1,"Name1", "Task1",true,new Date(),"owner1");
         ArrayList<TaskAccount> taskAccounts = new ArrayList<>();
         taskAccounts.add(taskAccount);
         taskRepo = new TaskRepo(taskAccounts);
    }

    @Test
    public void editTaskById(){

        String simulatedInput = "false";

        Scanner scanner = new Scanner(simulatedInput);
        readString = new ReadString(scanner);

        editStatusTask = new EditStatusTask(taskRepo,taskAccount,readString);
        editStatusTask.editTaskById(taskRepo,1);

        Assertions.assertFalse(taskAccount.getStatus());


    }



}
