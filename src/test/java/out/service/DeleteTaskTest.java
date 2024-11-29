package out.service;

import entity.TaskAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import out.repositories.TaskRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class DeleteTaskTest {

    @Mock
    private TaskAccount taskAccount;
    private TaskAccount taskAccount2;
    private TaskRepo taskRepo;
    private String filePath;

    @InjectMocks
    private DeleteTask deleteTask;

    @BeforeEach
    public void setUp() {

        taskAccount = new TaskAccount(1,"Name1", "Task1",true,new Date(),"owner1");
        taskAccount2 = new TaskAccount(2,"Name2", "Task2",true,new Date(),"owner2");
        ArrayList<TaskAccount> taskAccounts = new ArrayList<>();
        taskAccounts.add(taskAccount);
        taskAccounts.add(taskAccount2);
        taskRepo = new TaskRepo(taskAccounts);
        filePath = "tempFile";

    }

    @Test
    public void delete() throws IOException {
        deleteTask = new DeleteTask(taskRepo,filePath);
        deleteTask.delete(1);

        Assertions.assertFalse(taskRepo.getTaskAccounts().contains(taskAccount));

    }


}
